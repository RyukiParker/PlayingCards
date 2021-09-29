import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;

class Card {

  Graphics g;
  int cardNum;
  String suit;

  public Card(Graphics g, int cardNum, int suit) {
    this.g = g;
    this.cardNum = cardNum;
    switch (suit) {
      // hearts
      case 0: this.suit = "\u2665";
                break;
      // spades
      case 1: this.suit = "\u2660";
                break;
      // diamonds
      case 2: this.suit = "\u2666";
                break;
      // clubs
      case 3: this.suit = "\u2663";
                break;
    }
  }

  // draws the card at a given (x, y) and size
  public void draw(int x, int y, int size) throws IOException {
    // base card
    g.setColor(Color.WHITE);
    g.fillRect(x, y, size, size / 2 * 3);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size / 2 * 3);

    // converting Graphics to Graphics2D
    Graphics2D g2 = (Graphics2D)g;
    // Creating an AffineTransform from g2
    AffineTransform old = g2.getTransform();
    // set font for corner suits and numbers
    Font corner = new Font("Serif", Font.PLAIN, (size/6));
    g2.setFont(corner);

    if (suit == "\u2665" || suit == "\u2666") {
      g2.setColor(Color.RED);
    } else {
      g2.setColor(Color.BLACK);
    }

    // draw the corresponding suit in corners
    g2.rotate(Math.toRadians(180), x + (size/2), y + (size / 4 * 3));
    for (int i=0;i<=2;i++) {
      g2.drawString(suit, x+(size/13), y+(int)(size/2.7));
      g2.setTransform(old);
    }

    // draw the corresponding number of symbols on the card
    g2.rotate(Math.toRadians(180), x + (size/2), y + (size / 4 * 3));
    switch (this.cardNum) {
      case 1: DrawAce(g2, x, y, size, old, this.suit);
              break;
      case 2: DrawTwo(g2, x, y, size, old, this.suit);
              break;
      case 3: DrawThree(g2, x, y, size, old, this.suit);
              break;
      case 4: DrawFour(g2, x, y, size, old, this.suit);
              break;
      case 5: DrawFive(g2, x, y, size, old, this.suit);
              break;
      case 6: DrawSix(g2, x, y, size, old, this.suit);
              break;
      case 7: DrawSeven(g2, x, y, size, old, this.suit);
              break;
      case 8: DrawEight(g2, x, y, size, old, this.suit);
              break;
      case 9: DrawNine(g2, x, y, size, old, this.suit);
              break;
      case 10: DrawTen(g2, x, y, size, old, this.suit);
              break;
      case 11: DrawJack(g2, x, y, size, old, this.suit);
              break;
      case 12: DrawQueen(g2, x, y, size, old, this.suit);
              break;
      case 13: DrawKing(g2, x, y, size, old, this.suit);
              break;
    }
  }

  // NUMBERS

  public static void DrawAce(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {
    // set font for ace card
    Font ace = new Font("Serif", Font.PLAIN, (size/2));
    g2.setFont(ace);
    g2.setTransform(old);

    g2.drawString(suit, x+(int)(size/3.7), y+(int)(size/1.1));

    // draws "A" in both corners
    g2.rotate(Math.toRadians(180), x + (size/2), y + (size / 4 * 3));
    for (int i=0;i<=2;i++) {
      g2.drawLine(x+(size/7), y+(size/10), x+(size/5), y+(size/5));
      g2.drawLine(x+(size/7), y+(size/10), x+(size/12), y+(size/5));
      g2.drawLine(x+(size/9), y+(size/7), x+(size/6), y+(size/7));
      g2.setTransform(old);
    }
  }

  public static void DrawTwo(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {
    // draws "2" in both corners
    for (int i=0;i<=2;i++) {
      g2.drawString("2", x+(size/13), y+(int)(size/5));
      g2.setTransform(old);
    }

    // set font for "small" (2-10) cards
    Font small = new Font("Serif", Font.PLAIN, (size/3));
    g2.setFont(small);

    // draws 2 of given suit
    g2.drawString(suit, x+(int)(size/2.75), y+(int)    (size/2));
    g2.rotate(Math.toRadians(180), x + (size/2), y + (size / 4 * 3));
    g2.drawString(suit, x+(int)(size/2.75), y+(int)(size/2));
    g2.setTransform(old);
  }

  public static void DrawThree(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {
    // draws "3" in both corners
    for (int i=0;i<=2;i++) {
      g2.drawString("3", x+(size/13), y+(int)(size/5));
      g2.setTransform(old);
    }

    // set font for "small" (2-10) cards
    Font small = new Font("Serif", Font.PLAIN, (size/3));
    g2.setFont(small);

    // draws 3 of given suit
    g2.drawString(suit, x+(int)(size/2.75), y+(int)    (size/2));
    g2.rotate(Math.toRadians(180), x + (size/2), y + (size / 4 * 3));
    g2.drawString(suit, x+(int)(size/2.75), y+(int)(size/2));
    g2.setTransform(old);
    g2.drawString(suit, x+(int)(size/2.75), y+(int)    (size/1.12));    
  }

  public static void DrawFour(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {
    // draws "4" in both corners
    for (int i=0;i<=2;i++) {
      g2.drawString("4", x+(size/13), y+(int)(size/5));
      g2.setTransform(old);
    }

    // set font for "small" (2-10) cards
    Font small = new Font("Serif", Font.PLAIN, (size/3));
    g2.setFont(small);

    // draws 4 of given suit
    
    g2.drawString(suit, x+(int)(size/5.5), y+(int)(size/2));
    g2.drawString(suit, x+(int)(size/1.85), y+(int)(size/2));
    g2.rotate(Math.toRadians(180), x + (size/2), y + (size / 4 * 3));
    g2.drawString(suit, x+(int)(size/5.5), y+(int)(size/2));
    g2.drawString(suit, x+(int)(size/1.85), y+(int)(size/2));
    g2.setTransform(old);
  }

  public static void DrawFive(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {
    // draws "5" in both corners
    for (int i=0;i<=2;i++) {
      g2.drawString("5", x+(size/13), y+(int)(size/5));
      g2.setTransform(old);
    }

    // set font for "small" (2-10) cards
    Font small = new Font("Serif", Font.PLAIN, (size/3));
    g2.setFont(small);

    // draws 5 of given suit
    g2.rotate(Math.toRadians(180), x + (size/2), y + (size / 4 * 3));
    g2.drawString(suit, x+(int)(size/5.5), y+(int)(size/2));
    g2.drawString(suit, x+(int)(size/1.85), y+(int)(size/2));
    g2.setTransform(old);
    g2.drawString(suit, x+(int)(size/5.5), y+(int)(size/2));
    g2.drawString(suit, x+(int)(size/1.85), y+(int)(size/2));
    g2.drawString(suit, x+(int)(size/2.75), y+(int)(size/1.12)); 
  }

  public static void DrawSix(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {
    // draws "6" in both corners
    for (int i=0;i<=2;i++) {
      g2.drawString("6", x+(size/13), y+(int)(size/5));
      g2.setTransform(old);
    }

    // set font for "small" (2-10) cards
    Font small = new Font("Serif", Font.PLAIN, (size/3));
    g2.setFont(small);

    // draws 6 of given suit
    g2.rotate(Math.toRadians(180), x + (size/2), y + (size / 4 * 3));
    g2.drawString(suit, x+(int)(size/5.5), y+(int)(size/2));
    g2.drawString(suit, x+(int)(size/1.85), y+(int)(size/2));
    g2.setTransform(old);
    g2.drawString(suit, x+(int)(size/5.5), y+(int)(size/2));
    g2.drawString(suit, x+(int)(size/1.85), y+(int)(size/2));
    g2.drawString(suit, x+(int)(size/5.5), y+(int)(size/1.12)); 
    g2.drawString(suit, x+(int)(size/1.85), y+(int)(size/1.12)); 
  }

  public static void DrawSeven(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {

  }

  public static void DrawEight(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {

  }

  public static void DrawNine(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {

  }

  public static void DrawTen(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {

  }

  public static void DrawJack(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {

  }

  public static void DrawQueen(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {

  }

  public static void DrawKing(Graphics2D g2, int x, int y, int size, AffineTransform old, String suit) {

  }

  public String toString() {
    return "Card: " + this.cardNum + " of " + this.suit;
  }
}