import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CreateStickers {
  
  public void create() throws IOException {
    //pegar e ler a imagem
    BufferedImage imgOriginal = ImageIO.read(new File("entrada/filme.jpg"));

    //criar nova imagem em memoria (npj e redimencionada)
    int largura = imgOriginal.getWidth();
    int novaAltura = imgOriginal.getHeight() + 150;

    BufferedImage novaImg = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    //copiar imagem original p/ nova img (em memória)
    Graphics2D graficos = (Graphics2D) novaImg.getGraphics();
    graficos.drawImage(imgOriginal, 0, 0, null);

    //escrever frase em nova img

    //escrever nova img no arquivo
    ImageIO.write(novaImg, "png", new File("saida/sticker.png"));

  }

  public static void main(String[] args) throws IOException {
    var criar = new CreateStickers();
    criar.create();
  }

}