package igor.film.messaging;

import igor.film.model.Film;
import igor.film.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageHandler {

  private final FilmRepository filmRepository;

  @KafkaListener(topics = "film")
  public void handleFilms(Film film) {
    log.info("message received = {}", film);
    filmRepository.save(film);
  }
}
