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
    System.out.println(Arrays.asList(deck));

    // Draw cards on screen
    for(int h=0;h<6;h++) {
      deck[h].draw(h*70, 10, 60);
    }
    for(int s=13;s<19;s++) {
      deck[s].draw((s-13)*70, 110, 60);
    }
    for(int d=26;d<32;d++) {
      deck[d].draw((d-26)*70, 210, 60);
    }
    for(int c=39;c<45;c++) {
      deck[c].draw((c-39)*70, 310, 60);
    }
  }
}