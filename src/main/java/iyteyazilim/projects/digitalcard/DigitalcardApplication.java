package iyteyazilim.projects.digitalcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DigitalcardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalcardApplication.class, args);
	}

}
