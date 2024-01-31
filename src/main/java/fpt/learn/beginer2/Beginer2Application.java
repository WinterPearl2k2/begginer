package fpt.learn.beginer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Beginer2Application {

	public static void main(String[] args) {
		SpringApplication.run(Beginer2Application.class, args);
	}
}
