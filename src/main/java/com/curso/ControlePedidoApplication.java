package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.curso")
@EntityScan(basePackages ={"com.curso.domains","com.curso.domains.enums"})
@EnableJpaRepositories(basePackages = "com.curso.repositories")
@SpringBootApplication
public class ControlePedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlePedidoApplication.class, args);
	}

}
