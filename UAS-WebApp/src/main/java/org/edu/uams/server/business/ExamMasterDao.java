package org.edu.uams.server.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.ExamMasterEntity;
import org.edu.uams.server.pojo.QuestionMasterEntity;
import org.hibernate.Query;

public class ExamMasterDao extends AbstractDao<ExamMasterEntity> {

	public ExamMasterDao() {
		super(ExamMasterEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExamMasterEntity> findAll() {
		Query query = session.createQuery(ExamMasterEntity.EXAMMASTER_FIND_ALL);
		return query.list();
	}

	public   ExamMasterEntity findByQuestionId(long questionId) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("questionId", questionId);
		return super.findByQuery(ExamMasterEntity.FIND_BY_QUESTION_ID, params);
	}

	public List<ExamMasterEntity> findByCourseId(Long courseId) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("courseId", courseId);
		return super.findListByQuery(ExamMasterEntity.FIND_BY_COURSEID,params);
	}

	public QuestionMasterEntity getNextQuestionForExam(Long courseId,Long userId) {
		
		QuestionMasterDao questionMasterDao = new QuestionMasterDao();

		List<ExamMasterEntity> numberOfquestionsAttempted = this.findByCourseUserId(courseId,userId);
		List<Long> questionKeys = new ArrayList<Long>();
		
		Map<Long,QuestionMasterEntity> questionMap = new HashMap<Long,QuestionMasterEntity>();

		if (numberOfquestionsAttempted!=null) {
			for (ExamMasterEntity examMasterEntity : numberOfquestionsAttempted) {
				questionKeys.add(examMasterEntity.getQuestionMaster().getId());
			}
		}


		List<QuestionMasterEntity> questionMasterEntities = questionMasterDao.findByCourseId(courseId);
		
		if (questionMasterEntities!=null && !questionMasterEntities.isEmpty()) {
			for (QuestionMasterEntity questionMasterEntity : questionMasterEntities) {
				questionMap.put(questionMasterEntity.getId(), questionMasterEntity);
			}
		}
		QuestionMasterEntity questionMasterEntity=null;

		for (Long questionMasterId : questionMap.keySet()) {
			if (!questionKeys.contains(questionMasterId)) {
				questionMasterEntity=questionMasterDao.findByPrimaryKey(questionMasterId);
				break;
			}

		}
		return questionMasterEntity;
	}

	public List<ExamMasterEntity> findByCourseUserId(Long courseId, Long userId) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("courseId", courseId);
		params.put("userId", userId);
		return super.findListByQuery(ExamMasterEntity.FIND_BY_COURSE_USERID, params);
	}

	public Long findByCourseIdUserCount(Long courseId,Long userId) {
	
		Query query = session.createQuery(ExamMasterEntity.GET_COUNT_BY_COURSEID);
		query.setParameter("courseId", courseId);
		query.setParameter("userId", userId);
		
		List resultlist = query.list();

		if (resultlist!=null && resultlist.size()>0) {
			return (Long) query.list().get(0);
		}
		else{
			return 0l;
		}
	}





}
