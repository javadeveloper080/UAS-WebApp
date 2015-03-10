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
import org.edu.uams.client.form.QuestionForm;
import org.edu.uams.server.business.CourseMasterDao;
import org.edu.uams.server.business.QuestionMasterDao;
import org.edu.uams.server.pojo.CourseMasterEntity;
import org.edu.uams.server.pojo.QuestionMasterEntity;


public class QuestionAction extends DispatchAction {




	public ActionForward addQuestionPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		QuestionForm questionForm = (QuestionForm)form;
		CourseMasterDao courseMasterDao = new CourseMasterDao();

		List<CourseMasterEntity> courseMasterList = courseMasterDao.findAll();
		questionForm.setCourseKeyList(courseMasterList);
		return mapping.findForward("addQuestionPage");
			}


	public ActionForward addQuestion(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		QuestionForm questionForm = (QuestionForm)form;

		QuestionMasterDao questionMasterDao = new QuestionMasterDao();
		List<QuestionMasterEntity> questionMastersByCourse=questionMasterDao.findByCourseId(questionForm.getCourseId());

		if (questionMastersByCourse!=null && questionMastersByCourse.size() ==10) {
			DisplayMessageForm displayMessageForm=new DisplayMessageForm();
			displayMessageForm.setMessage("Max 10 Questions can be added to a course . you have crossed 10");
			req.setAttribute("displayMessageForm", displayMessageForm);
			return mapping.findForward("numberOfQuestionValidation");
		}

		else{
			
			CourseMasterDao courseMasterDao = new CourseMasterDao();
			QuestionMasterEntity questionMasterEntity = new QuestionMasterEntity();
			setvalues(questionForm,questionMasterEntity);
			questionMasterEntity.setCourseId(courseMasterDao.findByPrimaryKey(questionForm.getCourseId()));

			List<QuestionMasterEntity> questionMasterEntities = questionMasterDao.findAll();

			if (questionMasterEntities!=null && questionMasterEntities.size()> 0) {
				long questionId=questionMasterEntities.size()+1;
				questionMasterEntity.setQuestionId("Q"+questionId);
			}else{
				questionMasterEntity.setQuestionId("Q"+1);
			}
			questionMasterEntity = questionMasterDao.persist(questionMasterEntity);

			if(questionMasterEntity.getId()>0)
			{
				questionForm.setQuestionAddedMessage("Question Added Successfully");

			}
			
			questionForm.resetForm();
			List<CourseMasterEntity> courseMasterList = courseMasterDao.findAll();
			questionForm.setCourseKeyList(courseMasterList);
			
			return mapping.findForward("addQuestionPage");
		}
			}

	private void setvalues(QuestionForm questionForm,QuestionMasterEntity questionMasterEntity)

	{
		
		questionMasterEntity.setChoice1(questionForm.getChoice1());
		questionMasterEntity.setChoice2(questionForm.getChoice2());
		questionMasterEntity.setChoice3(questionForm.getChoice3());
		questionMasterEntity.setChoice4(questionForm.getChoice4());
		questionMasterEntity.setQuestion(questionForm.getQuestionDescription());
		questionMasterEntity.setQuestionId(questionForm.getQuestionId());
		questionMasterEntity.setAnswerNumber(questionForm.getAnswerNumber());
	}



}
