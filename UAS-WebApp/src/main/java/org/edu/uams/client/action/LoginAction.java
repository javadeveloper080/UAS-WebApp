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
import org.edu.uams.client.form.LoginForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.api.EmailDTO;
import org.edu.uams.server.api.UserContext;
import org.edu.uams.server.business.AdminDao;
import org.edu.uams.server.business.UserMasterDao;
import org.edu.uams.server.business.UserMasterTypeDao;
import org.edu.uams.server.pojo.AdminEntity;
import org.edu.uams.server.pojo.UserMasterEntity;
import org.edu.uams.server.util.SendMail;
import org.edu.uams.server.util.SessionTracker;


public class LoginAction extends DispatchAction {
    
    
    //Forwarding to login page
    public ActionForward loginPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        return mapping.findForward("loginPage");
        
        
    }
    
    
    //Check for user login
    public ActionForward logInAction(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        LoginForm loginForm = (LoginForm)form;
        UserMasterDao userMasterDao = new UserMasterDao();
        
        UserMasterEntity userMasterEntity =userMasterDao.findByLoginName(loginForm.getUserName(),loginForm.getPassword());
        if (userMasterEntity!=null) {
            populateUserDetails(loginForm, userMasterEntity);
            UserContext userContext=new UserContext(userMasterEntity.getId(), userMasterEntity.getUserName(),false,loginForm,userMasterEntity.getUserType().getCode());
            SessionTracker.registerUser(req, userContext);
            if (userMasterEntity.getUserType().getCode().equals(ApplicationConstants.ADMIN)) {
                return mapping.findForward("adminHomePage");
            }
            else {
                //TODO
                return mapping.findForward("PROFESSOR");
            }
        }
        else{
            loginForm.setLoginMessage("No User Found of this User Name:"+loginForm.getUserName()+
                    "\n Please Check your User Name and Password");
            return mapping.findForward("noUserFound");
        }
    }
    
    
    public ActionForward logOutAction(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        LoginForm loginForm = (LoginForm)form;
        if (SessionTracker.checkLoginContext(req)!=null) {
            SessionTracker.logOut(req);
            
        }
        loginForm.clearFormValues();
        return mapping.findForward("loginPage");
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
        //   else if (userMasterEntity!=null && userMasterEntity.getEmail()!=null){
        //  toEmailAdress=userMasterEntity.getEmail();
        //  String name=userMasterEntity.getFirstName()+ "  " +userMasterEntity.getLastName();
        //String passWord=userMasterEntity.getPassWord();
        //sendPassWordAction(passWord, toEmailAdress, name);
        //loginForm.setLoginMessage("Your Password Details have been mailed to your E-mail Id");
        //return mapping.findForward("userFound");
        //  }
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
    
    
    private void populateUserDetails(LoginForm loginForm,UserMasterEntity userMasterEntity) {
        loginForm.setName("Hard coded name");
        loginForm.setPassword(userMasterEntity.getPassword());
        loginForm.setId(userMasterEntity.getId());
        loginForm.setUserType(userMasterEntity.getUserType().getDescription());
    }
}