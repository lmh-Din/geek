package com.geek.spring.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@RestController
@Slf4j
public class SpringJdbcApplication implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		showConnection();
		showData();
	}

	private void showConnection() throws SQLException {
		log.info("DataSource Info:{}", dataSource);
		Connection conn = dataSource.getConnection();
		log.info("Connection Info:{}", conn);
		conn.close();
	}

	private void showData() throws Exception{
		jdbcTemplate.queryForList("SELECT * FROM user")
				.forEach(row -> log.info(row.toString()));
	}

	@RequestMapping("/hello")
	public String hello(){
		return "Hello Spring";
	}

}

