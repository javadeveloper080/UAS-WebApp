/**
 * 
 */
package org.edu.uams.client.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.dto.ForumSubscribersDTO;
import org.edu.uams.client.form.DisplayMessageForm;
import org.edu.uams.client.form.ForumMasterForm;
import org.edu.uams.server.business.CourseMasterDao;
import org.edu.uams.server.business.ForumMasterDao;
import org.edu.uams.server.business.ForumsSubscribersDao;
import org.edu.uams.server.business.UserMasterDao;
import org.edu.uams.server.pojo.CourseMasterEntity;
import org.edu.uams.server.pojo.ForumMasterEntity;
import org.edu.uams.server.pojo.ForumSubscribersEntity;
import org.edu.uams.server.util.SessionTracker;


public class ForumMasterAction extends DispatchAction {




	public ActionForward getForumPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		ForumMasterForm forumMasterForm = (ForumMasterForm)form;
		ForumMasterDao forumMasterDao=new ForumMasterDao();

		List<ForumMasterEntity> forumMasterEntities = forumMasterDao.findAll();

		if (forumMasterEntities!=null) {
			forumMasterForm.setForumMasterList(forumMasterEntities);	
		}
		else{
			forumMasterForm.setForumMasterList(new ArrayList<ForumMasterEntity>());
		}

		return mapping.findForward("forumPage");
			}


	//This method directs the user to add forum page
	public ActionForward addForumPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		ForumMasterForm forumMasterForm = (ForumMasterForm)form;
		CourseMasterDao courseMasterDao = new CourseMasterDao();

		List<CourseMasterEntity> courseMasterList = courseMasterDao.findAll();
		forumMasterForm.setCourseKeyList(courseMasterList);

		if(!SessionTracker.getUserContext(req).isAdmin()){
			return mapping.findForward("addForumPage");
		}
		else{
			DisplayMessageForm displayMessageForm=new DisplayMessageForm();
			displayMessageForm.setMessage("Admin cannot be a part of forum");
			req.setAttribute("displayMessageForm", displayMessageForm);
			return mapping.findForward("adminForumValidation");
		}
			}


	//Here we add a new forum for a course
	public ActionForward addForum(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		if(!SessionTracker.getUserContext(req).isAdmin()){
			ForumMasterForm forumMasterForm = (ForumMasterForm)form;

			Long courseId = forumMasterForm.getCourseId();
			Long userId=SessionTracker.getUserContext(req).getUserId();

			CourseMasterDao courseMasterDao = new CourseMasterDao();
			ForumMasterDao forumMasterDao=new ForumMasterDao();
			UserMasterDao userMasterDao=new UserMasterDao();

			ForumMasterEntity forumMasterEntity = new ForumMasterEntity();
			forumMasterEntity.setCourseId(courseMasterDao.findByPrimaryKey(courseId));
			forumMasterEntity.setForumName(forumMasterForm.getForumName());
			forumMasterEntity.setTopic(forumMasterForm.getTopic());
			forumMasterEntity.setOwner(userMasterDao.findByPrimaryKey(userId));
			forumMasterEntity.setCreatedOn(new Date());

			forumMasterEntity = forumMasterDao.persist(forumMasterEntity);

			List<ForumMasterEntity> forumMasterEntities = forumMasterDao.findAll();

			if (forumMasterEntities!=null) {
				forumMasterForm.setForumMasterList(forumMasterEntities);	
			}
			else{
				forumMasterForm.setForumMasterList(new ArrayList<ForumMasterEntity>());
			}

			return mapping.findForward("forumPage");
		}
		else{
			DisplayMessageForm displayMessageForm=new DisplayMessageForm();
			displayMessageForm.setMessage("Admin cannot be a part of forum");
			req.setAttribute("displayMessageForm", displayMessageForm);
			return mapping.findForward("adminForumValidation");
		}
			}



	//Here a user will add comment in  a forum
	public ActionForward addForumComment(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		ForumMasterForm forumMasterForm = (ForumMasterForm)form;

		if(!SessionTracker.getUserContext(req).isAdmin()){
			Long forumMasterId = forumMasterForm.getForumId();
			Long userId=SessionTracker.getUserContext(req).getUserId();

			ForumMasterDao forumMasterDao=new ForumMasterDao();
			ForumsSubscribersDao forumsSubscribersDao=new ForumsSubscribersDao();
			UserMasterDao userMasterDao=new UserMasterDao();

			ForumSubscribersEntity forumSubscribersEntity=new ForumSubscribersEntity();
			forumSubscribersEntity.setForumMasterId(forumMasterDao.findByPrimaryKey(forumMasterId));
			forumSubscribersEntity.setComment(forumMasterForm.getComment());
			forumSubscribersEntity.setSubscriber(userMasterDao.findByPrimaryKey(userId));
			forumSubscribersEntity.setCommentOn(new Date());
			forumsSubscribersDao.persist(forumSubscribersEntity);
			forumMasterForm.setComment(null);

			return enterForum(mapping, forumMasterForm, req, res);
		}	else{
			DisplayMessageForm displayMessageForm=new DisplayMessageForm();
			displayMessageForm.setMessage("Admin cannot be a part of forum");
			req.setAttribute("displayMessageForm", displayMessageForm);
			return mapping.findForward("adminForumValidation");
		}

			}


	public ActionForward enterForum(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		ForumMasterForm forumMasterForm = (ForumMasterForm)form;

		Long forumMasterId = forumMasterForm.getForumId();


		ForumMasterDao forumMasterDao=new ForumMasterDao();
		ForumsSubscribersDao forumsSubscribersDao=new ForumsSubscribersDao();

		ForumMasterEntity formForumMasterEntity = forumMasterDao.findByPrimaryKey(forumMasterId);

		forumMasterForm.setCourseId(formForumMasterEntity.getCourseId().getId());
		forumMasterForm.setCourseKey(formForumMasterEntity.getCourseId().getCourseName() +":"+formForumMasterEntity.getCourseId().getCourseKey() );
		forumMasterForm.setTopic(formForumMasterEntity.getTopic());

		String ownerName = formForumMasterEntity.getOwner().getFirstName() + " "+ formForumMasterEntity.getOwner().getLastName() +"@"+formForumMasterEntity.getCreatedOn();
		forumMasterForm.seOwnerName(ownerName);

		forumMasterForm.setForumName(formForumMasterEntity.getForumName());
		forumMasterForm.setForumId(forumMasterId);
		forumMasterForm.setCreatedOn(formForumMasterEntity.getCreatedOn());
		

		List<ForumSubscribersEntity> forumsSubscribers = forumsSubscribersDao.findByForumMasterId(forumMasterId);


		List<ForumSubscribersDTO> forumSubscribersDTOList = new ArrayList<ForumSubscribersDTO>();


		if (forumsSubscribers!=null && !forumsSubscribers.isEmpty()) {
			for (ForumSubscribersEntity forumSubscribersEntity : forumsSubscribers) {
				
				String subscriberName=forumSubscribersEntity.getSubscriber().getFirstName()+ " "+ forumSubscribersEntity.getSubscriber().getLastName();
				ForumSubscribersDTO forumSubscribersDTO=new ForumSubscribersDTO(forumSubscribersEntity.getComment(),subscriberName);
				forumSubscribersDTO.setCommentedOn(forumSubscribersEntity.getCommentOn());
				forumSubscribersDTOList.add(forumSubscribersDTO);
			}

		}
		forumMasterForm.setForumSubscribersDTOList(forumSubscribersDTOList);
		return mapping.findForward("enterForumPage");
			}
}

















