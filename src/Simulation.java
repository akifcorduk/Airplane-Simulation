import javax.swing.*;

public class Simulation {

    public static void main(String args[]){
        Controller controller = new Controller();
        DrawableController drawableController = new DrawableController(controller);
        drawableController.drawGUI();

    }
}
