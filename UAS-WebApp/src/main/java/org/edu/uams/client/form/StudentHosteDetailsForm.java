/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.client.form;


import org.edu.uams.server.pojo.*;
import java.util.List;
import org.apache.struts.action.ActionForm;


/**
 *
 * @author Mohammed.Tauseef
 */
public class StudentHosteDetailsForm  extends  ActionForm {
    
    private long id;
    
    private Double paidAmount;
    
    private HostelRoomDetailsEntity roomEntity;

    private StudentEntity studentEntity;
    
    private Long studentId;
    
    private Long hosterRMId;
    
    private String pageName;
    
    private List<HostelRoomDetailsEntity> roomDetailsEntitys;

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public HostelRoomDetailsEntity getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(HostelRoomDetailsEntity roomEntity) {
        this.roomEntity = roomEntity;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getHosterRMId() {
        return hosterRMId;
    }

    public void setHosterRMId(Long hosterRMId) {
        this.hosterRMId = hosterRMId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public List<HostelRoomDetailsEntity> getRoomDetailsEntitys() {
        return roomDetailsEntitys;
    }

    public void setRoomDetailsEntitys(List<HostelRoomDetailsEntity> roomDetailsEntitys) {
        this.roomDetailsEntitys = roomDetailsEntitys;
    }
    
    
    
}