package com.selind.issuemanagementsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IssueManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(IssueManagementSystemApplication.class, args);
	}


	@Bean //her yerde kullanılabilir hale getirmek için bean ekledik
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}


}
