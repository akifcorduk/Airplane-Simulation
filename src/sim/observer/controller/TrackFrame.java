package sim.observer.controller;

import sim.Plane;
import sim.observer.controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class TrackFrame extends JFrame implements LandingSubject, TakingOffSubject  {

    int frameX = 1000;
    int frameY = 600;
    ArrayList<MyShape> shapes;
    private ControllerObserver observer;
    
    JLabel fieldLand = new JLabel("Number of planes\r waiting to land : "+Controller.getQueueLength("land"));
    JLabel fieldTakeOff = new JLabel("Number of planes waiting to take off : "+Controller.getQueueLength("takeOff"));

    public TrackFrame(){


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(2,1));

        JPanelExample p = new JPanelExample();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton landButton = new JButton("Land");
        landButton.setPreferredSize(new Dimension(100, 100));
        landButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notifyAboutLanding();
            }
        });

        JButton takeoffButton = new JButton("Takeoff");
        takeoffButton.setPreferredSize(new Dimension(100, 100));
        takeoffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notifyAboutTakingOff();
            }
        });

        // The Queues //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        add(fieldTakeOff);
        fieldTakeOff.setSize(10,10);
        fieldTakeOff.setVisible(true);
        
        add(fieldLand);
        fieldLand.setSize(10,10);
        fieldLand.setVisible(true);
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        buttonPanel.add(landButton);
        buttonPanel.add(takeoffButton);

        shapes = new ArrayList<>();
        for(int i = 0 ; i < 3 ; i++){
            shapes.add(new MyShape(Color.GREEN, i));
        }
        p.setShapes(shapes);

        getContentPane().add(p);
        getContentPane().add(buttonPanel);
        pack();
        setSize(frameX, frameY);
        setVisible(true);
    }
    

    
    
    public void makeAvailable(int id){
        MyShape shape = shapes.get(id);
        shape.shapeColor = Color.GREEN;
        repaint();
        fieldLand.setText("Number of planes waiting to land : "+Controller.getQueueLength("land"));
        fieldTakeOff.setText("Number of planes waiting to take off : "+Controller.getQueueLength("takeOff"));
        
    }

    public void makeBusy(int id){
        MyShape shape = shapes.get(id);
        shape.shapeColor = Color.RED;
        repaint();
        fieldLand.setText("Number of planes waiting to land : "+Controller.getQueueLength("land"));
        fieldTakeOff.setText("Number of planes waiting to take off : "+Controller.getQueueLength("takeOff"));
    }

    @Override
    public void notifyAboutLanding() {
        observer.updateLandingPlane(new Plane());
        fieldLand.setText("Number of planes waiting to land : "+Controller.getQueueLength("land"));
    }
    

    @Override
    public void notifyAboutTakingOff() {
        observer.updateTakingOffPlane(new Plane());
        fieldTakeOff.setText("Number of planes waiting to take off : "+Controller.getQueueLength("takeOff"));
    }

    @Override
    public void attachObserver(ControllerObserver observer) {
        this.observer = observer;
    }


    
}



class JPanelExample extends JPanel{
    ArrayList<MyShape> shapes;

    public void setShapes(ArrayList<MyShape> shapes){
        this.shapes = shapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graph2 =(Graphics2D) g.create();
        graph2.drawRect(20, 20, 400, 40);
        graph2.drawRect(20, 100, 400, 40);
        graph2.drawRect(20, 180, 400, 40);

        graph2.setColor(shapes.get(0).shapeColor);
        graph2.fillRect(20, 20, 400, 40);
        graph2.setColor(shapes.get(1).shapeColor);
        graph2.fillRect(20, 100, 400, 40);
        graph2.setColor(shapes.get(2).shapeColor);
        graph2.fillRect(20, 180, 400, 40);
    }
}


class MyShape {
    Color shapeColor;
    int id;

    public MyShape(Color shapeColor,int id ){
        this.shapeColor = shapeColor;
        this.id = id;
    }
}
