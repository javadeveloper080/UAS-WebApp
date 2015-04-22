package org.edu.uams.server.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.api.EnrollmentStatusType;
import org.edu.uams.server.api.GenderType;
import org.edu.uams.server.api.SeatCategoryType;
import org.edu.uams.server.business.CourseTypeDao;
import org.edu.uams.server.business.ProgramLevelTypeDao;
import org.edu.uams.server.business.FeeCategoryTypeDao;
import org.edu.uams.server.business.FeeTypeDao;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.business.StudentEnrollmentDAO;
import org.edu.uams.server.business.UserMasterDao;
import org.edu.uams.server.business.UserMasterTypeDao;
import org.edu.uams.server.pojo.CourseTypeEntity;
import org.edu.uams.server.pojo.ProgramLevelTypeEntity;
import org.edu.uams.server.pojo.FeeCategoryTypeEntity;
import org.edu.uams.server.pojo.FeeTypeEntity;
import org.edu.uams.server.pojo.StudentEnrollmentEntity;
import org.edu.uams.server.pojo.StudentEntity;
import org.edu.uams.server.pojo.UserMasterEntity;
import org.edu.uams.server.pojo.UserMasterTypeEntity;

public class ApplicationIntializer {

    private static UserMasterTypeDao userMasterTypeDao = null;
    private static ProgramLevelTypeDao programLevelTypeDao = null;
    private static CourseTypeDao courseTypeDao = null;
    private static FeeTypeDao feeTypeDao = null;
    private static FeeCategoryTypeDao feeCategoryTypeDao = null;
    private static StudentDao studentDao = null;
    private static StudentEnrollmentDAO studentEnrollmentDAO = null;
    private static List<String> enrollmentNumbers = null;

    public static void init() {
        createUserMasterTypeValues();
        createUserMasterDefaultValue();
        createProgramLevelTypeValues();
        createCourseTypeValues();
        createFeeDataValues();
        createStudentEnrollmentValues();
        createStudentValues();
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
        feeCategoryTypeDao = new FeeCategoryTypeDao();
        feeTypeDao = new FeeTypeDao();

        List<FeeCategoryTypeEntity> feeCatTypeList = feeCategoryTypeDao.findAll();
        List<FeeTypeEntity> feeTypeList = feeTypeDao.findAll();

        if ((feeCatTypeList == null || feeCatTypeList.isEmpty()) && (feeTypeList == null || feeTypeList.isEmpty())) {
            FeeCategoryTypeEntity fcType1 = new FeeCategoryTypeEntity("SPORTS", "Sports Fees");
            FeeCategoryTypeEntity fcType2 = new FeeCategoryTypeEntity("REG FEE", "Registration Fees");
            FeeCategoryTypeEntity fcType3 = new FeeCategoryTypeEntity("ENROLL fee", "Enrollment Fees");
            FeeCategoryTypeEntity fcType4 = new FeeCategoryTypeEntity("EXAM fee", "Exam Fees");
            FeeCategoryTypeEntity fcType5 = new FeeCategoryTypeEntity("BUS fee", "Bus Fees");
            FeeCategoryTypeEntity fcType6 = new FeeCategoryTypeEntity("HOS fee", "Bus Fees");
            FeeCategoryTypeEntity fcType7 = new FeeCategoryTypeEntity("LIB fee", "Library Fees");
            feeCategoryTypeDao.persist(fcType1);
            feeCategoryTypeDao.persist(fcType2);
            feeCategoryTypeDao.persist(fcType3);
            feeCategoryTypeDao.persist(fcType4);
            feeCategoryTypeDao.persist(fcType5);
            feeCategoryTypeDao.persist(fcType6);
            feeCategoryTypeDao.persist(fcType7);

            FeeTypeEntity feetType1 = new FeeTypeEntity("EXM-BE-2015 ", "BE EXAM FEE 2015", fcType4);
            FeeTypeEntity feetType2 = new FeeTypeEntity("EXM-BCOM-2015 ", "BCOM EXAM FEE 2015", fcType4);
            FeeTypeEntity feetType3 = new FeeTypeEntity("EXM-BSC-2015 ", "BSC EXAM FEE 2015", fcType4);
            feeTypeDao.persist(feetType1);
            feeTypeDao.persist(feetType2);
            feeTypeDao.persist(feetType3);
        }
    }

    private static void createStudentValues() {
        studentDao = new StudentDao();
        studentEnrollmentDAO = new StudentEnrollmentDAO();
        StudentEntity studentEntity = new StudentEntity();

        StudentEnrollmentEntity studentEnrollmentEntity = studentEnrollmentDAO.findByStudentEnrollmentNumber(enrollmentNumbers.get(0));
        studentEntity.setStudentEnrollment(studentEnrollmentEntity);
        int year = Calendar.getInstance().get(Calendar.YEAR);

        studentEntity.setRollNum(studentEnrollmentEntity.getEnrollmentNumber() + "-" + year);

        studentEntity.setDob(ApplicationUtil.formatStringToDate("03/01/1998"));
        studentEntity.setFatherName("Sankar");
        studentEntity.setGenderType(GenderType.valueOf("MALE"));
        studentEntity.setMotherName("Bharathi");
        studentEntity.setFirstName("Siva");
        studentEntity.setLastName("Kumar");
        studentEntity.setStudentMob(9855123456L);
        studentEntity.setEmail("siva@gmail.com");
        studentEntity.setParentMob("8105202030");
        studentEntity.setMotherOccup("House Wife");
        studentEntity.setFatherOccup("Clerk");
        studentEntity.setNationality("Indian");
        studentEntity.setSeatCategoryType(SeatCategoryType.valueOf("GENERAL"));
        studentDao.persist(studentEntity);

        StudentEntity studentEntity2 = new StudentEntity();
        StudentEnrollmentEntity studentEnrollmentEntity2 = studentEnrollmentDAO.findByStudentEnrollmentNumber(enrollmentNumbers.get(1));
        studentEntity2.setStudentEnrollment(studentEnrollmentEntity2);
        year = Calendar.getInstance().get(Calendar.YEAR);

        studentEntity2.setRollNum(studentEnrollmentEntity2.getEnrollmentNumber() + "-" + year);

        studentEntity2.setDob(ApplicationUtil.formatStringToDate("04/01/1998"));
        studentEntity2.setFatherName("Kalyan");
        studentEntity2.setGenderType(GenderType.valueOf("FEMALE"));
        studentEntity2.setMotherName("Sri Lakshmi");
        studentEntity2.setFirstName("Githa");
        studentEntity2.setLastName("Kumari");
        studentEntity2.setStudentMob(9855123488L);
        studentEntity2.setEmail("githa@gmail.com");
        studentEntity2.setParentMob("8105202044");
        studentEntity2.setMotherOccup("House Wife");
        studentEntity2.setFatherOccup("Manager");
        studentEntity2.setNationality("Indian");
        studentEntity2.setSeatCategoryType(SeatCategoryType.valueOf("GENERAL"));
        studentDao.persist(studentEntity2);
        
        
        StudentEntity studentEntity3 = new StudentEntity();
        StudentEnrollmentEntity studentEnrollmentEntity3 = studentEnrollmentDAO.findByStudentEnrollmentNumber(enrollmentNumbers.get(2));
        studentEntity3.setStudentEnrollment(studentEnrollmentEntity3);
        year = Calendar.getInstance().get(Calendar.YEAR);

        studentEntity3.setRollNum(studentEnrollmentEntity3.getEnrollmentNumber() + "-" + year);

        studentEntity3.setDob(ApplicationUtil.formatStringToDate("04/10/1998"));
        studentEntity3.setFatherName("Satish");
        studentEntity3.setGenderType(GenderType.valueOf("FEMALE"));
        studentEntity3.setMotherName("Tulasi");
        studentEntity3.setFirstName("Lohitha");
        studentEntity3.setLastName("Kumari");
        studentEntity3.setStudentMob(9855123466L);
        studentEntity3.setEmail("lohitha@gmail.com");
        studentEntity3.setParentMob("8105202066");
        studentEntity3.setMotherOccup("House Wife");
        studentEntity3.setFatherOccup("lecture");
        studentEntity3.setNationality("Indian");
        studentEntity3.setSeatCategoryType(SeatCategoryType.valueOf("GENERAL"));
        studentDao.persist(studentEntity3);
    }

    private static void createStudentEnrollmentValues() {

        enrollmentNumbers = new ArrayList<>();
        studentEnrollmentDAO = new StudentEnrollmentDAO();
        StudentEnrollmentEntity enrollmentEntity = new StudentEnrollmentEntity();
        Long nextId = studentEnrollmentDAO.getLastestId() + 1;
        programLevelTypeDao = new ProgramLevelTypeDao();
        courseTypeDao = new CourseTypeDao();

        CourseTypeEntity appliedCourse = courseTypeDao.findByCode("CSE");

        ProgramLevelTypeEntity appliedDProgramLevelType = programLevelTypeDao.findByCode("MASTERS");

        enrollmentEntity.setAppliedCourseType(appliedCourse);
        enrollmentEntity.setAppliedProgramLevelType(appliedDProgramLevelType);
        enrollmentEntity.setDateEnrolled(ApplicationUtil.formatStringToDate("8/01/2014"));
        enrollmentEntity.setDob(ApplicationUtil.formatStringToDate("03/01/1998"));
        enrollmentEntity.setEmail("siva@gmail.com");
        enrollmentEntity.setFirstName("Siva");
        enrollmentEntity.setGenderType(GenderType.valueOf("MALE"));
        enrollmentEntity.setEnrollmentStatusType(EnrollmentStatusType.PENDING);
        enrollmentEntity.setGrade(7.8);
        enrollmentEntity.setLastGraduatedCourseType(courseTypeDao.findByCode("CSE"));
        enrollmentEntity.setLastGraduatedProgramLevelType(programLevelTypeDao.findByCode("BACHELOR'S"));
        enrollmentEntity.setLastName("Kumar");
        enrollmentEntity.setStudentMob(9855123456L);

        String enrollmentNumber = appliedDProgramLevelType.getCode() + "-" + appliedCourse.getCode() + "-" + nextId;
        enrollmentEntity.setEnrollmentNumber(enrollmentNumber);

        studentEnrollmentDAO.persist(enrollmentEntity);
        enrollmentNumbers.add(enrollmentNumber);

        StudentEnrollmentEntity enrollmentEntity2 = new StudentEnrollmentEntity();
        nextId = studentEnrollmentDAO.getLastestId() + 1;

        enrollmentEntity2.setAppliedCourseType(appliedCourse);
        enrollmentEntity2.setAppliedProgramLevelType(appliedDProgramLevelType);
        enrollmentEntity2.setDateEnrolled(ApplicationUtil.formatStringToDate("10/01/2014"));
        enrollmentEntity2.setDob(ApplicationUtil.formatStringToDate("04/01/1998"));
        enrollmentEntity2.setEmail("githa@gmail.com");
        enrollmentEntity2.setFirstName("Githa");
        enrollmentEntity2.setGenderType(GenderType.valueOf("FEMALE"));
        enrollmentEntity2.setEnrollmentStatusType(EnrollmentStatusType.PENDING);
        enrollmentEntity2.setGrade(7.8);
        enrollmentEntity2.setLastGraduatedCourseType(courseTypeDao.findByCode("CSE"));
        enrollmentEntity2.setLastGraduatedProgramLevelType(programLevelTypeDao.findByCode("BACHELOR'S"));
        enrollmentEntity2.setLastName("Kumari");
        enrollmentEntity2.setStudentMob(9855123488L);

        String enrollmentNumber2 = appliedDProgramLevelType.getCode() + "-" + appliedCourse.getCode() + "-" + nextId;
        enrollmentEntity2.setEnrollmentNumber(enrollmentNumber2);
        enrollmentNumbers.add(enrollmentNumber2);

        studentEnrollmentDAO.persist(enrollmentEntity2);
        
         StudentEnrollmentEntity enrollmentEntity3 = new StudentEnrollmentEntity();
        nextId = studentEnrollmentDAO.getLastestId() + 1;

        enrollmentEntity3.setAppliedCourseType(appliedCourse);
        enrollmentEntity3.setAppliedProgramLevelType(appliedDProgramLevelType);
        enrollmentEntity3.setDateEnrolled(ApplicationUtil.formatStringToDate("10/06/2014"));
        enrollmentEntity3.setDob(ApplicationUtil.formatStringToDate("04/10/1998"));
        enrollmentEntity3.setEmail("lohitha@gmail.com");
        enrollmentEntity3.setFirstName("Lohitha");
        enrollmentEntity3.setGenderType(GenderType.valueOf("FEMALE"));
        enrollmentEntity3.setEnrollmentStatusType(EnrollmentStatusType.PENDING);
        enrollmentEntity3.setGrade(8.8);
        enrollmentEntity3.setLastGraduatedCourseType(courseTypeDao.findByCode("EEE"));
        enrollmentEntity3.setLastGraduatedProgramLevelType(programLevelTypeDao.findByCode("BACHELOR'S"));
        enrollmentEntity3.setLastName("Kumari");
        enrollmentEntity3.setStudentMob(9855123466L);

        String enrollmentNumber3 = appliedDProgramLevelType.getCode() + "-" + appliedCourse.getCode() + "-" + nextId;
        enrollmentEntity3.setEnrollmentNumber(enrollmentNumber3);
        enrollmentNumbers.add(enrollmentNumber3);

        studentEnrollmentDAO.persist(enrollmentEntity3);
    }

}
