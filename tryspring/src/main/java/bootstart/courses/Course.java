package bootstart.courses;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer courseid;

    @Column
    private String coursename;

    @Column
    private String description;

    @Column
    private String pagename;

    public Course(){}

    public Course(int courseid, String courseName, String description, String pageName){
        this.description = description;
        this.coursename = courseName;
        this.pagename = pageName;
        this.courseid = courseid;
    }

    public void setCourseId(Integer courseId) {
        this.courseid = courseId;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
    }

    public Integer getCourseId() {
        return courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getDescription() {
        return description;
    }

    public String getPagename() {
        return pagename;
    }
}
