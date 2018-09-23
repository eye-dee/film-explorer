package igor.film.service;

import igor.film.messaging.KafkaSender;
import igor.film.model.Film;
import igor.film.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmService {

  private final FilmRepository filmRepository;
  private final KafkaSender filmSender;

  public Film save(Film film) {
    Film saved = filmRepository.save(film);
    filmSender.send(saved);
    return saved;
  }
}
