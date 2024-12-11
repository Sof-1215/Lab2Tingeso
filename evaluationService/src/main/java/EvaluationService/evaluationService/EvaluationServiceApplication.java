package EvaluationService.evaluationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EvaluationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluationServiceApplication.class, args);
	}

}
