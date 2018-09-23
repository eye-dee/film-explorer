package igor.film.coonfig;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

  @Value("${spring.elasticsearch.host}")
  private String host;

  @Value("${spring.elasticsearch.port}")
  private int port;

  @Bean
  public Client client() throws UnknownHostException {
    System.setProperty("es.set.netty.runtime.available.processors", "false");
    Settings elasticsearchSettings = Settings.builder()
        .put("client.transport.sniff", false)
        //.put("path.home", "/Users/igordrozdov/IdeaProjects/film-explorer/es_data")
        .put("cluster.name", "elasticsearch")
        //.put("network.host","127.0.0.1")
        .build();
    TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
    client.addTransportAddress(new TransportAddress(new InetSocketAddress(host, port)));
    return client;
  }

}
