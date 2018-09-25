package igor.film;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SaveApplication {

  public static void main(String[] args) {
    SpringApplication.run(SaveApplication.class, args);
  }
}
