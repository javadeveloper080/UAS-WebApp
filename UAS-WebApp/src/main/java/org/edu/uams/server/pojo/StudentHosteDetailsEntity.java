/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.server.pojo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Mohammed.Tauseef
 */
@Entity(name = "StudentHosteDetails")
@Table(name = "student_hoste_details")
public class StudentHosteDetailsEntity  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    public static final  String FIND_ALL = "SELECT shd FROM StudentHosteDetails shd";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "paid_amount", unique = true, nullable = false)
    private Double paidAmount;
    
    @JoinColumn(name = "hostel_room_id",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private HostelRoomDetailsEntity roomEntity;

    @JoinColumn(name = "student_id",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StudentEntity studentEntity;

    
    
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
    
}