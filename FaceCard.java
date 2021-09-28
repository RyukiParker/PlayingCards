import java.awt.*;
import java.awt.geom.AffineTransform;



public class FaceCard extends Card {

    /**
     * Constructor For Face Card
     *
     * @param g Graphics Object for where to draw the card
     * @param cardNum The card value
     * @param suit The card suite
     */
    public FaceCard(Graphics g, int cardNum, int suit){

        super(g, cardNum, suit);
    }

    @Override
    public void draw(int x, int y, int size) {
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

        if (suit.equals("\u2665") || suit.equals("\u2666")) {
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


    }
}
