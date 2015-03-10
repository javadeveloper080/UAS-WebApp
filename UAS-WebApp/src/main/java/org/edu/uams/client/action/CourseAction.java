/**
 * 
 */
package org.edu.uams.client.action;


import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.edu.uams.client.form.CourseForm;
import org.edu.uams.client.form.DisplayMessageForm;
import org.edu.uams.server.business.CourseMasterDao;
import org.edu.uams.server.business.DocumentMasterDao;
import org.edu.uams.server.business.SessionMasterDao;
import org.edu.uams.server.pojo.CourseMasterEntity;
import org.edu.uams.server.pojo.DocumentEntity;
import org.edu.uams.server.pojo.SessionMasterEntity;
import org.edu.uams.server.util.DocumentUtil;


public class CourseAction extends DispatchAction {


	public ActionForward addCourse(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		CourseForm courseForm = (CourseForm)form;

		CourseMasterEntity courseMasterEntity = new CourseMasterEntity();

		CourseMasterDao courseMasterDao = new CourseMasterDao();

		setvalues(courseForm,courseMasterEntity);

		List<CourseMasterEntity> courseMasterEntities = courseMasterDao.findAll();

		if (courseMasterEntities!=null && courseMasterEntities.size()> 0) {
			long courseKey=courseMasterEntities.size()+1;
			courseMasterEntity.setCourseKey("C"+courseKey);
		}else{
			courseMasterEntity.setCourseKey("C"+1);
		}

		courseMasterEntity = courseMasterDao.persist(courseMasterEntity);

		FormFile file = courseForm.getFile();

		String fileName = file.getFileName();
		byte[] data = file.getFileData();
		String contentType = file.getContentType();

		DocumentEntity documentEntity=new DocumentEntity();
		documentEntity.setFileBytes(data);
		documentEntity.setFileName(fileName);
		documentEntity.setMimeType(contentType);
		documentEntity.setCourseId(courseMasterEntity);

		DocumentMasterDao documentMasterDao=new DocumentMasterDao();
		documentMasterDao.persist(documentEntity);

		if(courseMasterEntity.getId()>0)
		{
			courseForm.setCourseAddedMessage("Course Added Successfully");
		}

		return mapping.findForward("addCoursePage");
			}


	private void setvalues(CourseForm courseForm,CourseMasterEntity courseMasterEntity)
	{
		courseMasterEntity.setCourseName(courseForm.getCourseName());
		courseMasterEntity.setCategory(courseForm.getCategory());
		courseMasterEntity.setNumberOfSessions(courseForm.getSessions());
	}

	public ActionForward courseAddPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		return mapping.findForward("addCoursePage");
			}


	public ActionForward displayCourses(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		CourseForm courseForm = (CourseForm)form;

		populateCourseList(courseForm);

		if(courseForm.getPageName()!=null && courseForm.getPageName().equals("ModifyCourse"))
		{
			return mapping.findForward("modifyCourse");
		}
		else if(courseForm.getPageName()!=null && courseForm.getPageName().equals("DeleteCourse"))
		{
			return mapping.findForward("deleteCourse");
		}
		else

			return mapping.findForward("courseDetails");
			}

	public ActionForward modifyCourses(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		CourseForm courseForm = (CourseForm)form;

		populateCourseList(courseForm);
		CourseMasterDao courseMasterDao = new CourseMasterDao();

		CourseMasterEntity courseMasterEntity = courseMasterDao.findByPrimaryKey(courseForm.getCourId());

		try{
			SessionMasterDao sessionMasterDao = new SessionMasterDao();

			List<SessionMasterEntity> sessList = sessionMasterDao.findSessionsForCourse(courseMasterEntity);

			if(sessList.size()!=0)
			{
				courseForm.setSessList(sessList);
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return mapping.findForward("modifyCourse");
			}


	public ActionForward modifyCourseContent(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		CourseForm courseForm = (CourseForm)form;

		SessionMasterDao sessionMasterDao = new SessionMasterDao();

		SessionMasterEntity sessionMasterEntity = sessionMasterDao.findByPrimaryKey(new Long(req.getParameter("sessionId")));


		courseForm.setTopicContent(sessionMasterEntity.getTopicContent());
		courseForm.setSessionId(sessionMasterEntity.getSessionId());
		courseForm.setTopic(sessionMasterEntity.getTopic());
		courseForm.setCourId(sessionMasterEntity.getCourseId().getId());

		req.setAttribute("courseForm", courseForm);
		return mapping.findForward("addCourseContent");


			}



	public ActionForward updateCourseContent(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		CourseForm courseForm = (CourseForm)form;

		SessionMasterDao sessionMasterDao = new SessionMasterDao();

		SessionMasterEntity sessionMasterEntity = sessionMasterDao.findByPrimaryKey(courseForm.getSessionId());


		sessionMasterEntity.setTopicContent(courseForm.getTopicContent());

		sessionMasterDao.update(sessionMasterEntity);


		courseForm.setCourseContentMessage("Course Content Updated");
		courseForm.setTopicContent(sessionMasterEntity.getTopicContent());
		courseForm.setSessionId(sessionMasterEntity.getSessionId());
		courseForm.setTopic(sessionMasterEntity.getTopic());
		courseForm.setCourId(sessionMasterEntity.getCourseId().getId());

		req.setAttribute("courseForm", courseForm);


		return mapping.findForward("addCourseContent");
			}


	public ActionForward deleteCourseSession(ActionMapping mapping,
			ActionForm form, HttpServletRequest req, HttpServletResponse res)
					throws Exception {
		CourseForm courseForm = (CourseForm) form;

		populateCourseList(courseForm);
		CourseMasterDao courseMasterDao = new CourseMasterDao();

		CourseMasterEntity courseMasterEntity = courseMasterDao
				.findByPrimaryKey(courseForm.getCourId());

		try {
			SessionMasterDao sessionMasterDao = new SessionMasterDao();

			SessionMasterEntity sessionMasterEntity = sessionMasterDao.findByPrimaryKey(new Long(req.getParameter("sessionId")));

			sessionMasterDao.delete(sessionMasterEntity);

			List<SessionMasterEntity> sessList = sessionMasterDao
					.findSessionsForCourse(courseMasterEntity);

			if (sessList.size() != 0) {
				courseForm.setSessList(sessList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("modifyCourse");
	}


	public ActionForward redirectToAddTopic(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		CourseForm courseForm = (CourseForm)form;
		
		String sessionId = req.getParameter("sessionId");
		
		if(sessionId.equals("")||sessionId.equals(null))
		{
			sessionId = new Long("0").toString();
			courseForm.setDisplayTopic("display");
		}
		
		if(sessionId!= null||sessionId!="")
		{
		courseForm.setSessionId(new Long(sessionId));
		}
		courseForm.setCourId(new Long(req.getParameter("courseId")));


		req.setAttribute("courseForm", courseForm);


		return mapping.findForward("addCourseTopic");
			}

	public ActionForward AddTopicCourse(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		CourseForm courseForm = (CourseForm)form;

		SessionMasterDao sessionMasterDao = new SessionMasterDao();
		SessionMasterEntity sessionMasterEntity = null;
		if(courseForm.getSessionId()!=0L){

		 sessionMasterEntity = sessionMasterDao.findByPrimaryKey(courseForm.getSessionId());

		}

		CourseMasterDao courseMasterDao = new CourseMasterDao();

		CourseMasterEntity courseMasterEntity = courseMasterDao
				.findByPrimaryKey(courseForm.getCourId());

		SessionMasterEntity sessionMasterEntityForCourse = new SessionMasterEntity();
		
		if(courseForm.getSessionId()!=0L){
		sessionMasterEntityForCourse.setTopic(sessionMasterEntity.getTopic());
		}
		if(courseForm.getSessionId().equals(0L)){
			sessionMasterEntityForCourse.setTopic(courseForm.getTopic());
			}
	
		sessionMasterEntityForCourse.setTopicName(courseForm.getTopicName());
		sessionMasterEntityForCourse.setTopicContent(courseForm.getTopicContent());
		sessionMasterEntityForCourse.setCourseId(courseMasterEntity);

		sessionMasterDao.persist(sessionMasterEntityForCourse);

		courseForm.setCourseContentMessage("Course Topic Details Added");

		courseForm.setSessionId(courseForm.getSessionId());
		req.setAttribute("courseForm", courseForm);

		return mapping.findForward("addCourseTopic");
			}


	public ActionForward displaySelectedCourse(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		CourseForm courseForm = (CourseForm)form;


		CourseMasterDao courseMasterDao = new CourseMasterDao();

		CourseMasterEntity courseMasterEntity = courseMasterDao.findByPrimaryKey(new Long(req.getParameter("courseId")));

		SessionMasterDao sessionMasterDao = new SessionMasterDao();

		List<SessionMasterEntity> sessList = sessionMasterDao.findSessionsForCourse(courseMasterEntity);

		if(sessList.size()!=0)
		{
			courseForm.setSessList(sessList);
		}



		return mapping.findForward("displaySelectedCourseContent");
			}


	public ActionForward readCourseContent(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		CourseForm courseForm = (CourseForm)form;

		SessionMasterDao sessionMasterDao = new SessionMasterDao();

		SessionMasterEntity sessionMasterEntity = sessionMasterDao.findByPrimaryKey(new Long(req.getParameter("sessionId")));


		courseForm.setTopicContent(sessionMasterEntity.getTopicContent());
		courseForm.setSessionId(sessionMasterEntity.getSessionId());
		courseForm.setTopic(sessionMasterEntity.getTopic());
		courseForm.setCourId(sessionMasterEntity.getCourseId().getId());

		req.setAttribute("courseForm", courseForm);
		return mapping.findForward("readCourseTopic");
			}

	public ActionForward downloadCourseContent(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse response)throws Exception
			{
		CourseForm courseForm = (CourseForm)form;
		
		Long courseId=1l;

		if (req.getParameter("courseId")!=null) {
			 courseId =new Long( req.getParameter("courseId"));
		}

		DocumentMasterDao documentMasterDao=new DocumentMasterDao();
		List<DocumentEntity> documents=documentMasterDao.findByCourseId(courseId);

		if (documents!=null && !documents.isEmpty() && documents.size()>0) {

			DocumentEntity documentEntity = documents.get(0);

			File path = new File("docs");
			if (!path.isDirectory()) {
				path.mkdir();
			}
			File file = new File(path, documentEntity.getFileName());
			DocumentUtil.getFileFromBytes(documentEntity.getFileBytes(), file);

			FileInputStream in = 
					new FileInputStream(file);

			response.setContentType("application/octet-stream");	
			response.setHeader("Content-Disposition","attachment;filename="+documentEntity.getFileName());

			ServletOutputStream out = response.getOutputStream();

			byte[] outputByte = new byte[4096];
			while(in.read(outputByte, 0, 4096) != -1){
				out.write(outputByte, 0, 4096);
			}
			in.close();
			out.flush();
			out.close();
			return null;
		}
		else{
			DisplayMessageForm displayMessageForm=new DisplayMessageForm();
			displayMessageForm.setMessage("No Document found for this course. Please contact your admin to upload a  document");
			req.setAttribute("displayMessageForm", displayMessageForm);
			return mapping.findForward("noDocumentFound");
		}



			}



	public ActionForward deleteCourses(ActionMapping mapping,
			ActionForm form, HttpServletRequest req, HttpServletResponse res)
					throws Exception {
		CourseForm courseForm = (CourseForm) form;



		try{
			CourseMasterDao courseMasterDao = new CourseMasterDao();

			CourseMasterEntity courseMasterEntity = courseMasterDao
					.findByPrimaryKey(courseForm.getCourId());


			courseMasterDao.delete(courseMasterEntity);

			populateCourseList(courseForm);

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


		return mapping.findForward("deleteCourse");
	}

	
	public ActionForward updateCourseFileContent(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		CourseForm courseForm = (CourseForm)form;

		CourseMasterDao courseMasterDao = new CourseMasterDao();

		CourseMasterEntity courseMasterEntity = courseMasterDao.findByPrimaryKey(new Long(req.getParameter("courseId")));
		
		DocumentMasterDao documentMasterDao=new DocumentMasterDao();
		List<DocumentEntity> documentEntitylist = (List<DocumentEntity>) documentMasterDao.findByCourseId(new Long(req.getParameter("courseId")));
		DocumentEntity documentEntity = new DocumentEntity();
		
		if(documentEntitylist.size()!=0)
		{
		
		 documentEntity = documentEntitylist.get(0);

		}
		FormFile file = courseForm.getFile();
		
		if(file!=null)
		{
			
		

		String fileName = file.getFileName();
		byte[] data = file.getFileData();
		String contentType = file.getContentType();

		//DocumentEntity documentEntity=new DocumentEntity();
		documentEntity.setFileBytes(data);
		documentEntity.setFileName(fileName);
		documentEntity.setMimeType(contentType);
		documentEntity.setCourseId(courseMasterEntity);

		documentMasterDao.update(documentEntity);
		}

		return mapping.findForward("redirectCourseDetails");
			}

	
	
	/**
	 *method to populate courseList
	 *
	 */
	private void populateCourseList(CourseForm courseForm){

		CourseMasterDao courseMasterDao = new CourseMasterDao();

		List<CourseMasterEntity> courseList = courseMasterDao.findAll();

		if(courseList.size()!=0){
			courseForm.setCourseList(courseList);
		}

	}



}




