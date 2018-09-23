package igor.film.controller;

import igor.film.model.Film;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.SimpleQueryStringBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
@RequiredArgsConstructor
public class SearchController {

  private final ElasticsearchTemplate elasticsearchTemplate;

  @PostMapping("film")
  public List<Film> smartSearch(@RequestParam(value = "search") String search) {
    return elasticsearchTemplate.queryForList(
        new NativeSearchQueryBuilder()
            .withIndices("film")
            .withQuery(new BoolQueryBuilder()
                .must(new SimpleQueryStringBuilder(search)))
            .build(), Film.class);
  }

}
