/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.StudentEnrollmentEntity;
import org.hibernate.Query;

/**
 *
 * @author SARAT
 */
public class StudentEnrollmentDAO  extends AbstractDao<StudentEnrollmentEntity> {

    public StudentEnrollmentDAO() {
		super(StudentEnrollmentEntity.class);
	}
    
    @Override
    public List<StudentEnrollmentEntity> findAll() {
      Query query = session.createQuery(StudentEnrollmentEntity.FIND_ALL);
		return query.list();
    }
    
}
