package lml.lml.Control;


import lml.lml.domain.Result;
import lml.lml.domain.User;
import lml.lml.repository.UserRepository;
import lml.lml.service.CourseService;
import lml.lml.service.UserService;
import lml.lml.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@Controller
public class ViewControl {

    @Autowired
    CourseService wenzhangService;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

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
        return (List) wenzhangService.findCourseWithColumn().getData();
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

    @PostMapping("/loginCheck")
    public void  checkUser(HttpServletRequest req,HttpServletResponse res) throws IOException {
       User user=new User();
       String account=req.getParameter("account");
       String password=req.getParameter("password");
       user.setUserAccount(account);
       user.setPassword(password);
       boolean flag=userService.loginCheck(user);
       if (flag){
           User temp=userRepository.findOneByAccount(account);
           req.getSession().setAttribute("account",user.getUserAccount());
           req.getSession().setAttribute("password",user.getPassword());
           req.getSession().setAttribute("userName",temp.getUserName());
           res.sendRedirect("index");

//           return "index";
//       }else {
//           return "login";
       }
    }

    @GetMapping("/course")
    public String course(HttpServletRequest req,HttpServletResponse res){
        req.setAttribute("name","刘明朗");
        return "course";
    }

    @GetMapping("/power")
    public String power(HttpServletRequest req,HttpServletResponse res){
        req.setAttribute("name","刘明朗");
        return "power";
    }

    @GetMapping("/coursePass")
    public String coursePass(HttpServletRequest req,HttpServletResponse res){
        req.setAttribute("name","刘明朗");
        return "coursePass";
    }

    @GetMapping("/user")
    public String user(HttpServletRequest req,HttpServletResponse res){
        req.setAttribute("name","刘明朗");
        return "user";
    }

    @GetMapping("/role")
    public String role(HttpServletRequest req,HttpServletResponse res){
        return "role";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
