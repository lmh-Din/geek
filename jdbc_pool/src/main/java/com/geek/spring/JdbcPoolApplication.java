package com.geek.spring;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@Slf4j
@SpringBootApplication
public class JdbcPoolApplication implements CommandLineRunner {

	@Autowired
	private DruidDataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(JdbcPoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Systerm Started......");
		log.info("DataSource info:{}", dataSource);
	}
}

