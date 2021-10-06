
import java.awt.*;

class Player2{

  private Card c2;
  private Graphics g;

  public Player2(Card c2, Graphics g){
    this.c2 = new Card(g,2,4);
  }
  public Card getc2(){
    return c2;
  }
}