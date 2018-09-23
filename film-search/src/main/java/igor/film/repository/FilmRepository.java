package igor.film.repository;

import igor.film.model.Film;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FilmRepository extends PagingAndSortingRepository<Film, String>,
    ElasticsearchRepository<Film, String> {

}
