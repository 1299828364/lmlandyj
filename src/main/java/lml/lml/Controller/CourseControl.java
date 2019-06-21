package lml.lml.Controller;


import lml.lml.domain.Course;
import lml.lml.domain.Result;
import lml.lml.utils.ResultUtil;
import lml.lml.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
    @GetMapping("/api")
    public Result getAll(){
        return ResultUtil.success(courseService.findAll());
    }
}
