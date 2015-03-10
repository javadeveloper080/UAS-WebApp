package org.edu.uams.server.business;

import java.util.List;

import org.edu.uams.server.pojo.StudentCourseEntity;
import org.hibernate.Query;

public class StudentCourseDao extends AbstractDao<StudentCourseEntity> {

	public StudentCourseDao() {
		super(StudentCourseEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentCourseEntity> findAll() {
		Query query = session.createQuery(StudentCourseEntity.STUDENTCOURSE_FIND_ALL);
		return query.list();
	}






}
