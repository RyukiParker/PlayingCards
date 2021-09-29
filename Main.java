import java.awt.*;
import java.util.Arrays;

class Main {

  public static void main(String[] args) {

    // Initialize DrawingPanel and Graphics
    DrawingPanel panel = new DrawingPanel(500, 410);
    Graphics g = panel.getGraphics();
    panel.setBackground(Color.GRAY);

    // Create deck
    Card[] deck = new Card[52];
    int suit = 0;
    for(int i = 0; i < 52; i++) {
      if (i % 13 == 0) {
        suit = i / 13;
      }
      deck[i] = new Card(g, (i % 13) + 1, suit);
    }

    deck[0] = new Card(g, 8, 3);
    deck[0].draw(20, 50);
  }
}
