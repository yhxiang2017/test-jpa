package cn.xyh.testjpa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.xyh.testjpa.mapper")
@SpringBootApplication
public class TestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestJpaApplication.class, args);
	}
}
