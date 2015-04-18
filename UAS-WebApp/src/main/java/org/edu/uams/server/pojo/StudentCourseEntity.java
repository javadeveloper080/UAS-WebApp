package org.edu.uams.server.pojo;

import java.io.Serializable;
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


@Entity(name = "StudentCourse")
@Table(name = "student_course")
public class StudentCourseEntity implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    
    public static final  String  FIND_ALL="SELECT s FROM StudentCourse s";
    public static final  String FIND_BY_STUDENT_ID="SELECT r FROM StudentCourse r JOIN r.student s  where s.id = :studentId";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @ManyToOne(optional=false,targetEntity=ProgramLevelTypeEntity.class)
    @JoinColumn(name = "program_level_type_id", referencedColumnName="id", nullable = false)
    private ProgramLevelTypeEntity programLevelType;
    
    @ManyToOne(optional=false,targetEntity=CourseTypeEntity.class)
    @JoinColumn(name = "course_id", referencedColumnName="id", nullable = false)
    private CourseTypeEntity courseType;
    
    @Basic(optional = false)
    @ManyToOne(optional = false, targetEntity = StudentEntity.class)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false )
    private StudentEntity student;
    
    @Basic(optional = true)
    @Column(name = "starts_on")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startsOn ;
    
    @Basic(optional = true)
    @Column(name = "ends_on")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endsOn ;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    
    
    public CourseTypeEntity getCourseType() {
        return courseType;
    }
    
    public void setCourseType(CourseTypeEntity courseType) {
        this.courseType = courseType;
    }
    
    public StudentEntity getStudent() {
        return student;
    }
    
    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public Date getStartsOn() {
        return startsOn;
    }

    public void setStartsOn(Date startsOn) {
        this.startsOn = startsOn;
    }

    public Date getEndsOn() {
        return endsOn;
    }

    public void setEndsOn(Date endsOn) {
        this.endsOn = endsOn;
    }

    public ProgramLevelTypeEntity getProgramLevelType() {
        return programLevelType;
    }

    public void setProgramLevelType(ProgramLevelTypeEntity programLevelType) {
        this.programLevelType = programLevelType;
    }
    
    
    
    
    
    
    
}
