/**
 * 
 */
package org.edu.uams.client.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.form.LoginForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.api.EmailDTO;
import org.edu.uams.server.api.UserContext;
import org.edu.uams.server.business.AdminDao;
import org.edu.uams.server.business.UserMasterDao;
import org.edu.uams.server.pojo.AdminEntity;
import org.edu.uams.server.pojo.UserMasterEntity;
import org.edu.uams.server.util.SendMail;
import org.edu.uams.server.util.SessionTracker;


public class LoginAction extends DispatchAction {



	//Check for Admin login
	public ActionForward checkAdminLoginDetails(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		LoginForm loginForm = (LoginForm)form;

		AdminDao adminDao = new AdminDao();


		AdminEntity adminEntity =adminDao.findByAdminLoginName(loginForm.getUserName(),loginForm.getPassword());
		if (adminEntity!=null) {
			populateAdmindetails(loginForm, adminEntity);

			UserContext userContext=new UserContext(adminEntity.getId(), adminEntity.getAdminName(),true,loginForm,"ADMIN");
			SessionTracker.registerUser(req, userContext);
			return mapping.findForward("adminPage");
		}

		else{
			loginForm.setLoginMessage("No User Found of this User Name:"+loginForm.getUserName()+
					"\n Please Check your User Name and Password");
			return mapping.findForward("noUserFound");
		}
			}

	//Check for user login
	public ActionForward checkLoginDetails(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		LoginForm loginForm = (LoginForm)form;

		UserMasterDao userMasterDao = new UserMasterDao();


		UserMasterEntity userMasterEntity =userMasterDao.findByLoginName(loginForm.getUserName(),loginForm.getPassword());
		if (userMasterEntity!=null) {
			populateUserDetails(loginForm, userMasterEntity);


			UserContext userContext=new UserContext(userMasterEntity.getUserId(), userMasterEntity.getEmail(),false,loginForm,userMasterEntity.getUserMasterType().getValue());
			SessionTracker.registerUser(req, userContext);

			if (userMasterEntity.getUserMasterType().getValue().equals(ApplicationConstants.PROFESSOR)) {
				return mapping.findForward("professorPage");
			}
			else {
				return mapping.findForward("studentPage");
			}
		}

		else{
			loginForm.setLoginMessage("No User Found of this User Name:"+loginForm.getUserName()+
					"\n Please Check your User Name and Password");
			return mapping.findForward("noUserFound");
		}
			}

	private void populateUserDetails(LoginForm loginForm,
			UserMasterEntity userMasterEntity) {
		loginForm.setName(userMasterEntity.getFirstName()+" "+userMasterEntity.getLastName());
		loginForm.setGender(userMasterEntity.getGender());
		loginForm.setEmail(userMasterEntity.getEmail());
		loginForm.setPassword(userMasterEntity.getPassWord());
		loginForm.setAddress(userMasterEntity.getAddressLine1());
		loginForm.setUserId(userMasterEntity.getUserId());
		loginForm.setCity(userMasterEntity.getCity());
		loginForm.setState(userMasterEntity.getState());
		loginForm.setUserType(userMasterEntity.getUserMasterType().getValue());
	}






	public ActionForward adminLoginPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		LoginForm loginForm = (LoginForm)form;


		if (SessionTracker.checkLoginContext(req)!=null) {
			UserContext userContext = SessionTracker.checkLoginContext(req);
			if (userContext.isAdmin()) {
				AdminDao adminDao = new AdminDao();
				AdminEntity adminEntity =adminDao.findByPrimaryKey(userContext.getUserId());
				if (adminEntity!=null) {
					populateAdmindetails(loginForm, adminEntity);

				}
				return mapping.findForward("adminPage");
			}
			else{
				if (userContext.getLoginForm().getUserType().equals(ApplicationConstants.PROFESSOR)) {
					return mapping.findForward("professorPage");
				}
				else {
					return mapping.findForward("studentPage");
				}
			}

		}
		else{
			return mapping.findForward("adminLoginPage");
		}


			}



	public ActionForward userLoginPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		LoginForm loginForm = (LoginForm)form;

		if (SessionTracker.checkLoginContext(req)!=null) {
			UserContext userContext = SessionTracker.checkLoginContext(req);
			if (userContext.isAdmin()) {
				AdminDao adminDao = new AdminDao();
				AdminEntity adminEntity =adminDao.findByPrimaryKey(userContext.getUserId());
				if (adminEntity!=null) {
					populateAdmindetails(loginForm, adminEntity);

				}
				return mapping.findForward("adminPage");
			}
			else{
				UserMasterDao userMasterDao = new UserMasterDao();
				UserMasterEntity userMasterEntity = userMasterDao.findByPrimaryKey(userContext.getUserId());
				if (userMasterEntity!=null) {
					populateUserDetails(loginForm, userMasterEntity);
				}

				if (userContext.getLoginForm().getUserType().equals(ApplicationConstants.PROFESSOR)) {
					return mapping.findForward("professorPage");
				}
				else {
					return mapping.findForward("studentPage");
				}
			}
		}
		else{
			return mapping.findForward("userLoginPage");
		}
			}


	public ActionForward logOutAction(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		LoginForm loginForm = (LoginForm)form;


		if (SessionTracker.checkLoginContext(req)!=null) {
			UserContext userContext = SessionTracker.checkLoginContext(req);
			if (userContext.isAdmin()) {
				SessionTracker.logOut(req);
				loginForm.clearFormValues();
				return mapping.findForward("adminLoginPage");
			}

			else {
				SessionTracker.logOut(req);
				loginForm.clearFormValues();
				return mapping.findForward("userLoginPage");
			}
		}

		else{
			return mapping.findForward("userLoginPage");
		}
			}





	public ActionForward forgotPassWordAction(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		LoginForm loginForm = (LoginForm)form;


		AdminDao adminDao = new AdminDao();
		AdminEntity adminEntity =adminDao.findAdminName(loginForm.getUserName());

		UserMasterDao userMasterDao = new UserMasterDao();
		UserMasterEntity userMasterEntity =userMasterDao.findUserName(loginForm.getUserName());


		String toEmailAdress=null;
		if (adminEntity!=null && adminEntity.getEmail()!=null) {
			toEmailAdress=adminEntity.getEmail();
			String name=adminEntity.getAdminName();
			String passWord=adminEntity.getPassWord();
			sendPassWordAction(passWord, toEmailAdress, name);
			loginForm.setLoginMessage("Your Password Details have been mailed to your E-mail Id");
			return mapping.findForward("userFound");
		}
		else if (userMasterEntity!=null && userMasterEntity.getEmail()!=null){
			toEmailAdress=userMasterEntity.getEmail();
			String name=userMasterEntity.getFirstName()+ "  " +userMasterEntity.getLastName();
			String passWord=userMasterEntity.getPassWord();
			sendPassWordAction(passWord, toEmailAdress, name);
			loginForm.setLoginMessage("Your Password Details have been mailed to your E-mail Id");
			return mapping.findForward("userFound");
		}
		else{
			loginForm.setLoginMessage("No User Found of this User Name:"+loginForm.getUserName());
			return mapping.findForward("noUserFound");

		}
			}
	
	
	
	public ActionForward forgotPassWordPageAction(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		return mapping.findForward("forgotPassWordPage");
			}

	private void sendPassWordAction(String passWord,
			String toEmailAdress, String name) {

	
		String subject="V learning Password";
		String emailBody="Hi " + name + " ,\n  Please find your password below \n \n"
				+ passWord;
		EmailDTO dto=new EmailDTO( toEmailAdress, subject, emailBody);
		SendMail.sendMail(dto);
	}






	private void populateAdmindetails(LoginForm loginForm,
			AdminEntity adminEntity) {
		loginForm.setName(adminEntity.getAdminName());
		loginForm.setPassword(adminEntity.getPassWord());
		loginForm.setUserId(adminEntity.getId());
		loginForm.setEmail(adminEntity.getEmail());
	}



}