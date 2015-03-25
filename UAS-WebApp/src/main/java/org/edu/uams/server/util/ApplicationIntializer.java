package org.edu.uams.server.util;

import java.util.List;

import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.business.CourseMasterDao;
import org.edu.uams.server.business.QuestionMasterDao;
import org.edu.uams.server.business.SessionMasterDao;
import org.edu.uams.server.business.UserMasterDao;
import org.edu.uams.server.business.UserMasterTypeDao;
import org.edu.uams.server.pojo.CourseMasterEntity;
import org.edu.uams.server.pojo.QuestionMasterEntity;
import org.edu.uams.server.pojo.SessionMasterEntity;
import org.edu.uams.server.pojo.UserMasterEntity;
import org.edu.uams.server.pojo.UserMasterTypeEntity;

public class ApplicationIntializer {
    
    private static UserMasterTypeDao userMasterTypeDao=null;
    private static CourseMasterDao courseMasterDao=null;
    private static SessionMasterDao sessionMasterDao=null;
    
    public static void init() {
        createUserMasterTypeValues();
        createUserMasterDefaultValue();
        createCourseMasterDefaultValue();
        createQuestionMasterDefaultValue();
        createDefaultSessionMasterValues();
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
            admin.setUserName(ApplicationConstants.ADMIN);
            admin.setUserTypeList(userMasterTypeDao.findByCode(ApplicationConstants.ADMIN));
            userMasterDao.persist(admin);
        }
    }
    
    
    private static void createCourseMasterDefaultValue() {
        
        courseMasterDao=new CourseMasterDao();
        CourseMasterEntity courseMasterEntity =courseMasterDao.findByCourseName(ApplicationConstants.JAVA);
        
        
        if (courseMasterEntity==null) {
            courseMasterEntity=new CourseMasterEntity();
            courseMasterEntity.setCourseName(ApplicationConstants.JAVA);
            courseMasterEntity.setCourseKey("C1");
            courseMasterEntity.setCategory("Software");
            courseMasterEntity.setNumberOfSessions(12);
            courseMasterDao.persist(courseMasterEntity);
            
            
            courseMasterEntity=new CourseMasterEntity();
            courseMasterEntity.setCourseName(ApplicationConstants.NETWORKING);
            courseMasterEntity.setCourseKey("C2");
            courseMasterEntity.setCategory("Hardware");
            courseMasterEntity.setNumberOfSessions(12);
            courseMasterDao.persist(courseMasterEntity);
        }
        
    }
    
    
    private static void createQuestionMasterDefaultValue() {
        
        QuestionMasterDao questionMasterDao=new QuestionMasterDao();
        List<QuestionMasterEntity> questionMasterList = questionMasterDao.findAll();
        
        
        if (questionMasterList==null || questionMasterList.isEmpty()) {
            QuestionMasterEntity question1=new QuestionMasterEntity();
            question1.setQuestionId("Q1");
            question1.setQuestion("What is the base class of all exceptions?");
            question1.setChoice1("java.lang.Object");
            question1.setChoice2("java.lang.Throwable");
            question1.setChoice3("java.lang.Exception");
            question1.setChoice4("None of the above");
            question1.setAnswerNumber(2);
            question1.setCourseId(courseMasterDao.findByCourseKey("C1"));
            questionMasterDao.persist(question1);
            
            
            QuestionMasterEntity question2=new QuestionMasterEntity();
            question2.setQuestionId("Q2");
            question2.setQuestion("What are the two types of Exceptions?");
            question2.setChoice1("Checked Exceptions");
            question2.setChoice2("Unchecked Exceptions");
            question2.setChoice3("Checked Exceptions and Unchecked Exceptions");
            question2.setChoice4("None of the above");
            question2.setAnswerNumber(3);
            question2.setCourseId(courseMasterDao.findByCourseKey("C1"));
            questionMasterDao.persist(question2);
            
            QuestionMasterEntity question3=new QuestionMasterEntity();
            question3.setQuestionId("Q3");
            question3.setQuestion("what are the implementation of list in java?");
            question3.setChoice1("ArrayList ");
            question3.setChoice2("Vector ");
            question3.setChoice3("LinkedList ");
            question3.setChoice4("All of the above");
            question3.setAnswerNumber(4);
            question3.setCourseId(courseMasterDao.findByCourseKey("C2"));
            questionMasterDao.persist(question3);
            
            
            QuestionMasterEntity question4=new QuestionMasterEntity();
            question4.setQuestionId("Q4");
            question4.setQuestion("Exceptions are defined in which java package?");
            question4.setChoice1("java.lang.Exception  ");
            question4.setChoice2("java.util");
            question4.setChoice3("sun.reflect");
            question4.setChoice4("None of the above");
            question4.setAnswerNumber(1);
            question4.setCourseId(courseMasterDao.findByCourseKey("C1"));
            questionMasterDao.persist(question4);
            
            QuestionMasterEntity question5=new QuestionMasterEntity();
            question5.setQuestionId("Q5");
            question5.setQuestion("public class Foo {"+
                    " public static void main(String[] args) {"+
                    " try { return; } "+
                    "finally {System.out.println( Finally); } } }");
            question5.setChoice1("Finally ");
            question5.setChoice2("Compilation fails.");
            question5.setChoice3("The code runs with no output.");
            question5.setChoice4(" 	An exception is thrown at runtime.");
            question5.setAnswerNumber(1);
            question5.setCourseId(courseMasterDao.findByCourseKey("C1"));
            questionMasterDao.persist(question5);
            
            
            QuestionMasterEntity question6=new QuestionMasterEntity();
            question6.setQuestionId("Q6");
            question6.setQuestion("public class Foo {"+
                    " public static void main(String[] args) {"+
                    " try { return; } "+
                    "finally {System.out.println( Finally); } } }");
            question6.setChoice1("Finally ");
            question6.setChoice2("Compilation fails.");
            question6.setChoice3("The code runs with no output.");
            question6.setChoice4(" 	An exception is thrown at runtime.");
            question6.setAnswerNumber(1);
            question6.setCourseId(courseMasterDao.findByCourseKey("C1"));
            questionMasterDao.persist(question6);
            
            QuestionMasterEntity question7=new QuestionMasterEntity();
            question7.setQuestionId("Q7");
            question7.setQuestion("public class Foo {"+
                    " public static void main(String[] args) {"+
                    " try { return; } "+
                    "finally {System.out.println( Finally); } } }");
            question7.setChoice1("Finally ");
            question7.setChoice2("Compilation fails.");
            question7.setChoice3("The code runs with no output.");
            question7.setChoice4(" 	An exception is thrown at runtime.");
            question7.setAnswerNumber(1);
            question7.setCourseId(courseMasterDao.findByCourseKey("C1"));
            questionMasterDao.persist(question7);
            
            QuestionMasterEntity question8=new QuestionMasterEntity();
            question8.setQuestionId("Q8");
            question8.setQuestion("class C{"+
                    "public static void main(String a[])      {"+
                    " int i1=9; int i2;"+
                    "if(i1>3) {  "+
                    "  i2=8;}"+
                    "System.out.println(i2);"+
                    "}}");
            
            question8.setChoice1("compile time error ");
            question8.setChoice2("Runtim error");
            question8.setChoice3("prints 8.");
            question8.setChoice4(" prints 0");
            question8.setAnswerNumber(1);
            question8.setCourseId(courseMasterDao.findByCourseKey("C1"));
            questionMasterDao.persist(question8);
            
            QuestionMasterEntity question9=new QuestionMasterEntity();
            question9.setQuestionId("Q9");
            question9.setQuestion("When a byte is added to a char, what is the type of the result?");
            question9.setChoice1("byte ");
            question9.setChoice2("int");
            question9.setChoice3("long");
            question9.setChoice4(" none of the above");
            question9.setAnswerNumber(2);
            question9.setCourseId(courseMasterDao.findByCourseKey("C1"));
            questionMasterDao.persist(question9);
            
            
            
            QuestionMasterEntity question10=new QuestionMasterEntity();
            question10.setQuestionId("Q10");
            question10.setQuestion("What is the signature of the run() method of the Runnable interface?");
            question10.setChoice1("void run() ");
            question10.setChoice2("public void run(Runnable target)");
            question10.setChoice3("public void run()");
            question10.setChoice4(" public static void run()");
            question10.setAnswerNumber(3);
            question10.setCourseId(courseMasterDao.findByCourseKey("C1"));
            questionMasterDao.persist(question10);
            
            QuestionMasterEntity question11=new QuestionMasterEntity();
            question11.setQuestionId("Q11");
            question11.setQuestion(" Any class that implements the Runnable interface has to provide the implementation for the following methods"+
                    "  public void start();"+
                    " public void run();");
            
            question11.setChoice1("true");
            question11.setChoice2("false");
            question11.setChoice3("not always");
            question11.setChoice4("None of the above");
            question11.setAnswerNumber(2);
            question11.setCourseId(courseMasterDao.findByCourseKey("C1"));
            questionMasterDao.persist(question11);
        }
        
    }
    
    private static void createDefaultSessionMasterValues()
    {
        sessionMasterDao = new SessionMasterDao();
        
        SessionMasterEntity sessionMasterEntity = sessionMasterDao.findBySessionTopic(ApplicationConstants.JAVA);
        
        if(sessionMasterEntity==null)
        {
            sessionMasterEntity = new SessionMasterEntity();
            sessionMasterEntity.setTopic(ApplicationConstants.JAVA);
            sessionMasterEntity.setTopicName("Introduction to Java");
            sessionMasterEntity.setTopicContent("JAVA is Object Oriented Language");
            sessionMasterEntity.setCourseId(courseMasterDao.findByCourseKey("C1"));
            sessionMasterDao.persist(sessionMasterEntity);
            
            
            sessionMasterEntity = new SessionMasterEntity();
            sessionMasterEntity.setTopic(ApplicationConstants.JAVA);
            sessionMasterEntity.setTopicName("Datatypes");
            sessionMasterEntity.setTopicContent("There are 8 datatypes in Java");
            sessionMasterEntity.setCourseId(courseMasterDao.findByCourseKey("C1"));
            sessionMasterDao.persist(sessionMasterEntity);
        }
        
    }
    
}
