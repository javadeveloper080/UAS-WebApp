/**
 * 
 */
package org.edu.uams.client.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.form.DisplayMessageForm;
import org.edu.uams.client.form.LoginForm;
import org.edu.uams.client.form.UserForm;
import org.edu.uams.server.business.UserMasterDao;
import org.edu.uams.server.business.UserMasterTypeDao;
import org.edu.uams.server.pojo.UserMasterEntity;
import org.edu.uams.server.util.ApplicationUtil;

/**
 * @author Syed Yaseer
 *
 */
public class UserAction extends DispatchAction {


//	public ActionForward registerUser(ActionMapping mapping,ActionForm form,
//			HttpServletRequest req,HttpServletResponse res)throws Exception
//			{
//		UserForm userForm = (UserForm)form;
//		UsersRoleTypeDao userMasterTypeDao = new UsersRoleTypeDao();
//
//		List<UserMasterTypeEntity> userTypeList = userMasterTypeDao.findAll();
//
//		userForm.setUserTypeList(userTypeList);
//
//		return mapping.findForward("userRegister");
//
//			}




	public ActionForward userRegistrationAction(ActionMapping mapping,ActionForm form,
			HttpServletRequest req,HttpServletResponse res)throws Exception{

		UserForm userForm = (UserForm)form;

		UserMasterDao userMasterDao = new UserMasterDao();
		UserMasterEntity userMasterEntity=new UserMasterEntity();
		setValues(userForm, userMasterEntity);
		userMasterEntity=userMasterDao.persist(userMasterEntity);
		if (userMasterEntity.getId()>0) {
			DisplayMessageForm displayMessageForm=new DisplayMessageForm();
			displayMessageForm.setMessage("Congrats registration sucessfull. please login");
			req.setAttribute("displayMessageForm", displayMessageForm);
			return mapping.findForward("registrationSuccess");	
		}
		else{
			
			DisplayMessageForm displayMessageForm=new DisplayMessageForm();
			displayMessageForm.setMessage("Registarion failed. please contact admin");
			req.setAttribute("displayMessageForm", displayMessageForm);
			return mapping.findForward("registrationFail");

		}
	}




	private void setValues(UserForm userForm,UserMasterEntity userMasterEntity) {
//		userMasterEntity.setAddressLine1(userForm.getAddressLine1());
//		userMasterEntity.setAddressLine2(userForm.getAddressLine2());
//		userMasterEntity.setCity(userForm.getCity());
//		userMasterEntity.setCountry(userForm.getCountry());
//		userMasterEntity.setEmail(userForm.getEmail());
//		userMasterEntity.setFirstName(userForm.getFirstName());
//		userMasterEntity.setGender(userForm.getGender());
//		userMasterEntity.setLastName(userForm.getLastName());
//		userMasterEntity.setMobile(userForm.getMobile());
//		userMasterEntity.setPassWord(userForm.getPassWord());
//		userMasterEntity.setPin(userForm.getPin());
//		userMasterEntity.setState(userForm.getState());
		
//		if (userForm.getUserTypeId()!=null) {
//			UserMasterTypeEntity userMasterTypeEntity = new UsersRoleTypeDao().findByPrimaryKey(userForm.getUserTypeId());
//			userMasterEntity.setUserMasterType(	userMasterTypeEntity);
//		}
	


	}
        
        public ActionForward usersPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        UserForm userForm = (UserForm)form;
        System.out.println("userForm:"+userForm.getPageName());
        UserMasterTypeDao userMasterTypeDao = new UserMasterTypeDao();
        UserMasterDao userMasterDao = new UserMasterDao();
        
        
        if(userForm.getPageName()!=null && userForm.getPageName().equals("GetEditTypeForm"))
        {
            
            UserMasterEntity userMasterEntity = userMasterDao.findByPrimaryKey(userForm.getId());
            userForm.clearFormValues();
            userForm.setUserName(userMasterEntity.getUserName());
            userForm.setPassword(userMasterEntity.getPassword());
            userForm.setId(userMasterEntity.getId());
            userForm.setUserType(userMasterEntity.getUserType().getCode());
            userForm.setUserTypeId(userMasterEntity.getUserType().getId());
        }else if(userForm.getPageName()!=null && userForm.getPageName().equals("SubmitEditType"))
        {
            UserMasterEntity userMasterEntity = userMasterDao.findByPrimaryKey(userForm.getId());
            userMasterEntity.setUserName(userForm.getUserName());
            userMasterEntity.setPassword(userForm.getPassword());
            userMasterEntity.setId(userForm.getId());
            userMasterEntity.setUserType(userMasterTypeDao.findByPrimaryKey(userForm.getUserTypeId()));
            
            userMasterDao.update(userMasterEntity);
            userForm.clearFormValues();
        }else if(userForm.getPageName()!=null && userForm.getPageName().equals("SubmitAddType"))
        {
            UserMasterEntity userMasterEntity = new UserMasterEntity();
            userMasterEntity.setUserName(userForm.getUserName());
            userMasterEntity.setPassword(userForm.getPassword());
            userMasterEntity.setId(userForm.getId());
            userMasterEntity.setUserType(userMasterTypeDao.findByPrimaryKey(userForm.getUserTypeId()));
            
            userMasterDao.persist(userMasterEntity);
            userForm.clearFormValues();
        }else if(userForm.getPageName()!=null && userForm.getPageName().equals("checkUniqueUserName"))
        {
            UserMasterEntity userMasterEntity = userMasterDao.findUserName(userForm.getUserName());
            ApplicationUtil.checkUniqueCodeHelper(userMasterEntity, userForm.getId(), res);
            userForm.clearFormValues();
            
            return null;
        }
        
        List<UserMasterEntity> feeCategoryTypeList = userMasterDao.findAll();
        userForm.setUsersList(null);
        if(!feeCategoryTypeList.isEmpty()){
            userForm.setUsersList(feeCategoryTypeList);
        }
        userForm.setUserTypeList(userMasterTypeDao.findAll());
        req.setAttribute("userModule", "true");
        req.setAttribute("usersPage", "true");
        return mapping.findForward("usersPage");
    }
}
