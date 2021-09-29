import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class FaceCard extends Card {

    enum Face{
        JACK,
        QUEEN,
        KING
    }

    /**
     * The face of the card
     */
    private Face face;

    private int suitID;
    DrawingPanel panel;
    /**
     * Constructor For Face Card
     *
     * @param panel Panel Object for where to draw the card and its image
     * @param cardNum The card value
     * @param suit The card suite
     */
    public FaceCard(DrawingPanel panel , int cardNum, int suit){
        super(panel.getGraphics(), cardNum, suit);
        this.suitID = suit;

        this.panel = panel;
        switch(cardNum){
            case 11:
                this.face = Face.JACK;
                break;
            case 12:
                this.face = Face.QUEEN;
                break;
            case 13:
                this.face = Face.KING;
                break;
        }
    }

    @Override
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

        // Draw letter above symbol
        for (int i=0;i<=2;i++) {
            g2.drawString(this.getLetter(), x+(size/13), y+(int)(size/5));
            g2.setTransform(old);
        }


        // Read and draw image

        // Find file based on name and suit
        String fileName = this.getLetter()+this.suitID;
        
        BufferedImage img = ImageIO.read(new File("./img/"+fileName+".png"));

        g2.drawImage(img,x+10, y+10, size-20,(size / 2 * 3) -20, panel);
    }

    /**
    * Get face card letter.
    * @return The face cards letter
    */
    public String getLetter(){
        switch(this.face){
            case JACK:
                return "J";
            case QUEEN:
                return "Q";
            case KING:
                return "K";
            default:
                return "K";
        }
    }
}
