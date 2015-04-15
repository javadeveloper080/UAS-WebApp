/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.server.pojo;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import org.edu.uams.server.api.HasId;
import org.edu.uams.server.util.ApplicationUtil;

/**
 *
 * @author Mohammed.Tauseef
 */
@Entity(name = "StudentBusAccDetails")
@Table(name = "student_bus_acc_details")
public class StudentBusAccDetailsEntity implements HasId {
    
    
    private static final long serialVersionUID = 1L;
    
    public static final  String FIND_ALL = "SELECT s FROM StudentBusAccDetails s";
      public static String FIND_BY_STUDENT_ID="SELECT sa FROM StudentBusAccDetails sa JOIN sa.student s  where s.id = :studentId";
    public static final  String FIND_BY_BUS_NUM= "SELECT s FROM StudentBusAccDetails s WHERE s.busNum = :busNum";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Basic(optional = false)
    @Column(name = "bus_reg_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date busRegDate;
    
    @Basic(optional = true)
    @Column(name = "bus_cancel_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date busCancelDate;
    
    
    @Transient
    private String busRegDateTxt;
    
    @Transient
    private String busCancelDateTxt;
    
    @Basic(optional = false)
    @Column(name = "area_name")
    private String areaName;
    
    @Basic(optional = false)
    @JoinColumn(name = "bus_num", referencedColumnName = "id")
    @ManyToOne(targetEntity = BusDetailsEntity.class,optional = false)
    private BusDetailsEntity busDetails;
    
    
    @Basic(optional = false)
    @Column(name = "bus_seat_num")
    private Long busSeatNum;
    
    @Basic(optional = false)
    @ManyToOne(optional = false, targetEntity = StudentEntity.class)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false )
    private StudentEntity student;
    
    
    public StudentBusAccDetailsEntity() {
    }
    
    public String getAreaName() {
        return areaName;
    }
    
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Date getBusRegDate() {
        return busRegDate;
    }
    
    public void setBusRegDate(Date busRegDate) {
        this.busRegDate = busRegDate;
    }
    
    public BusDetailsEntity getBusDetails() {
        return busDetails;
    }
    
    public void setBusDetails(BusDetailsEntity busDetails) {
        this.busDetails = busDetails;
    }
    
    public Date getBusCancelDate() {
        return busCancelDate;
    }
    
    public void setBusCancelDate(Date busCancelDate) {
        this.busCancelDate = busCancelDate;
    }
    
    
    public Long getBusSeatNum() {
        return busSeatNum;
    }
    
    public void setBusSeatNum(Long busSeatNum) {
        this.busSeatNum = busSeatNum;
    }

    public String getBusRegDateTxt() {
       busRegDateTxt=ApplicationUtil.formatDateToString(busRegDate);
        return busRegDateTxt;
    }

    public String getBusCancelDateTxt() {
        busCancelDateTxt=ApplicationUtil.formatDateToString(busCancelDate);
        return busCancelDateTxt;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    
    
    
    
    
    
}
