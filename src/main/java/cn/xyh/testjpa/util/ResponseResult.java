package cn.xyh.testjpa.util;

public class ResponseResult {

    private String message;

    private Object data;

    public ResponseResult () {
    }

    public ResponseResult (String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public static ResponseResult success(Object data){
        ResponseResult result = new ResponseResult("OK", data);
        return result;
    }

}
