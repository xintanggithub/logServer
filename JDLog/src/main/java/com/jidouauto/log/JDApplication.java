package com.jidouauto.log;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jidouauto.log.dao")
public class JDApplication {

	public static void main(String[] args) {
		SpringApplication.run(JDApplication.class, args);
	}
}
