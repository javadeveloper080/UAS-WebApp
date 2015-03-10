/**
 * 
 */
package org.edu.uams.client.form;


import java.util.List;

import org.apache.struts.action.ActionForm;
import org.edu.uams.client.dto.ResultsDTO;


public class ResultForm extends ActionForm {
	

	private List<ResultsDTO> resultsDTOList;

	public List<ResultsDTO> getResultsDTOList() {
		return resultsDTOList;
	}

	public void setResultsDTOList(List<ResultsDTO> resultsDTOList) {
		this.resultsDTOList = resultsDTOList;
	}




}
