package com.havey.model;

import lombok.Data;

/**
*@描述 这是返回结果Bean
*@参数 
*@返回 
*@作者 yehw
*@日期 2020/3/17
*@时间 17:18
*/
@Data
public class ResponseBean {

    private Integer status;//状态 （200 成功，500 错误）
    private String msg;//返回的消息
    private Object obj;//返回的对象


    /*
    * 下面是使Bean是单例的
    * */
    //构造器私有话
    private ResponseBean(){}
    private ResponseBean(Integer status,String msg,Object obj){
        this.msg=msg;
        this.obj=obj;
        this.status=status;
    }
    public static ResponseBean build(){
        return new ResponseBean();
    }
    /*
    * 返回成功消息，不含对象
    * */
    public static ResponseBean ok(String msg){
        return new ResponseBean(200,msg,null);
    }
    /*
     * 返回成功消息，包含对象
     * */
    public static ResponseBean ok(String msg,Object obj){
        return new ResponseBean(200,msg,obj);
    }

    /*
     * 返回错误消息，不含对象
     * */
    public static ResponseBean error(String msg){
        return new ResponseBean(500,msg,null);
    }
    /*
     * 返回错误消息，包含对象
     * */
    public static ResponseBean error(String msg,Object obj){
        return new ResponseBean(500,msg,obj);
    }
    
}
