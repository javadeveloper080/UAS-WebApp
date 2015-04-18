/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.client.form;


import java.util.List;
import org.apache.struts.action.ActionForm;
import org.edu.uams.server.pojo.HostelBlockEntity;


/**
 *
 * @author Mohammed.Tauseef
 */
public class HostelBlockForm  extends ActionForm {

    private long id;
    
    private String name;
    
    private String pageName;
    
    private String addrLine1;
    
    private String addrLine2;
    
    private String addrLine3;
    
    private String addrLine4;
    
    private String city;
    
    private String stateName;
    
    private long zipCode;
    
    private String inchargeName;
    
    private long mobile;
    
    private boolean hasBusAssigned;
    
    private String addrLines;
    
    private List<HostelBlockEntity> blockEntitys;
    
    
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

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public List<HostelBlockEntity> getBlockEntitys() {
        return blockEntitys;
    }

    public void setBlockEntitys(List<HostelBlockEntity> blockEntitys) {
        this.blockEntitys = blockEntitys;
    }
    
    
}