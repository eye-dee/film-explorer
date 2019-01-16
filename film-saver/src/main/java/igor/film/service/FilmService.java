package igor.film.service;

import igor.film.messaging.KafkaSender;
import igor.film.model.Film;
import igor.film.repository.FilmRepository;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

  private final FilmRepository filmRepository;
  private final KafkaSender filmSender;
  private final Timer oneRequestTime;

  public FilmService(FilmRepository filmRepository, KafkaSender filmSender,
      MeterRegistry registry) {
    this.filmRepository = filmRepository;
    this.filmSender = filmSender;
    this.oneRequestTime = registry.timer("only_to_kafka_and_db_time");
  }

  public Film save(Film film) {
    return oneRequestTime.record(() -> {
      Film saved = filmRepository.save(film);
      filmSender.send(saved);
      return saved;
    });
  }
}
