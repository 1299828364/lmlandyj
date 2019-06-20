package lml.lml.Controller;


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


    @GetMapping("/index")
    public String index(HttpServletRequest req,HttpServletResponse res){
        req.setAttribute("name","刘明朗");
        return "hello";
    }
}
