/**
 *
 */
package org.edu.uams.client.form;

import java.util.List;
import org.apache.struts.action.ActionForm;


public class TransportModuleForm extends ActionForm {
    
    
    
    private long id;
    private String pageName;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getPageName() {
        return pageName;
    }
    
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    //Bus  details Starts
    
    private String busNum;
    private String registrationNum;
    private long driverId;
    private long cleanerOrHelperId;
    private long coordinatorId;
    private int numOfSeats;
    private Long travelPerDay;
    private String chassisNum;
    private List busDetailsList;
    private List diverList=null;
    private List coordinatorList;
    private List cleanerOrHelperList;
    
    //Bus  details Ends
    
    
    //StudentBusAccDetails Starts
    
    private String busRegDate;
    private String busCancelDate;
    private String areaName;
    private long busDetailsId;
    private long feeDetailsId;
    private long busSeatNum;
    private Long studentRollNum;
    private List studentBusAccDetailsList;
    
    public String getBusRegDate() {
        return busRegDate;
    }
    
    public void setBusRegDate(String busRegDate) {
        this.busRegDate = busRegDate;
    }
    
    public String getBusCancelDate() {
        return busCancelDate;
    }
    
    public void setBusCancelDate(String busCancelDate) {
        this.busCancelDate = busCancelDate;
    }
    
    public String getAreaName() {
        return areaName;
    }
    
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
    public long getBusDetailsId() {
        return busDetailsId;
    }
    
    public void setBusDetailsId(long busDetailsId) {
        this.busDetailsId = busDetailsId;
    }
    
    public long getFeeDetailsId() {
        return feeDetailsId;
    }
    
    public void setFeeDetailsId(long feeDetailsId) {
        this.feeDetailsId = feeDetailsId;
    }
    
    public long getBusSeatNum() {
        return busSeatNum;
    }
    
    public void setBusSeatNum(long busSeatNum) {
        this.busSeatNum = busSeatNum;
    }
    
    public Long getStudentRollNum() {
        return studentRollNum;
    }
    
    public void setStudentRollNum(Long studentRollNum) {
        this.studentRollNum = studentRollNum;
    }
    
    public List getStudentBusAccDetailsList() {
        return studentBusAccDetailsList;
    }
    
    public void setStudentBusAccDetailsList(List studentBusAccDetailsList) {
        this.studentBusAccDetailsList = studentBusAccDetailsList;
    }
    
    
    
    
    //StudentBusAccDetails Ends
    
    
    //Bus Faculty details starts
    private String firstName;
    private String lastName;
    private String addrLine1;
    private String addrLine2;
    private String addrLine3;
    private String addrLine4;
    private String city;
    private String stateName;
    private long zipCode;
    private long mobile;
    private String facultyType;
    private String licenseNum;
    private String licenseExpiryDate ;
    
    private List facultyTypeList;
    private  List busFacultyList;
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    
    public List getFacultyTypeList() {
        return facultyTypeList;
    }
    
    public void setFacultyTypeList(List facultyTypeList) {
        this.facultyTypeList = facultyTypeList;
    }
    
    
    
    public List getBusFacultyList() {
        return busFacultyList;
    }
    
    public void setBusFacultyList(List busFacultyList) {
        this.busFacultyList = busFacultyList;
    }
    
    public String getFacultyType() {
        return facultyType;
    }
    
    public void setFacultyType(String facultyType) {
        this.facultyType = facultyType;
    }
    
    public String getLicenseNum() {
        return licenseNum;
    }
    
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }
    
    public String getLicenseExpiryDate() {
        return licenseExpiryDate;
    }
    
    public void setLicenseExpiryDate(String licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }
    
    
    
    //Bus Faculty details ends
    
    
    //Bus  details Starts
    
    public String getBusNum() {
        return busNum;
    }
    
    public void setBusNum(String busNum) {
        this.busNum = busNum;
    }
    
    public String getRegistrationNum() {
        return registrationNum;
    }
    
    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }
    
    public long getDriverId() {
        return driverId;
    }
    
    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }
    
    public long getCleanerOrHelperId() {
        return cleanerOrHelperId;
    }
    
    public void setCleanerOrHelperId(long cleanerOrHelperId) {
        this.cleanerOrHelperId = cleanerOrHelperId;
    }
    
    public long getCoordinatorId() {
        return coordinatorId;
    }
    
    public void setCoordinatorId(long coordinatorId) {
        this.coordinatorId = coordinatorId;
    }
    
    public int getNumOfSeats() {
        return numOfSeats;
    }
    
    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }
    
    public Long getTravelPerDay() {
        return travelPerDay;
    }
    
    public void setTravelPerDay(Long travelPerDay) {
        this.travelPerDay = travelPerDay;
    }
    
    public String getChassisNum() {
        return chassisNum;
    }
    
    public void setChassisNum(String chassisNum) {
        this.chassisNum = chassisNum;
    }
    
    public List getBusDetailsList() {
        return busDetailsList;
    }
    
    public void setBusDetailsList(List busDetailsList) {
        this.busDetailsList = busDetailsList;
    }
    
    public List getDiverList() {
        return diverList;
    }
    
    public void setDiverList(List diverList) {
        this.diverList = diverList;
    }
    
    public List getCoordinatorList() {
        return coordinatorList;
    }
    
    public void setCoordinatorList(List coordinatorList) {
        this.coordinatorList = coordinatorList;
    }
    
    public List getCleanerOrHelperList() {
        return cleanerOrHelperList;
    }
    
    public void setCleanerOrHelperList(List cleanerOrHelperList) {
        this.cleanerOrHelperList = cleanerOrHelperList;
    }
    
    
    //Bus  details Ends
    
    
    public void resetForm(){
        this.id =0l;
        this.pageName=null;
        this.firstName=null;
        this.lastName =null;
        this.addrLine1=null;
        this.addrLine2 =null;
        this.addrLine3 =null;
        this.addrLine4 =null;
        this.city=null;
        this.stateName =null;
        this.zipCode =0l;
        this.mobile=0l;
        this.facultyTypeList=null;
        this.busFacultyList=null;
        this.licenseNum=null;
        this.licenseExpiryDate =null;
        this.busNum =null;
        this.registrationNum =null;
        this.driverId =0L;
        this.cleanerOrHelperId =0L;
        this. coordinatorId =0L;
        this.numOfSeats =0;
        this.travelPerDay =null;
        this.chassisNum =null;
        this.busRegDate=null;
        this.busCancelDate=null;
        this.areaName=null;
        this.busDetailsId=0l;
        this.feeDetailsId=0l;
        this.busSeatNum=0l;
        this.studentRollNum=null;
        this.studentBusAccDetailsList=null;
    }
    
    
    
}
