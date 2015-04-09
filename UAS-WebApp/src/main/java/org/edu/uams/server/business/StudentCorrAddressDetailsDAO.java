/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.StudentAddressEntity;

/**
 *
 * @author SARAT
 */
public class StudentCorrAddressDetailsDAO extends AbstractDao<StudentAddressEntity> {

     public StudentCorrAddressDetailsDAO() {
        super(StudentAddressEntity.class);
    }
    @Override
    public List<StudentAddressEntity> findAll() {
         return super.findListByQuery(StudentAddressEntity.FIND_ALL, null);
    }
    
}
