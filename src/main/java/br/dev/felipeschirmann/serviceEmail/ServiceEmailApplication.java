package br.dev.felipeschirmann.serviceEmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class ServiceEmailApplication {
	
	public static void main(String[] args){
		SpringApplication.run(ServiceEmailApplication.class, args);	
	}
}
