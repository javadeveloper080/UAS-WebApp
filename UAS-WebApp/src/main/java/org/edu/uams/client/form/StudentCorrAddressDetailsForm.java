package org.edu.uams.client.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Sarat
 */
public class StudentCorrAddressDetailsForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private String rollNum;
    private String doorNum;
    private String streetName;
    private String areaName;
    private String districtName;
    private Long pin;
    private String city;
    private String pageName;

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(String doorNum) {
        this.doorNum = doorNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Long getPin() {
        return pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        rollNum = null;
        doorNum = null;
        streetName = null;
        areaName = null;
        districtName = null;
        pin = null;
        city = null;
    }

}
