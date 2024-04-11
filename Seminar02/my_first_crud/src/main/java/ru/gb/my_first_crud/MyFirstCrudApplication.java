package ru.gb.my_first_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.gb.my_first_crud.repository.H2Requests;

@SpringBootApplication
@EnableConfigurationProperties(H2Requests.class)
public class MyFirstCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstCrudApplication.class, args);
	}

}
