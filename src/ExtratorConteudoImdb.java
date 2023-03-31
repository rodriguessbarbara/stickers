import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoImdb {
  public List<Conteudo> extrairConteudos(String json) {
  var parser = new JsonParser();
  List<Map<String, String>> listaAtributosJson = parser.parse(json);

  List<Conteudo> conteudos = new ArrayList<>();

  for (Map<String, String> atributos : listaAtributosJson) {
    String titulo = atributos.get("title").replace(":", "-");
    String urlImg = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
    double rating = Double.parseDouble(atributos.get("imDbRating")) ; 

    var conteudo = new Conteudo();
    conteudo.setConteudo(titulo, urlImg, rating);

    conteudos.add(conteudo);
  }

  return conteudos;
}
}