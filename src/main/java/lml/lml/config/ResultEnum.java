package lml.lml.config;

public enum ResultEnum {
    /**
     * 成功
     */
    succese(200,"成功"),
    CREATE(201,"新建或修改数据成功"),
    Accepted(202,"请求已排入后台排队"),

/**
 * test pull
 * */

    /**
     * 服务器报错
     */
    ERROR_SERVER_SUSPENSION(503,"服务器暂停服务！"),

    /**
     *
     */
    ERROR_SYSTEM_REJECT(403,"系统拒绝！"),
    ERROR_ACCESS_TIMEOUT(408,"访问超时！")
    ;

    private Integer code;


    private String msg;

    ResultEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode(){return code;}

    public String getMsg(){return msg;}
}
