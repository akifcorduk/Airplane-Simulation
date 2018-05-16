import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class DrawRectangle extends JPanel {
    private int RECT_X = 20;
    private int RECT_Y = 20;
    private int RECT_WIDTH = 100;
    private int RECT_HEIGHT = 100;

    public DrawRectangle(){

    }

    public DrawRectangle(int x, int y, int width, int height){
        this.RECT_X = x;
        this.RECT_Y = y;
        this.RECT_WIDTH = width;
        this.RECT_HEIGHT = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the rectangle here
        g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
    }

    @Override
    public Dimension getPreferredSize() {
        // so that our GUI is big enough
        return new Dimension(RECT_WIDTH + 2 * RECT_X, RECT_HEIGHT + 2 * RECT_Y);
    }


}