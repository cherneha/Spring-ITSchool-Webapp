package bootstart.courses;

//import bootstart.teachers.Teacher;

import java.util.List;

public class CourseDTO {
    int id;
    String courseName;
    String description;
    String pageName;

    public CourseDTO(int id, String courseName, String description, String pageName){
        this.courseName = courseName;
        this.description = description;
        this.pageName = pageName;
        this.id = id;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageName() {
        return pageName;
    }

    public String getDescription() {
        return description;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getId() {
        return id;
    }
}
