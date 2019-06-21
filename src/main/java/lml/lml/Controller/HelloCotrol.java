package lml.lml.Controller;


import lml.lml.domain.Course;
import lml.lml.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloCotrol {

    @Autowired
    CourseService wenzhangService;

    @ResponseBody
    @GetMapping(value = "/hello")
    public Map Hello(){
        List list=new ArrayList();
        list.add("刘明朗");
        list.add("瞿川江");
        list.add("曾帅");
        Map<String,List> map=new HashMap<>();
        map.put("list",list);
        return map;
    }

    @ResponseBody
    @GetMapping(value = "/API/getmokuai")
    public Map getmokuai(){
        List names=new ArrayList();
        List op=new ArrayList();
        Map temp=new HashMap();
        names.add("刘明朗");
        names.add("瞿川江");
        names.add("曾帅");
        temp.put("name",names);
        op.add("增加");
        op.add("删除");
        op.add("修改");
        temp.put("op",op);
        return temp;
    }



    @GetMapping("/index")
    public String index(HttpServletRequest req,HttpServletResponse res){
        req.setAttribute("name","刘明朗");
        return "hello";
    }

    @ResponseBody
    @GetMapping("/test")
    public List<Course> getAll(){
        return wenzhangService.findAll();
    }
}
