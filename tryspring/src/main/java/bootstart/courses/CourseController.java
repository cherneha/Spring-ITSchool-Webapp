package bootstart.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin
@RequestMapping("/courses")
@Controller
public class CourseController {
    @Autowired
    CourceServiceGeneral courceService;

    @RequestMapping(value = "", method = GET)
    @ResponseBody
    public List<CourseDTO> getCources(){

        List<CourseDTO> list = courceService.getAllCourses();
        for(CourseDTO courseDTO: list){
            System.out.println(courseDTO.getCourseName());
            System.out.println(courseDTO.getDescription());
            System.out.println(courseDTO.getId());
            System.out.println(courseDTO.getPageName());
        }
        return list;
    }
}
