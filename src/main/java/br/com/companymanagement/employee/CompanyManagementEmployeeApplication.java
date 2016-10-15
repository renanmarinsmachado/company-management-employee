package br.com.companymanagement.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = { "br.com.companymanagement" })
@EnableAutoConfiguration
@EnableJpaRepositories
@EntityScan(basePackages =  { "br.com.companymanagement.common.entity" })
public class CompanyManagementEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyManagementEmployeeApplication.class, args);
	}
}
