/**
 *
 */
package org.edu.uams.client.action;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.dto.LabelValueBean;
import org.edu.uams.client.form.TransportModuleForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.api.FacultyType;
import org.edu.uams.server.business.BusDetailsDao;
import org.edu.uams.server.business.StudentBusAccDetailsDao;
import org.edu.uams.server.business.BusFacultyDao;
import org.edu.uams.server.pojo.BusFacultyEntity;
import org.edu.uams.server.util.ApplicationUtil;
import org.edu.uams.server.pojo.BusDetailsEntity;
import org.edu.uams.server.pojo.StudentBusAccDetailsEntity;


public class TransportModuleAction extends DispatchAction {
    
    
    
    
    public ActionForward busFacultyPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        TransportModuleForm transportModuleForm = (TransportModuleForm)form;
        System.out.println("transportModuleForm:"+transportModuleForm.getPageName());
        BusFacultyDao busFacultyDao = new BusFacultyDao();
        
        
        if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals(ApplicationConstants.GET_EDIT_TYPE_FORM))
        {
            BusFacultyEntity busFacultyEntity = busFacultyDao.findByPrimaryKey(transportModuleForm.getId());
            transportModuleForm.resetForm();
            transportModuleForm.setAddrLine1(busFacultyEntity.getAddrLine1());
            transportModuleForm.setAddrLine2(busFacultyEntity.getAddrLine2());
            transportModuleForm.setAddrLine3(busFacultyEntity.getAddrLine3());
            transportModuleForm.setAddrLine4(busFacultyEntity.getAddrLine4());
            transportModuleForm.setCity(busFacultyEntity.getCity());
            transportModuleForm.setFirstName(busFacultyEntity.getFirstName());
            transportModuleForm.setLastName(busFacultyEntity.getLastName());
            transportModuleForm.setMobile(busFacultyEntity.getMobile());
            transportModuleForm.setStateName(busFacultyEntity.getStateName());
            transportModuleForm.setZipCode(busFacultyEntity.getZipCode());
            transportModuleForm.setFacultyType(busFacultyEntity.getFacultyType().name());
            transportModuleForm.setLicenseNum(busFacultyEntity.getLicenceNum());
            if(busFacultyEntity.getLicenceExpiryDate()!= null){
                transportModuleForm.setLicenseExpiryDate(ApplicationUtil.formatDateToString(busFacultyEntity.getLicenceExpiryDate()));
            }
            transportModuleForm.setId(busFacultyEntity.getId());
        }
        
        else if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE))
        {
            BusFacultyEntity busFacultyEntity = busFacultyDao.findByPrimaryKey(transportModuleForm.getId());
            busFacultyEntity.setAddrLine1(transportModuleForm.getAddrLine1());
            busFacultyEntity.setAddrLine2(transportModuleForm.getAddrLine2());
            busFacultyEntity.setAddrLine3(transportModuleForm.getAddrLine3());
            busFacultyEntity.setAddrLine4(transportModuleForm.getAddrLine4());
            busFacultyEntity.setCity(transportModuleForm.getCity());
            busFacultyEntity.setFirstName(transportModuleForm.getFirstName());
            busFacultyEntity.setLastName(transportModuleForm.getLastName());
            busFacultyEntity.setMobile(transportModuleForm.getMobile());
            busFacultyEntity.setStateName(transportModuleForm.getStateName());
            busFacultyEntity.setZipCode(transportModuleForm.getZipCode());
            busFacultyEntity.setFacultyType(FacultyType.valueOf(transportModuleForm.getFacultyType()));
            busFacultyEntity.setLicenceNum(transportModuleForm.getLicenseNum());
            
            if (transportModuleForm.getLicenseExpiryDate()!=null ) {
                Date expiryDate = ApplicationUtil.formatStringToDate(transportModuleForm.getLicenseExpiryDate());
                busFacultyEntity.setLicenceExpiryDate(expiryDate);
            }
            
            busFacultyDao.update(busFacultyEntity);
            transportModuleForm.resetForm();
        }
        
        else if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE))
        {
            BusFacultyEntity busFacultyEntity = new BusFacultyEntity();
            busFacultyEntity.setAddrLine1(transportModuleForm.getAddrLine1());
            busFacultyEntity.setAddrLine2(transportModuleForm.getAddrLine2());
            busFacultyEntity.setAddrLine3(transportModuleForm.getAddrLine3());
            busFacultyEntity.setAddrLine4(transportModuleForm.getAddrLine4());
            busFacultyEntity.setCity(transportModuleForm.getCity());
            busFacultyEntity.setFirstName(transportModuleForm.getFirstName());
            busFacultyEntity.setLastName(transportModuleForm.getLastName());
            busFacultyEntity.setMobile(transportModuleForm.getMobile());
            busFacultyEntity.setStateName(transportModuleForm.getStateName());
            busFacultyEntity.setZipCode(transportModuleForm.getZipCode());
            busFacultyEntity.setFacultyType(FacultyType.valueOf(transportModuleForm.getFacultyType()));
            busFacultyEntity.setLicenceNum(transportModuleForm.getLicenseNum());
            if (transportModuleForm.getLicenseExpiryDate()!=null ) {
                Date expiryDate = ApplicationUtil.formatStringToDate(transportModuleForm.getLicenseExpiryDate());
                busFacultyEntity.setLicenceExpiryDate(expiryDate);
            }
            busFacultyDao.persist(busFacultyEntity);
            transportModuleForm.resetForm();
        }
        
        List<BusFacultyEntity> busFacultyList = busFacultyDao.findAll();
        transportModuleForm.setFacultyTypeList(getFacultyTypeList());
        if(!busFacultyList.isEmpty()){
            transportModuleForm.setBusFacultyList(busFacultyList);
        }
        req.setAttribute("transportModule", "true");
        req.setAttribute("busFacultyPage", "true");
        return mapping.findForward("busFacultyPage");
    }
    
    
    
    public ActionForward busDetailsPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        TransportModuleForm transportModuleForm = (TransportModuleForm)form;
        System.out.println("transportModuleForm:"+transportModuleForm.getPageName());
        BusDetailsDao busDetailsDao = new BusDetailsDao();
        BusFacultyDao busFacultyDao = new BusFacultyDao();
        
        
        
        if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals(ApplicationConstants.GET_EDIT_TYPE_FORM))
        {
            BusDetailsEntity busDetailsEntity = busDetailsDao.findByPrimaryKey(transportModuleForm.getId());
            transportModuleForm.resetForm();
            transportModuleForm.setChassisNum(busDetailsEntity.getChassisNum());
            transportModuleForm.setNumOfSeats(busDetailsEntity.getNumOfSeats());
            transportModuleForm.setRegistrationNum(busDetailsEntity.getRegistrationNum());
            transportModuleForm.setTravelPerDay(busDetailsEntity.getTravelPerDay());
            transportModuleForm.setDriverId(busDetailsEntity.getDriver().getId());
            transportModuleForm.setCoordinatorId(busDetailsEntity.getCoordinator().getId());
            transportModuleForm.setCleanerOrHelperId(busDetailsEntity.getCleanerOrHelper().getId());
            transportModuleForm.setId(busDetailsEntity.getId());
        }
        
        else if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE))
        {
            BusDetailsEntity busDetailsEntity = busDetailsDao.findByPrimaryKey(transportModuleForm.getId());
            busDetailsEntity.setChassisNum(transportModuleForm.getChassisNum());
            busDetailsEntity.setNumOfSeats(transportModuleForm.getNumOfSeats());
            busDetailsEntity.setRegistrationNum(transportModuleForm.getRegistrationNum());
            busDetailsEntity.setTravelPerDay(transportModuleForm.getTravelPerDay());
            
            if (transportModuleForm.getDriverId()>0) {
                BusFacultyEntity driver = busFacultyDao.findByPrimaryKey(transportModuleForm.getDriverId());
                busDetailsEntity.setDriver(driver);
            }
            
            if (transportModuleForm.getCleanerOrHelperId()>0) {
                BusFacultyEntity cleaner = busFacultyDao.findByPrimaryKey(transportModuleForm.getCleanerOrHelperId());
                busDetailsEntity.setCleanerOrHelper(cleaner);
            }
            
            if (transportModuleForm.getCoordinatorId()>0) {
                BusFacultyEntity coordinator = busFacultyDao.findByPrimaryKey(transportModuleForm.getCoordinatorId());
                busDetailsEntity.setCoordinator(coordinator);
            }
            busDetailsDao.update(busDetailsEntity);
            transportModuleForm.resetForm();
        }
        
        else if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE))
        {
            BusDetailsEntity busDetailsEntity = new BusDetailsEntity();
            Long countOfBuses= busDetailsDao.getCountOfBuses();
            if (countOfBuses!=null && countOfBuses> 0) {
                Long busNum=countOfBuses+1;
                busDetailsEntity.setBusNum("B"+busNum);
            }else{
                busDetailsEntity.setBusNum("B"+1);
            }
            
            busDetailsEntity.setChassisNum(transportModuleForm.getChassisNum());
            busDetailsEntity.setNumOfSeats(transportModuleForm.getNumOfSeats());
            busDetailsEntity.setRegistrationNum(transportModuleForm.getRegistrationNum());
            busDetailsEntity.setTravelPerDay(transportModuleForm.getTravelPerDay());
            
            if (transportModuleForm.getDriverId()>0) {
                BusFacultyEntity driver = busFacultyDao.findByPrimaryKey(transportModuleForm.getDriverId());
                busDetailsEntity.setDriver(driver);
            }
            
            if (transportModuleForm.getCleanerOrHelperId()>0) {
                BusFacultyEntity cleaner = busFacultyDao.findByPrimaryKey(transportModuleForm.getCleanerOrHelperId());
                busDetailsEntity.setCleanerOrHelper(cleaner);
            }
            
            if (transportModuleForm.getCoordinatorId()>0) {
                BusFacultyEntity coordinator = busFacultyDao.findByPrimaryKey(transportModuleForm.getCoordinatorId());
                busDetailsEntity.setCoordinator(coordinator);
            }
            
            busDetailsDao.persist(busDetailsEntity);
            transportModuleForm.resetForm();
        }
        
        List<BusFacultyEntity> busFacultyList = busFacultyDao.findAll();
        setFacultyTypeList(transportModuleForm, busFacultyList);
        
        transportModuleForm.setBusDetailsList(null);
        //For Display Grid
        
        List<BusDetailsEntity> busDetailsList = busDetailsDao.findAll();
        if(!busDetailsList.isEmpty()){
            transportModuleForm.setBusDetailsList(busDetailsList);
        }
        req.setAttribute("transportModule", "true");
        req.setAttribute("busDetailsPage", "true");
        return mapping.findForward("busDetailsPage");
    }
    
    public ActionForward studentBusAccDetailsPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        TransportModuleForm transportModuleForm = (TransportModuleForm)form;
        System.out.println("transportModuleForm:"+transportModuleForm.getPageName());
        BusDetailsDao busDetailsDao = new BusDetailsDao();
        StudentBusAccDetailsDao studentBusAccDetailsDao=new StudentBusAccDetailsDao();
        
        
        if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals(ApplicationConstants.GET_EDIT_TYPE_FORM))
        {
            StudentBusAccDetailsEntity studentBusAccDetailsEntity = studentBusAccDetailsDao.findByPrimaryKey(transportModuleForm.getId());
            transportModuleForm.resetForm();
            transportModuleForm.setAreaName(studentBusAccDetailsEntity.getAreaName());
            transportModuleForm.setBusNum(studentBusAccDetailsEntity.getBusDetails().getBusNum());
            transportModuleForm.setBusDetailsId(studentBusAccDetailsEntity.getBusDetails().getId());
            if(studentBusAccDetailsEntity.getBusRegDate()!= null){
                transportModuleForm.setBusRegDate(ApplicationUtil.formatDateToString(studentBusAccDetailsEntity.getBusRegDate()));
            }
            
            if(studentBusAccDetailsEntity.getBusCancelDate()!= null){
                transportModuleForm.setBusCancelDate(ApplicationUtil.formatDateToString(studentBusAccDetailsEntity.getBusCancelDate()));
            }
            transportModuleForm.setStudentRollNum(studentBusAccDetailsEntity.getStudentRollNum());
            transportModuleForm.setBusSeatNum(studentBusAccDetailsEntity.getBusSeatNum());
            transportModuleForm.setId(studentBusAccDetailsEntity.getId());
        }
        
        else if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE))
        {
            StudentBusAccDetailsEntity studentBusAccDetailsEntity = studentBusAccDetailsDao.findByPrimaryKey(transportModuleForm.getId());
            if (transportModuleForm.getBusDetailsId()>0) {
                BusDetailsEntity busDetailsEntity = busDetailsDao.findByPrimaryKey(transportModuleForm.getBusDetailsId());
                studentBusAccDetailsEntity.setBusDetails(busDetailsEntity);
            }
            
            studentBusAccDetailsEntity.setAreaName(transportModuleForm.getAreaName());
            if(transportModuleForm.getBusRegDate()!= null){
                studentBusAccDetailsEntity.setBusRegDate(ApplicationUtil.formatStringToDate(transportModuleForm.getBusRegDate()));
            }
            
            if(transportModuleForm.getBusCancelDate()!= null){
                studentBusAccDetailsEntity.setBusCancelDate(ApplicationUtil.formatStringToDate(transportModuleForm.getBusCancelDate()));
            }
            studentBusAccDetailsEntity.setStudentRollNum(transportModuleForm.getStudentRollNum());
            studentBusAccDetailsEntity.setBusSeatNum(transportModuleForm.getBusSeatNum());
            studentBusAccDetailsDao.update(studentBusAccDetailsEntity);
            transportModuleForm.resetForm();
        }
        
        else if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE))
        {
            StudentBusAccDetailsEntity studentBusAccDetailsEntity=new StudentBusAccDetailsEntity();
            if (transportModuleForm.getBusDetailsId()>0) {
                BusDetailsEntity busDetailsEntity = busDetailsDao.findByPrimaryKey(transportModuleForm.getBusDetailsId());
                studentBusAccDetailsEntity.setBusDetails(busDetailsEntity);
            }
            
            studentBusAccDetailsEntity.setAreaName(transportModuleForm.getAreaName());
            if(transportModuleForm.getBusRegDate()!= null){
                studentBusAccDetailsEntity.setBusRegDate(ApplicationUtil.formatStringToDate(transportModuleForm.getBusRegDate()));
            }
            
            if(transportModuleForm.getBusCancelDate()!= null){
                studentBusAccDetailsEntity.setBusCancelDate(ApplicationUtil.formatStringToDate(transportModuleForm.getBusCancelDate()));
            }
            studentBusAccDetailsEntity.setStudentRollNum(transportModuleForm.getStudentRollNum());
            studentBusAccDetailsEntity.setBusSeatNum(transportModuleForm.getBusSeatNum());
            studentBusAccDetailsDao.persist(studentBusAccDetailsEntity);
            transportModuleForm.resetForm();
        }
        
        
        transportModuleForm.setBusDetailsList(null);
        //For Display Grid
        
        List<BusDetailsEntity> busDetailsList = busDetailsDao.findAll();
        transportModuleForm.setBusDetailsList(busDetailsList);
        List<StudentBusAccDetailsEntity> studentBusAccDetailsList = studentBusAccDetailsDao.findAll();
        transportModuleForm.setStudentBusAccDetailsList(null);
        if(!studentBusAccDetailsList.isEmpty()){
            transportModuleForm.setStudentBusAccDetailsList(studentBusAccDetailsList);
        }
        req.setAttribute("transportModule", "true");
        req.setAttribute("studentBusAccDetailsPage", "true");
        return mapping.findForward("studentBusAccDetailsPage");
    }
    
    
    private List<LabelValueBean> getFacultyTypeList() {
        List<LabelValueBean> facultyTypeList = new ArrayList<>();
        for (FacultyType facultyType : FacultyType.values()) {
            facultyTypeList.add(new LabelValueBean(facultyType.name(), facultyType.name()));
        }
        return facultyTypeList;
    }
    
    
    private void setFacultyTypeList(TransportModuleForm transportModuleForm ,List<BusFacultyEntity> facultyList) {
        
        List<BusFacultyEntity> busDriverList=new ArrayList<>();
        List<BusFacultyEntity> busCleanerList=new ArrayList<>();
        List<BusFacultyEntity> busCoordinatorList=new ArrayList<>();
        
        if (facultyList!=null && !facultyList.isEmpty()) {
            for (BusFacultyEntity busFacultyEntity : facultyList) {
                if (!busFacultyEntity.isHasBusAssigned() && busFacultyEntity.getFacultyType().equals(FacultyType.DRIVER) ) {
                    busDriverList.add(busFacultyEntity);
                }
                if (!busFacultyEntity.isHasBusAssigned()  && busFacultyEntity.getFacultyType().equals(FacultyType.CLEANER)) {
                    busCleanerList.add(busFacultyEntity);
                }
                if (busFacultyEntity.getFacultyType().equals(FacultyType.COORDINATOR)) {
                    busCoordinatorList.add(busFacultyEntity);
                }
            }
        }
        transportModuleForm.setDiverList(busDriverList);
        transportModuleForm.setCleanerOrHelperList(busCleanerList);
        transportModuleForm.setCoordinatorList(busCoordinatorList);
    }
    
    
    
    public ActionForward getAllbusFacultyPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        TransportModuleForm transportModuleForm = (TransportModuleForm)form;
        System.out.println("transportModuleForm:"+transportModuleForm.getPageName());
        BusFacultyDao busFacultyDao = new BusFacultyDao();
        
        List<BusFacultyEntity> busFacultyList = busFacultyDao.findAll();
        
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(busFacultyList, new TypeToken<List<BusFacultyEntity>>() {}.getType());
        
        JsonArray jsonArray = element.getAsJsonArray();
        res.setContentType("application/json");
        res.getWriter().print(jsonArray);
        return null;
    }
}












