package lml.lml.Control;


import lml.lml.domain.Result;
import lml.lml.service.CourseService;
import lml.lml.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

@Controller
public class ViewCotrol {

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
    @GetMapping(value = "/api/v1/test1")
    public List tets(){
        return (List) wenzhangService.findAll().getData();
    }

    @ResponseBody
    @GetMapping(value = "/api/v1/test")
    public List getmokuai(){

        Map map=new HashMap();
        map.put("ID",1);
        map.put("Name","jjijiasd");
        map.put("Sex","www.baidu.com");
        List temp=new ArrayList();
        temp.add(map);
        return temp;
    }



    @GetMapping("/index")
    public String index(HttpServletRequest req,HttpServletResponse res){
        req.setAttribute("name","刘明朗");
        return "index";
    }

    @GetMapping("/course")
    public String course(HttpServletRequest req,HttpServletResponse res){
        req.setAttribute("name","刘明朗");
        return "course";
    }

//    @ResponseBody
//    @GetMapping("/test")
//    public List<Course> getAll(){
//        return wenzhangService.findAll();
//    }
}
