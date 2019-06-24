package lml.lml.Control;


import lml.lml.domain.Power;
import lml.lml.domain.Result;
import lml.lml.service.PowerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PowerControl {
    @Autowired
    PowerService powerService;

    @GetMapping(value = "/api/v1/powers")
    public Result getAll(){
        return powerService.findAll();
    }

    @GetMapping(value = "/api/v1/power/{no}")
    public Result getOne(@PathVariable("no")String powerNo){
        return powerService.findOneByNo(powerNo);
    }

    @PostMapping(value = "/api/v1/powers")
    public Result addpower(@RequestBody Power power){
        return powerService.addPower(power);
    }

    @DeleteMapping(value = "/api/v1/powers")
    public Result deleteByNo(@Param("powerNo")String powerNo){
        return powerService.deletePower(powerNo);
    }

    @PutMapping(value = "/api/v1/powers")
    public Result updatepower(@RequestBody Power power){
        return powerService.updatePower(power);
    }
}
