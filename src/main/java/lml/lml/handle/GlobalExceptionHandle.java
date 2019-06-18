package lml.lml.handle;


import lml.lml.domain.Result;
import lml.lml.domain.Result;
import lml.lml.exception.UserException;
import lml.lml.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


public class GlobalExceptionHandle {
    private final static Logger logger= LoggerFactory.getLogger(GlobalExceptionHandle.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof UserException){
            UserException userException=(UserException) e;
            return ResultUtil.error(userException.getCode(),userException.getMessage(),false);
        }else {
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1,"未知错误",false);
        }
    }
}
