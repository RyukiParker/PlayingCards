
import java.awt.*;

class Player1{

  private Card c1;
  private Graphics g;

  public Player1(Card c1, Graphics g){
    this.c1 = new Card(g,5,2);
  }
  public Card getc1(){
    return c1;
  }
}