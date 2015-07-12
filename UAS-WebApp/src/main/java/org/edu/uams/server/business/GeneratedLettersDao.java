package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.GeneratedLetterEntity;

public class GeneratedLettersDao extends AbstractDao<GeneratedLetterEntity> {

	public GeneratedLettersDao() {
		super(GeneratedLetterEntity.class);
	}

	@Override
	public List<GeneratedLetterEntity> findAll() {
		return super.findListByQuery(GeneratedLetterEntity.FIND_ALL, null);
	}


	public List<GeneratedLetterEntity> findAllGeneratedLettersByTemplateId(long lettertemplateId) {
		Map<String, Object> parmas=new LinkedHashMap<String, Object>();
		parmas.put("lettertemplateId", lettertemplateId);
		return super.findListByQuery(GeneratedLetterEntity.FIND_BY_LETTER_TEMPLATE, parmas);
	}
}
