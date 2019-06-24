package lml.lml.Control;


import lml.lml.domain.Result;
import lml.lml.domain.Column;
import lml.lml.service.ColumnService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ColumnControl {
    @Autowired
    ColumnService columnService;

    @GetMapping(value = "/api/v1/columns")
    public Result getAll(){
        return columnService.findAll();
    }

    @GetMapping(value = "/api/v1/columns/{no}")
    public Result getOne(@PathVariable("no")String columnNo){
        return columnService.findOneByNo(columnNo);
    }

    @PostMapping(value = "/api/v1/columns")
    public Result addcolumn(@RequestBody Column column){
        return columnService.addColumn(column);
    }

    @DeleteMapping(value = "/api/v1/columns")
    public Result deleteByNo(@Param("columnNo")String columnNo){
        return columnService.deleteColumn(columnNo);
    }

    @PutMapping(value = "/api/v1/columns")
    public Result updatecolumn(@RequestBody Column column){
        return columnService.updateColumn(column);
    }
}
