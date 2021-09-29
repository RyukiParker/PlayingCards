import java.awt.*;
import java.awt.geom.AffineTransform;

class Card {

  private Graphics g;
  private int indexOfTheCard;
  private String suit;
  private final int HEIGHTOFTHECARD = 200;
  private final int WIDTHOFTHECARD = 100;

  public Card(Graphics g, int indexOfTheCard, int suit) {
    this.g = g;
    this.indexOfTheCard = indexOfTheCard;
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
  public void draw(int positionOfTheCardX, int positionOfTheCardY) {
    // base card
	drawBaseOfTheCard(g, positionOfTheCardX, positionOfTheCardY);
	
	//set color
	if (this.suit == "\u2665" || this.suit == "\u2666") 
		g.setColor(Color.RED);
	else 
		g.setColor(Color.BLACK);
	
  g.setFont(new Font("Serif", Font.PLAIN, 17)); 
  
	//draw corners of the card
	drawCornersOfTheCard(positionOfTheCardX, positionOfTheCardY);

  //draw center of the card (numbers)
  drawCenterOfTheCard(positionOfTheCardX, positionOfTheCardY);
  }

    
  //draws base of the card (white background)
  private void drawBaseOfTheCard(Graphics g, int positionOfTheCardX, int positionOfTheCardY) 
  {
	  g.setColor(Color.WHITE);
	  g.fillRect(positionOfTheCardX, positionOfTheCardY, WIDTHOFTHECARD, HEIGHTOFTHECARD);
  }
  
  //corners of the card
  private void drawCornersOfTheCard(int positionOfTheCardX, int positionOfTheCardY) {
	  if (this.indexOfTheCard <= 10) 
	  {
		  g.drawString((String.valueOf(this.indexOfTheCard)), positionOfTheCardX + (int)(positionOfTheCardX * 0.15), positionOfTheCardY + (int)(positionOfTheCardY * 0.4));

      g.drawString(this.suit, positionOfTheCardX + (int)(positionOfTheCardX * 0.1), positionOfTheCardY + (int)(positionOfTheCardY * 0.7));

      g.setFont(new Font("Serif", Font.PLAIN, -17));

      g.drawString((String.valueOf(this.indexOfTheCard)), positionOfTheCardX + WIDTHOFTHECARD - (int)(positionOfTheCardX * 0.15), positionOfTheCardY + HEIGHTOFTHECARD - (int)(positionOfTheCardY * 0.4));

      g.drawString(this.suit, positionOfTheCardX + WIDTHOFTHECARD - (int)(positionOfTheCardX * 0.1), positionOfTheCardY + HEIGHTOFTHECARD - (int)(positionOfTheCardY * 0.7));

      g.setFont(new Font("Serif", Font.PLAIN, 17));
	  }
	  else 
	  {
		//...  
	  }
  }

  //draws center of the card
  private void drawCenterOfTheCard(int positionOfTheCardX, int positionOfTheCardY)
  {
    int indexOfTheCardCPY = this.indexOfTheCard;

    g.setFont(new Font("Serif", Font.PLAIN, 17));
    if (indexOfTheCardCPY % 2 == 1)
    {
      g.drawString(suit, positionOfTheCardX + WIDTHOFTHECARD / 2 - (17 / 2), positionOfTheCardY + HEIGHTOFTHECARD / 2 + (17 / 2));

      indexOfTheCardCPY--;
    }

    indexOfTheCardCPY /= 2;

    if (indexOfTheCardCPY % 2 == 1)
    {
      g.drawString(suit, positionOfTheCardX + WIDTHOFTHECARD / 2 - (17 / 2) - (int)(WIDTHOFTHECARD * 0.15), positionOfTheCardY + HEIGHTOFTHECARD / 2 + (17 / 2));

      g.drawString(suit, positionOfTheCardX + WIDTHOFTHECARD / 2 - (17 / 2) + (int)(WIDTHOFTHECARD * 0.15), positionOfTheCardY + HEIGHTOFTHECARD / 2 + (17 / 2));

      indexOfTheCardCPY--;
    }

    indexOfTheCardCPY /= 2;

    int shiftByY = positionOfTheCardY + HEIGHTOFTHECARD / 2 + (17 / 2);

    for (int ctr = 0; ctr < indexOfTheCardCPY; ctr++)
    {
        shiftByY += (int)(HEIGHTOFTHECARD * 0.15);

        g.drawString(suit, positionOfTheCardX + WIDTHOFTHECARD / 2 - (17 / 2) - (int)(WIDTHOFTHECARD * 0.15), shiftByY);

      g.drawString(suit, positionOfTheCardX + WIDTHOFTHECARD / 2 - (17 / 2) + (int)(WIDTHOFTHECARD * 0.15), shiftByY);
    }

    shiftByY = positionOfTheCardY + HEIGHTOFTHECARD / 2 + (17 / 2);

    for (int ctr = 0; ctr < indexOfTheCardCPY; ctr++)
    {
        shiftByY -= (int)(HEIGHTOFTHECARD * 0.15);

        g.drawString(suit, positionOfTheCardX + WIDTHOFTHECARD / 2 - (17 / 2) - (int)(WIDTHOFTHECARD * 0.15), shiftByY);

      g.drawString(suit, positionOfTheCardX + WIDTHOFTHECARD / 2 - (17 / 2) + (int)(WIDTHOFTHECARD * 0.15), shiftByY);
    }
  }
}
