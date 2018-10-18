package cn.xyh.testjpa.util;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {

    private String message;

    private T data;

    public ResponseResult () {
        super();
    }

    public ResponseResult (String message, T data) {
        this.message = message;
        this.data = data;
    }

    public static ResponseResult success(Object data){
        ResponseResult result = new ResponseResult("OK", data);
        return result;
    }

    public static ResponseResult success(){
        ResponseResult responseResult = new ResponseResult("SUCCESS", null);
        return responseResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseResult failed() {
        ResponseResult result = new ResponseResult("ERROR", null);

        return result;
    }

    public static ResponseResult failed(String message){
        ResponseResult result = new ResponseResult(message, null);
        return result;
    }
}
