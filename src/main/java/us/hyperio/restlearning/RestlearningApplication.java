package us.hyperio.restlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"us.hyperio.restlearning"})
public class RestlearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestlearningApplication.class, args);
	}

}
