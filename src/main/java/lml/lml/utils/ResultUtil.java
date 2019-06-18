package lml.lml.utils;


import lml.lml.config.ResultEnum;
import lml.lml.domain.Result;

public class ResultUtil {
    public static Result success(Object object){
        System.out.println(object);
        Result result=new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result success(Object object,String msg){
        Result result=new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static Result error(Integer code,String msg,Object object){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static Result error(ResultEnum resultEnum, Object object){
        return error(resultEnum.getCode(),resultEnum.getMsg(),object);
    }
}
