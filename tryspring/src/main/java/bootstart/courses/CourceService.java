package bootstart.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CourceService implements CourceServiceGeneral {

    @Autowired
    private CourseRepository courceRepository;

    public List<CourseDTO> getAllCourses(){

        List <Course> courses = (List<Course>) courceRepository.findAll();
        List<CourseDTO> courseDTOs = new LinkedList<>();
        for(Course course : courses){
            courseDTOs.add(CourseConverter.EntityToDTO(course));
        }
        return courseDTOs;
    }
}
