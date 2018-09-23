package igor.film;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories
@SpringBootApplication
public class SearchApplication {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(SearchApplication.class, args);
  }

}
