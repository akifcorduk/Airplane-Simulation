import com.sun.org.apache.xml.internal.security.utils.JDKXPathAPI;

import javax.swing.*;
import java.awt.*;

public class DrawableController extends JPanel {

    private Drawable[] drawables;
    private Controller controller;
    private JFrame frame;

    public DrawableController(Controller controller){
        this.controller = controller;
        Track track1 = new Track(1);
        Track track2 = new Track(2);
        drawables = new Drawable[2];
        drawables[0] = track1;
        drawables[1]= track2;
        frame = new JFrame("DrawAirport");
    }

    public void draw(){
        for(Drawable drawable:drawables ){
            drawable.draw(frame);
        }

    }

    private void createAndShowGui() {
        //DrawRectangle mainPanel = new DrawRectangle(0,0,1000,600);
        //mainPanel.setBackground(new Color(0,0,252));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw();
        //frame.getContentPane().add(mainPanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public void drawGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
