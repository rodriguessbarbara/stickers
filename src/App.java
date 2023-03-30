import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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

    var parser = new JsonParser();
    List<Map<String, String>> listaFilmes = parser.parse(body);

    var diretorio = new File("saida/");
    diretorio.mkdir();

     //exibir os dados 
    for (Map<String, String> filme : listaFilmes) {
      String titulo = filme.get("title");
      String urlImg = filme.get("image");
      InputStream inputStream = new URL(urlImg).openStream();

      var criar = new CreateStickers();
      double rating = Double.parseDouble(filme.get("imDbRating")) ; 
      String textoFigurinha;

      if (rating >= 9.0) {
        textoFigurinha = "PERFEITO!!!";
      } else {
        textoFigurinha = "É BOM TA";
      }

      criar.create(inputStream, "saida/" + titulo + ".png", textoFigurinha);



       System.out.println("\u001b[34mTítulo:\u001b[m " + titulo);
       System.out.println("\u001b[32mImage:\u001b[m " + urlImg);
       System.out.println("\u001b[35mRating:\u001b[m " + filme.get("imDbRating"));
       
      for (int i = 1; i <= (int)rating; i++) {
        System.out.print("⭐");
      }
      System.out.println("\n");
     }
  }
}