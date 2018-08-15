package bootstart.courses;

public class CourseConverter {
    public static CourseDTO EntityToDTO(Course course){
        return new CourseDTO(course.getCourseId(), course.getCoursename(),
                course.getDescription(), course.getPagename());
    }

    public static Course DTOToEntity(CourseDTO courseDTO){
        return new Course(courseDTO.getId(), courseDTO.getCourseName(),
                courseDTO.getDescription(), courseDTO.getPageName());
    }
}
