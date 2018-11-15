package cn.xyh.testjpa.util;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;

@Component
public class SpringHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView mv = new ModelAndView();

        /* 使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常 */

        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("code", "111");
        attributes.put("msg", "服务器异常，请稍后再试");
        view.setAttributesMap(attributes);
        mv.setView(view);
        ex.printStackTrace();
        return mv;

    }

}
