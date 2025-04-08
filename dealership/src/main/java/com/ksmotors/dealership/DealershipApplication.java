package com.ksmotors.dealership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@EnableAutoConfiguration
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class DealershipApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealershipApplication.class, args);
	}
}
//dont forget to start sql server b4!
/* 
 C-Get
 R-Post
 U-update
 D-delete
 read this , just a note
 */