/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.server.pojo;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.edu.uams.server.api.HasId;


/**
 *
 * @author Mohammed.Tauseef
 */
@Entity(name = "BusDetails")
@Table(name = "bus_details")
public class BusDetailsEntity  implements HasId {
    private static final long serialVersionUID = 1L;
    
    
    public static final  String FIND_ALL = "SELECT b FROM BusDetails b";
    public static final  String FIND_BY_BUS_NUM = "SELECT b FROM BusDetails b WHERE b.busNum = :busNum";
    public static final  String FIND_BY_NUM_OF_SEATS = "SELECT b FROM BusDetails b WHERE b.numOfSeats = :numOfSeats";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Basic(optional = false)
    @Column(name = "bus_num")
    private String busNum;
    
    @Basic(optional = false)
    @Column(name = "registration_num")
    private String registrationNum;
    
    @Basic(optional = false)
    @JoinColumn(name = "bus_faculty_driver", referencedColumnName = "id", nullable = false)
    @OneToOne(targetEntity = BusFacultyEntity.class,fetch = FetchType.EAGER)
    private BusFacultyEntity driver;
    
    
    @Basic(optional = false)
    @JoinColumn(name = "bus_faculty_helper", referencedColumnName = "id", nullable = false)
    @OneToOne(targetEntity = BusFacultyEntity.class,fetch = FetchType.EAGER)
    private BusFacultyEntity cleanerOrHelper;
    
    @Basic(optional = false)
    @ManyToOne(optional = false, targetEntity = BusFacultyEntity.class)
    @JoinColumn(name = "bus_faculty_coordinator", referencedColumnName = "id", nullable = false )
    private BusFacultyEntity coordinator;
    
    
    @Basic(optional = false)
    @Column(name = "num_of_seats")
    private int numOfSeats;
    
    
    @Basic(optional = false)
    @Column(name = "travel_per_day")
    private long travelPerDay;
    
    
    @Basic(optional = false)
    @Column(name = "chassis_num")
    private String chassisNum;
    
    
    public BusDetailsEntity() {
    }
    
    public BusDetailsEntity(String busNum) {
        this.busNum = busNum;
    }
    
    public String getBusNum() {
        return busNum;
    }
    
    public void setBusNum(String busNum) {
        this.busNum = busNum;
    }
    
    public int getNumOfSeats() {
        return numOfSeats;
    }
    
    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getRegistrationNum() {
        return registrationNum;
    }
    
    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }
    
    public BusFacultyEntity getDriver() {
        return driver;
    }
    
    public void setDriver(BusFacultyEntity driver) {
        this.driver = driver;
    }
    
    public BusFacultyEntity getCleanerOrHelper() {
        return cleanerOrHelper;
    }
    
    public void setCleanerOrHelper(BusFacultyEntity cleanerOrHelper) {
        this.cleanerOrHelper = cleanerOrHelper;
    }
    
    public BusFacultyEntity getCoordinator() {
        return coordinator;
    }
    
    public void setCoordinator(BusFacultyEntity coordinator) {
        this.coordinator = coordinator;
    }
    
    public long getTravelPerDay() {
        return travelPerDay;
    }
    
    public void setTravelPerDay(long travelPerDay) {
        this.travelPerDay = travelPerDay;
    }
    
    public String getChassisNum() {
        return chassisNum;
    }
    
    public void setChassisNum(String chassisNum) {
        this.chassisNum = chassisNum;
    }
    
    
    
}