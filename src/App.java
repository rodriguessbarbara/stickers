import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
  public static void main(String[] args) throws IOException, InterruptedException {
    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    var http = new ClienteHttp();
    String json = http.buscaDados(url);

    var diretorio = new File("saida/");
    diretorio.mkdir();

    // ExtratorConteudoNasa extrator = new ExtratorConteudoNasa();
    ExtratorConteudoImdb extrator = new ExtratorConteudoImdb();
    List<Conteudo> conteudos = extrator.extrairConteudos(json);

    // exibir os dados
    for (Conteudo conteudo : conteudos) {
      InputStream inputStream = new URL(conteudo.getUrlImg()).openStream();

      String textoFigurinha = "TOP DEMAIS";
      var criar = new CreateStickers();

      if (conteudo.getRating() >= 9.0) {
        textoFigurinha = "PERFEITO!!!";
      } else {
        textoFigurinha = "É BOM TA";
      }

      criar.create(inputStream, "saida/" + conteudo.getTitulo() + ".png", textoFigurinha);

      System.out.println("\u001b[34mTítulo:\u001b[m " + conteudo.getTitulo());
      System.out.println("\u001b[32mImage:\u001b[m " + conteudo.getUrlImg());
      System.out.println("\u001b[35mRating:\u001b[m " + conteudo.getRating());

      for (int i = 1; i <= (int) conteudo.getRating(); i++) {
        System.out.print("⭐");
      }
      System.out.println("\n");
    }
  }
}