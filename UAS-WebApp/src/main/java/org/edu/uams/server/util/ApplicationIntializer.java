package org.edu.uams.server.util;

import java.util.List;

import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.business.CourseTypeDao;
import org.edu.uams.server.business.ProgramLevelTypeDao;
import org.edu.uams.server.business.FeeCategoryTypeDao;
import org.edu.uams.server.business.FeeTypeDao;
import org.edu.uams.server.business.UserMasterDao;
import org.edu.uams.server.business.UserMasterTypeDao;
import org.edu.uams.server.pojo.CourseTypeEntity;
import org.edu.uams.server.pojo.ProgramLevelTypeEntity;
import org.edu.uams.server.pojo.FeeCategoryTypeEntity;
import org.edu.uams.server.pojo.FeeTypeEntity;
import org.edu.uams.server.pojo.UserMasterEntity;
import org.edu.uams.server.pojo.UserMasterTypeEntity;

public class ApplicationIntializer {
    
    private static UserMasterTypeDao userMasterTypeDao=null;
    private static ProgramLevelTypeDao programLevelTypeDao=null;
    private static CourseTypeDao courseTypeDao=null;
    private static FeeTypeDao feeTypeDao=null;
    private static FeeCategoryTypeDao feeCategoryTypeDao=null;
    
    public static void init() {
        createUserMasterTypeValues();
        createUserMasterDefaultValue();
        createProgramLevelTypeValues();
        createCourseTypeValues();
        createFeeDataValues();
    }
    
    
    
    private static void createUserMasterTypeValues() {
        
        userMasterTypeDao=new UserMasterTypeDao();
        List<UserMasterTypeEntity> userTypelist = userMasterTypeDao.findAll();
        
        if (userTypelist==null || userTypelist.isEmpty()) {
            UserMasterTypeEntity professor = new UserMasterTypeEntity(ApplicationConstants.PROFESSOR,ApplicationConstants.PROFESSOR);
            UserMasterTypeEntity student = new UserMasterTypeEntity(ApplicationConstants.STUDENT,ApplicationConstants.STUDENT);
            UserMasterTypeEntity clerk = new UserMasterTypeEntity(ApplicationConstants.CLERK,ApplicationConstants.CLERK);
            UserMasterTypeEntity admin = new UserMasterTypeEntity(ApplicationConstants.ADMIN,ApplicationConstants.ADMIN);
            userMasterTypeDao.persist(admin);
            userMasterTypeDao.persist(professor);
            userMasterTypeDao.persist(clerk);
            userMasterTypeDao.persist(student);
        }
        
    }
    
    private static void createUserMasterDefaultValue() {
        
        UserMasterDao userMasterDao=new UserMasterDao();
        UserMasterEntity admin =userMasterDao.findUserName(ApplicationConstants.ADMIN);
        
        
        if (admin==null) {
            admin=new UserMasterEntity();
            admin.setPassword("pwd");
            admin.setEmail("admin.@tmail.com");
            admin.setUserName(ApplicationConstants.ADMIN);
            admin.setUserType(userMasterTypeDao.findByCode(ApplicationConstants.ADMIN));
            admin.setEmail("admin@test.com");
            userMasterDao.persist(admin);
        }
    }
    
    
    private static void createProgramLevelTypeValues() {
        
        programLevelTypeDao=new ProgramLevelTypeDao();
        List<ProgramLevelTypeEntity> programLevelTypeList = programLevelTypeDao.findAll();
        
        if (programLevelTypeList==null || programLevelTypeList.isEmpty()) {
            
            ProgramLevelTypeEntity programLevelType1 = new ProgramLevelTypeEntity("BACHELOR'S","Bachelor's Degree");
            ProgramLevelTypeEntity programLevelType2 = new ProgramLevelTypeEntity("MASTERS","Master's Degree");
            ProgramLevelTypeEntity programLevelType3 = new ProgramLevelTypeEntity("DR","Doctoral Degree");
            ProgramLevelTypeEntity programLevelType4 = new ProgramLevelTypeEntity("DIPLOMA","Diploma");
               
            programLevelTypeDao.persist(programLevelType1);
            programLevelTypeDao.persist(programLevelType2);
            programLevelTypeDao.persist(programLevelType3);
            programLevelTypeDao.persist(programLevelType4);
        }
        
    }
    
    private static void createCourseTypeValues() {
        
        courseTypeDao=new CourseTypeDao();
        List<CourseTypeEntity> courseTypeList = courseTypeDao.findAll();
        
        if (courseTypeList==null || courseTypeList.isEmpty()) {
            CourseTypeEntity ece = new CourseTypeEntity("ECE","Electronics & Communication Engineering");
            CourseTypeEntity eee = new CourseTypeEntity("EEE","Electrical & Electronics Engineering");
            CourseTypeEntity cse = new CourseTypeEntity("CSE","Computer Science Engineering");
            CourseTypeEntity ba = new CourseTypeEntity("BA","Bachelor of Arts");
            CourseTypeEntity barch = new CourseTypeEntity("B.Arch","Bachelor of Architecture");
            CourseTypeEntity bLlb = new CourseTypeEntity("BLLB","Bachelor of Law (LLB Honours)");
            CourseTypeEntity bComm = new CourseTypeEntity("BCOM","Bachelor of Commerce");
            CourseTypeEntity bba = new CourseTypeEntity("BBA","Bachelor of Business Administration");
            CourseTypeEntity mba = new CourseTypeEntity("M.B.A","Master of Business Administration");
            
            courseTypeDao.persist(ba);
            courseTypeDao.persist(ece);
            courseTypeDao.persist(eee);
            courseTypeDao.persist(cse);
            courseTypeDao.persist(barch);
            courseTypeDao.persist(mba);
            courseTypeDao.persist(ba);
            courseTypeDao.persist(bLlb);
            courseTypeDao.persist(bba);
            courseTypeDao.persist(bComm);
        }
    }
    
    private static void createFeeDataValues() {
        feeCategoryTypeDao=new FeeCategoryTypeDao();
        feeTypeDao=new FeeTypeDao();
        
        List<FeeCategoryTypeEntity> feeCatTypeList = feeCategoryTypeDao.findAll();
        List<FeeTypeEntity> feeTypeList = feeTypeDao.findAll();
        
        if ((feeCatTypeList==null || feeCatTypeList.isEmpty()) && (feeTypeList==null || feeTypeList.isEmpty())) {
            FeeCategoryTypeEntity fcType1 = new FeeCategoryTypeEntity("SPORTS","Sports Fees");
            FeeCategoryTypeEntity fcType2 = new FeeCategoryTypeEntity("REG FEE","Registration Fees");
            FeeCategoryTypeEntity fcType3 = new FeeCategoryTypeEntity("ENROLL fee","Enrollment Fees");
            FeeCategoryTypeEntity fcType4 = new FeeCategoryTypeEntity("EXAM fee","Exam Fees");
            FeeCategoryTypeEntity fcType5 = new FeeCategoryTypeEntity("BUS fee","Bus Fees");
            FeeCategoryTypeEntity fcType6 = new FeeCategoryTypeEntity("HOS fee","Bus Fees");
            FeeCategoryTypeEntity fcType7 = new FeeCategoryTypeEntity("LIB fee","Library Fees");
            feeCategoryTypeDao.persist(fcType1);
            feeCategoryTypeDao.persist(fcType2);
            feeCategoryTypeDao.persist(fcType3);
            feeCategoryTypeDao.persist(fcType4);
            feeCategoryTypeDao.persist(fcType5);
            feeCategoryTypeDao.persist(fcType6);
            feeCategoryTypeDao.persist(fcType7);
            
            FeeTypeEntity feetType1 = new FeeTypeEntity("EXM-BE-2015 ","BE EXAM FEE 2015",fcType4);
            FeeTypeEntity feetType2 = new FeeTypeEntity("EXM-BCOM-2015 ","BCOM EXAM FEE 2015",fcType4);
            FeeTypeEntity feetType3 = new FeeTypeEntity("EXM-BSC-2015 ","BSC EXAM FEE 2015",fcType4);
            feeTypeDao.persist(feetType1);
            feeTypeDao.persist(feetType2);
            feeTypeDao.persist(feetType3);
        }
    }
    
    
}
