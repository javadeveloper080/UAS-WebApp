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
import org.edu.uams.client.dto.ResultsDTO;
import org.edu.uams.client.form.ResultForm;
import org.edu.uams.server.business.ResultMasterDao;
import org.edu.uams.server.pojo.ResultMasterEntity;
import org.edu.uams.server.util.SessionTracker;


public class ResultAction extends DispatchAction {


	public ActionForward getResults(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{
		
		Long userId=SessionTracker.getUserContext(req).getUserId();
		
		ResultForm resultForm = (ResultForm)form;

		List<ResultsDTO> resultsDTOList = new ArrayList<ResultsDTO>();

		ResultMasterDao resultMasterDao=new ResultMasterDao();
		List<ResultMasterEntity> resultMasterEntities = resultMasterDao.findByUserMasterId(userId);

		if (resultMasterEntities!=null && !resultMasterEntities.isEmpty()) {
			for (ResultMasterEntity resultMasterEntity : resultMasterEntities) {
				ResultsDTO resultsDTO=new ResultsDTO(resultMasterEntity.getCourseId().getCourseKey(),
						resultMasterEntity.getCourseId().getCourseName(),
						resultMasterEntity.getCourseId().getCategory(),
						resultMasterEntity.getPercentage()+"%");
				resultsDTOList.add(resultsDTO);
			}

		}
		resultForm.setResultsDTOList(resultsDTOList);
		return mapping.findForward("resultPage");
			}




}
