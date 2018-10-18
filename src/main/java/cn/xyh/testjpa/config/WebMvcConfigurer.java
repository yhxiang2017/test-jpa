//package cn.xyh.testjpa.config;
//
//import java.nio.charset.Charset;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
//
///**
// * webmvc配置
// */
//@Configuration
//public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
//	@Autowired
//	private RequestMappingHandlerAdapter handlerAdapter;
//
//	/**
//	 * 使用阿里 FastJson 作为JSON MessageConverter
//	 */
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
//		FastJsonConfig config = new FastJsonConfig();
//		config.setDateFormat("yyyy-MM-dd HH:mm:ss");
//		config.setSerializerFeatures(SerializerFeature.WriteMapNullValue, // 保留空的字段
//				SerializerFeature.WriteNullStringAsEmpty, // String null -> ""
//				SerializerFeature.WriteNullNumberAsZero);// Number null -> 0
//		converter.setFastJsonConfig(config);
//		converter.setDefaultCharset(Charset.forName("UTF-8"));
//		converters.add(converter);
//	}
//}
