package igor.film.messaging;

import igor.film.model.Film;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaSender {

  private static final String FILM_TOPIC = "film";

  private final KafkaTemplate<String, Film> kafkaTemplate;

  public void send(Film film) {
    log.info("sending car='{}'", film);
    kafkaTemplate.send(FILM_TOPIC, film);
  }

}
