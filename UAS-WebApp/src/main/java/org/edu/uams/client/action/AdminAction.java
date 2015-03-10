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
import org.edu.uams.client.form.AdminForm;
import org.edu.uams.server.business.AdminDao;
import org.edu.uams.server.pojo.AdminEntity;


public class AdminAction extends DispatchAction {




	public ActionForward adminAddPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		return mapping.findForward("adminAddPage");
			}



	public ActionForward createAdmin(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		AdminForm adminForm=(AdminForm)form;


		AdminDao adminDao=new AdminDao();
		AdminEntity adminEntity =adminDao.findAdminName(adminForm.getAdminName());

		if (adminEntity!=null && adminEntity.getAdminName().equals(adminForm.getAdminName())) {
			adminForm.setAdminName(adminForm.getAdminName());
			adminForm.setEmail(adminForm.getEmail());
			adminForm.setMessage(" A admin with this name exists: "+adminForm.getAdminName()+ " .please try some other name ");
			return mapping.findForward("unqueAdmin");	
		}


		else{
			adminEntity=new AdminEntity();
			adminEntity.setAdminName(adminForm.getAdminName());
			adminEntity.setEmail(adminForm.getEmail());
			adminEntity.setPassWord(adminForm.getPassWord());
			adminEntity.setSuperAdmin(false);
			adminEntity=adminDao.persist(adminEntity);
			return mapping.findForward("registrationSuccess");	
		}

			}
}












