package lml.lml.Control;


import lml.lml.domain.Result;
import lml.lml.domain.User;
import lml.lml.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserControl {

    @Autowired
    UserService userService;

    @GetMapping(value = "/api/v1/users")
    public Result getAll(){
        return userService.findAll();
    }

    @PostMapping(value = "/api/v1/users")
    public Result addRole(@RequestBody User user){
        return userService.addRole(user);
    }

    @DeleteMapping(value = "/api/v1/users")
    public Result deleteByNo(@Param("roleNo")String userNo){
        return userService.deleteByUserNo(userNo);
    }

    @PutMapping(value = "/api/v1/users")
    public Result updateRole(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PutMapping(value = "/api/v1/user/{no}")
    public Result findOne(@PathVariable("no")String userNo){
        return userService.findOneByNo(userNo);
    }

    @GetMapping(value = "/api/v1/users/{page}")
    public Result getUserByPage(@PathVariable("page")String page){
        return userService.findByPage(page);
    }
}
