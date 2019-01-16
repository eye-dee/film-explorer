package igor.film.controller;

import igor.film.model.Film;
import igor.film.repository.FilmRepository;
import igor.film.service.FilmService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/film")
@RequiredArgsConstructor
public class FilmController {

  private final FilmRepository filmRepository;
  private final FilmService filmService;

  @GetMapping("{id}")
  public ResponseEntity<Film> getById(@PathVariable("id") long id) {
    return filmRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Film> create(@Valid @RequestBody Film film) {
    return ResponseEntity.ok(filmService.save(film));
  }

}
