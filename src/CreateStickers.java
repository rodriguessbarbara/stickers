import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CreateStickers {
  
  public void create() throws IOException {
    BufferedImage imgOriginal = ImageIO.read(new File("entrada/filme.jpg"));

    int largura = imgOriginal.getWidth();
    int novaAltura = imgOriginal.getHeight() + 200;
    BufferedImage novaImg = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    //copiar imagem original p/ nova img (em memória)
    Graphics2D graficos = (Graphics2D) novaImg.getGraphics();
    graficos.drawImage(imgOriginal, 0, 0, null);

    //escreve frase em nova img
    var fonte = new Font("Sans_serif", Font.BOLD, 72);
    graficos.setFont(fonte);
    graficos.setColor(Color.RED);
    graficos.drawString("FODA TA", largura/2, novaAltura - 100);

    //escreve nova img no arquivo
    ImageIO.write(novaImg, "png", new File("saida/sticker.png"));
  }

  public static void main(String[] args) throws IOException {
    var criar = new CreateStickers();
    criar.create();
  }

}