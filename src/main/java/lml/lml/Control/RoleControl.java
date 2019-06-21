package lml.lml.Control;

import lml.lml.domain.Role;
import lml.lml.domain.Result;
import lml.lml.service.impl.RoleServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleControl {
    
    @Autowired
    RoleServiceImpl roleService;

    @GetMapping(value = "/api/v1/roles")
    public Result getAll(){
        return roleService.findAll();
    }

    @PostMapping(value = "/api/v1/roles")
    public Result addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @DeleteMapping(value = "/api/v1/roles")
    public Result deleteByNo(@Param("roleNo")String roleNo){
        return roleService.deleteRole(roleNo);
    }

    @PutMapping(value = "/api/v1/roles")
    public Result updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }
}
