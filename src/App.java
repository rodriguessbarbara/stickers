import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
  public static void main(String[] args) throws IOException, InterruptedException {

    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    URI endereco = URI.create(url);
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(endereco).GET().build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    String body = response.body();

    //System.out.println(body);

    var parser = new JsonParser();
    List<Map<String, String>> listaFilmes = parser.parse(body);

    System.out.println(listaFilmes.size());

     //exibir os dados 
     for (Map<String, String> filme : listaFilmes) {
      System.out.println(filme.get("title"));
      System.out.println(filme.get("image"));
      System.out.println(filme.get("imDbRating"));
      System.out.println("");

     }

  }
}