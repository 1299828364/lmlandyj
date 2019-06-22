package lml.lml.Control;


import lml.lml.domain.Course;
import lml.lml.domain.Result;
import lml.lml.service.CourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * @author xxx
 */
//这是@ResponseBody和@Control的结合注解
@RestController
public class CourseControl {


//    @Autowired这个注解会自动给注册过的类注入对象
    @Autowired
CourseService courseService;


    /**
     *
     * @return
     */
    @GetMapping(value = "/api/v1/courses/{page}")
    public Result getAll(){
        return courseService.findAll();
    }

    @GetMapping(value = "/api/v1/course")
    public Result getCourseByDate(@Param("start")Date start,@Param("end")Date end){
        return courseService.findByDate(start,end);
    }

    @PostMapping(value = "/api/v1/courses")
    public Result addRole(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @DeleteMapping(value = "/api/v1/courses")
    public Result deletebyNo(@Param("courseNo")String courseNo){
        return courseService.deleteCourse(courseNo);
    }

    @PutMapping(value = "/api/v1/courses")
    public Result updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }
}
