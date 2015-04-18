/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.server.pojo;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 *
 * @author Mohammed.Tauseef
 */
@Entity(name = "HostelBlock")
@Table(name = "hostel_block")
public class HostelBlockEntity  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    public static final  String FIND_ALL = "SELECT hb FROM HostelBlock hb";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    
    @Basic(optional = false)
    @Column(name = "addr_line_1")
    private String addrLine1;
    
    @Basic(optional = true)
    @Column(name = "addr_line_2")
    private String addrLine2;
    
    @Basic(optional = true)
    @Column(name = "addr_line_3")
    private String addrLine3;
    
    
    @Basic(optional = true)
    @Column(name = "addr_line_4")
    private String addrLine4;
    
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    
    @Basic(optional = false)
    @Column(name = "state_name")
    private String stateName;
    
    @Basic(optional = false)
    @Column(name = "zip_code")
    private long zipCode;
    
    @Basic(optional = false)
    @Column(name = "incharge_name", length = 100, nullable = false)
    @Enumerated(EnumType.STRING)
    private String inchargeName;
    
    
    @Basic(optional = false)
    @Column(name = "mobile",unique = true)
    private long mobile;
    
    @Basic(optional = false)
    @Column(name = "has_bus_assigned",nullable = false)
    private boolean hasBusAssigned;
    
    @Transient
    private String addrLines;
    
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddrLine1() {
        return addrLine1;
    }
    
    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }
    
    public String getAddrLine2() {
        return addrLine2;
    }
    
    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }
    
    public String getAddrLine3() {
        return addrLine3;
    }
    
    public void setAddrLine3(String addrLine3) {
        this.addrLine3 = addrLine3;
    }
    
    public String getAddrLine4() {
        return addrLine4;
    }
    
    public void setAddrLine4(String addrLine4) {
        this.addrLine4 = addrLine4;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStateName() {
        return stateName;
    }
    
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public long getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }
    
    public long getMobile() {
        return mobile;
    }
    
    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getInchargeName() {
        return inchargeName;
    }

    public void setInchargeName(String inchargeName) {
        this.inchargeName = inchargeName;
    }
   
    public boolean isHasBusAssigned() {
        return hasBusAssigned;
    }

    public void setHasBusAssigned(boolean hasBusAssigned) {
        this.hasBusAssigned = hasBusAssigned;
    }
    
    public String getAddrLines() {
        return addrLine1+addrLine2+addrLine3+addrLine4+city;
    }
    
    public void setAddrLines(String addrLines) {
        if (addrLines==null || addrLines.isEmpty()) {
            this.addrLines = addrLine1+addrLine2+addrLine3+addrLine4+city;
        }else{
            this.addrLines = addrLines;
        }
        
    }
    
    
}