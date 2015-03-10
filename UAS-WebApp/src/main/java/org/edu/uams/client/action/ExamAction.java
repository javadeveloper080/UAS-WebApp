/**
 * 
 */
package org.edu.uams.client.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.dto.ExamOptionsDTO;
import org.edu.uams.client.form.DisplayMessageForm;
import org.edu.uams.client.form.ExamForm;
import org.edu.uams.server.api.UserContext;
import org.edu.uams.server.business.CourseMasterDao;
import org.edu.uams.server.business.ExamMasterDao;
import org.edu.uams.server.business.QuestionMasterDao;
import org.edu.uams.server.business.ResultMasterDao;
import org.edu.uams.server.business.UserMasterDao;
import org.edu.uams.server.pojo.CourseMasterEntity;
import org.edu.uams.server.pojo.ExamMasterEntity;
import org.edu.uams.server.pojo.QuestionMasterEntity;
import org.edu.uams.server.pojo.ResultMasterEntity;
import org.edu.uams.server.util.SessionTracker;


public class ExamAction extends DispatchAction {


	public ActionForward selectCourseExam(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		ExamForm examForm = (ExamForm)form;

		List<CourseMasterEntity> validCourseKeyList=new ArrayList<CourseMasterEntity>();

		CourseMasterDao courseMasterDao = new CourseMasterDao();
		QuestionMasterDao questionMasterDao=new QuestionMasterDao();

		List<CourseMasterEntity> courseKeyList = courseMasterDao.findAll();

		for (CourseMasterEntity courseMasterEntity : courseKeyList) {
			List<QuestionMasterEntity> questionMasterList = questionMasterDao.findByCourseId(courseMasterEntity.getId());
			if (questionMasterList!=null && questionMasterList.size()==10) {
				validCourseKeyList.add(courseMasterEntity);
			}
		}

		examForm.setCourseKeyList(validCourseKeyList);

		return mapping.findForward("examSelect");
			}


	public ActionForward selectedCourseExam(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		ExamForm examForm = (ExamForm)form;

		Long courseId = new Long(examForm.getCourseId());

		ExamMasterDao examMasterDao=new ExamMasterDao();

		Long userId=SessionTracker.getUserContext(req).getUserId();
		Long examptedCount = examMasterDao.findByCourseIdUserCount(courseId,userId);

		if (examptedCount!=null) {
			examForm.setNoQuestionsAttempted("** Number of questions till now you have attempted : "  +examptedCount.longValue());
			examForm.setNoQuestionsPending("** Number of questions need to be  attempted : "  +(10-examptedCount.longValue()));
		}
		if (examptedCount==9) {
			examForm.setNoQuestionsPending("Number of questions need to be  attempted : "  +(10-examptedCount.longValue())+
					"\n You will be directed to home page after this exam");
		}


		if (examptedCount.longValue()!=10 && examptedCount.longValue() < 10) {

			QuestionMasterEntity questionMasterEntity = examMasterDao.getNextQuestionForExam(courseId,userId);

			if (questionMasterEntity!=null) {

				List<ExamOptionsDTO> examOptionsDTOs=new ArrayList<ExamOptionsDTO>();
				examOptionsDTOs.add(new ExamOptionsDTO(1, questionMasterEntity.getChoice1()));
				examOptionsDTOs.add(new ExamOptionsDTO(2, questionMasterEntity.getChoice2()));
				examOptionsDTOs.add(new ExamOptionsDTO(3, questionMasterEntity.getChoice3()));
				examOptionsDTOs.add(new ExamOptionsDTO(4, questionMasterEntity.getChoice4()));

				examForm.setOptions(examOptionsDTOs);
				examForm.setQuestionDescription(questionMasterEntity.getQuestion());
				examForm.setQuestionId(questionMasterEntity.getQuestionId());
				examForm.setQuestionKey(questionMasterEntity.getId());
				examForm.setCourseId(courseId.intValue());
				examForm.setAnswerNumber(0);

			}
			return mapping.findForward("selectedExam");

		}

		else{
			DisplayMessageForm displayMessageForm=new DisplayMessageForm();
			displayMessageForm.setMessage("You have already taken the exam for this course");
			req.setAttribute("displayMessageForm", displayMessageForm);
			return mapping.findForward("exceeded");
		}

			}



	public ActionForward selectedExamPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		UserContext userContext=SessionTracker.getUserContext(req);
		System.out.println("userContext"+userContext.getUserName());
		
		ExamForm examForm = (ExamForm)form;
		
		Long userId=userContext.getUserId();
		UserMasterDao userMasterDao=new UserMasterDao();

		Long courseId = new Long(examForm.getCourseId());
		ExamMasterDao examMasterDao=new ExamMasterDao();

		QuestionMasterDao questionMasterDao = new QuestionMasterDao();
		QuestionMasterEntity questionMaster=questionMasterDao.findByPrimaryKey(examForm.getQuestionKey());

		ExamMasterEntity examMasterEntity=new ExamMasterEntity();
		
		examMasterEntity.setAnswerNumber(examForm.getAnswerNumber());
		examMasterEntity.setUserMaster(userMasterDao.findByPrimaryKey(userId));
		examMasterEntity.setQuestionMaster(questionMaster);
		examMasterDao.persist(examMasterEntity);

		Long examptedCount = examMasterDao.findByCourseIdUserCount(courseId,userId);

		if (examptedCount.longValue()!=10 && examptedCount.longValue() < 10) {
			return mapping.findForward("nextQuestionPage");
		}
		else{
			List<ExamMasterEntity> examMasterEntities = examMasterDao.findByCourseUserId(courseId,userId);
			calculateResultByCourseForUser(courseId, examMasterEntities,userId);
			return mapping.findForward("studentHomePage");
		}
			}


	private void calculateResultByCourseForUser(Long courseId,List<ExamMasterEntity> examMasterEntities,Long userId) {
		if (examMasterEntities!=null && examMasterEntities.size()==10) {
			//then calculate the result
			int numberCorrectAnswers=0;
			int numberWrongAnswers=0;
			int totalCount=0;
			for (ExamMasterEntity examMasterEntity2 : examMasterEntities) {
				if (examMasterEntity2.getAnswerNumber()==examMasterEntity2.getQuestionMaster().getAnswerNumber()) {
					numberCorrectAnswers=numberCorrectAnswers+1;
				}
				else{
					numberWrongAnswers=numberWrongAnswers+1;
				}
				totalCount=numberCorrectAnswers+numberWrongAnswers;

				if (totalCount==10) {
					CourseMasterDao courseMasterDao = new CourseMasterDao();
					ResultMasterDao resultMasterDao=new ResultMasterDao();
					ResultMasterEntity resultMasterEntity=new ResultMasterEntity();
					resultMasterEntity.setCourseId(courseMasterDao.findByPrimaryKey(courseId));
					resultMasterEntity.setUserName(new UserMasterDao().findByPrimaryKey(userId));

					double resultPercentage = numberCorrectAnswers * 100 /10;

					resultMasterEntity.setPercentage(resultPercentage);
					resultMasterDao.persist(resultMasterEntity);
				}

			}

		}
	}

}
