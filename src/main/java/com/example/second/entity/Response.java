package com.example.second.entity;

//import com.sun.org.apache.xpath.internal.operations.Bool;

public class Response {
    private Boolean flag;

    private String message;

    private Object data;

    public Response(Boolean flag, String message) {
        super();
        this.flag=flag;
        this.message=message;
    }

    public Response(Boolean flag, String msg, Object data) {

        this.flag=flag;
        this.message=msg;
        this.data=data;
    }
    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

}
