package lml.lml.Control;


import lml.lml.domain.Module;
import lml.lml.domain.Result;
import lml.lml.service.ModuleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ModuleControl {
    @Autowired
    ModuleService moduleService;

    @GetMapping(value = "/api/v1/modules")
    public Result getAll(){
        return moduleService.findAll();
    }

    @GetMapping(value = "/api/v1/modules/{no}")
    public Result getOne(@PathVariable("no")String moduleNo){
        return moduleService.findOneByNo(moduleNo);
    }

    @PostMapping(value = "/api/v1/modules")
    public Result addmodule(@RequestBody Module module){
        return moduleService.addModule(module);
    }

    @DeleteMapping(value = "/api/v1/modules")
    public Result deleteByNo(@Param("moduleNo")String moduleNo){
        return moduleService.deleteModule(moduleNo);
    }

    @PutMapping(value = "/api/v1/modules")
    public Result updatemodule(@RequestBody Module module){
        return moduleService.updateModule(module);
    }

}
