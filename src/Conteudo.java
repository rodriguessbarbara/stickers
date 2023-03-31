public class Conteudo {
  private String titulo;
  private String urlImg;
  private double rating;

  public String getTitulo() {
    return titulo;
  }

  public String getUrlImg() {
    return urlImg;
  }

  public double getRating() {
    return rating;
  }

  public void setConteudo(String titulo, String urlImg, double rating) {
    this.titulo = titulo;
    this.urlImg = urlImg;
    this.rating = rating;
  }
}