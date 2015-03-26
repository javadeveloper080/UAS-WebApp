/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.StudentCorrAddressDetailsEntity;

/**
 *
 * @author SARAT
 */
public class StudentCorrAddressDetailsDAO extends AbstractDao<StudentCorrAddressDetailsEntity> {

     public StudentCorrAddressDetailsDAO() {
        super(StudentCorrAddressDetailsEntity.class);
    }
    @Override
    public List<StudentCorrAddressDetailsEntity> findAll() {
         return super.findListByQuery(StudentCorrAddressDetailsEntity.FIND_ALL, null);
    }
    
}
