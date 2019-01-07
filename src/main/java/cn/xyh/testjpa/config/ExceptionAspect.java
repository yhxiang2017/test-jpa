package cn.xyh.testjpa.config;

import cn.xyh.testjpa.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;


/**
 * Create by xyh on 2018/11/26
 */
@ControllerAdvice // 控制器增强
@ResponseBody
public class ExceptionAspect {

    Logger log = LoggerFactory.getLogger(ExceptionAspect.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseResult handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        log.error("could_not_read_json...", e);
        return ResponseResult.failed("could_not_read_json");
    }

//    /**
//     * 400 - Bad Request
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    public ResponseResult handleValidationException(MethodArgumentNotValidException e) {
//        log.error("parameter_validation_exception...", e);
//        return ResponseResult.failed("parameter_validation_exception");
//    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResponseResult handleValidationException(ValidationException e) {
        log.error("参数验证失败", e);
        return  ResponseResult.failed("validation_exception");
    }

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", ex.getMessage());

        log.info("--------------开始打印异常信息--------------");
        ex.printStackTrace();
        log.info("--------------结束打印异常信息--------------");
        return map;
    }
}
