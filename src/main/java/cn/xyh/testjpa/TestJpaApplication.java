package cn.xyh.testjpa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching // 开启缓存
@EnableScheduling //开启定时任务
@MapperScan("cn.xyh.testjpa.mapper")
@SpringBootApplication
public class TestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestJpaApplication.class, args);
	}
}
