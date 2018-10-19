package cn.xyh.testjpa.util;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {

    private String message;

    private boolean isSuccess;

    private T data;

    public ResponseResult () {
        super();
    }

    public ResponseResult (String message, boolean isSuccess, T data) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.data = data;
    }

    public static ResponseResult success(Object data){
        ResponseResult result = new ResponseResult("SUCCESS", true, data);
        return result;
    }

    public static ResponseResult success(){
        ResponseResult result = new ResponseResult("SUCCESS", true, null);
        return result;
    }

    public static ResponseResult failed() {
        ResponseResult result = new ResponseResult("ERROR", false, null);

        return result;
    }

    public static ResponseResult failed(String message){
        ResponseResult result = new ResponseResult(message, false, null);
        return result;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
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

}
