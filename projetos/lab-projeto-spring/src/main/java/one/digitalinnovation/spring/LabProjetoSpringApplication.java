package one.digitalinnovation.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // EnableFeignClients annotation is used to enable the Feign clients in the application.
@SpringBootApplication
public class LabProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabProjetoSpringApplication.class, args);
	}

}
