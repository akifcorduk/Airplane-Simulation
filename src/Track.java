import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;

public class Track implements Drawable{

    private int id;
    private TrackContext context;
    private DrawRectangle rectangle ;

    public Track(int i){
        rectangle = new DrawRectangle(i*40,60,20,150);
        id = i;
        context = new TrackContext(new AvailableState());

    }


    public void draw(JFrame frame) {

        //frame.remove(rectangle);


        if(context.getState() instanceof AvailableState){
            this.rectangle.setBackground(new Color(0,252,0));
        }
        else{
            this.rectangle.setBackground(new Color(252,0,0));
        }
        this.rectangle.setVisible(true);
        //frame.add(rectangle);
        frame.repaint();
        frame.getContentPane().add(this.rectangle);


    }

    public void land(Plane plane){

    }

    public void takeOff(Plane plane){

    }
}

