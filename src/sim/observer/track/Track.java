package sim.observer.track;

import interfaces.Drawable;
import sim.DrawingController;
import sim.Plane;
import sim.Simulation;
import sim.observer.controller.ControllerObserver;
import state.StateAvailable;
import state.TrackContext;
import sim.observer.controller.TrackFrame;

public class Track implements Drawable, TrackSubject {

	private static int idCounter = 0;
	private int id;
	private ControllerObserver observer;
	private TrackContext context;
	private DrawingController drawingController;
	private Plane plane;

	public Track() {
		id = idCounter++;
		context = new TrackContext(new StateAvailable());
	}

	public TrackContext getContext() {
		return context;
	}

	/*
	@Override
	public void draw() {
		if (context.getState() instanceof StateAvailable) {
			System.out.println("|  track" + id + "  |");
			System.out.println("|   	   |");
			System.out.println("|   	   |");
			System.out.println("|   	   |");
			System.out.println("|   	   |");
			System.out.println();
		} else {
			System.out.println("|  track" + id + "  |");
			System.out.println("|   	   |");
			plane.draw();
			System.out.println();
		}
	}
	*/

	public void draw(){
		if (context.getState() instanceof StateAvailable) {
			TrackFrame frame = drawingController.userInterface;
			frame.makeAvailable(id);
		}
		else{
			TrackFrame frame = drawingController.userInterface;
			frame.makeBusy(id);
		}
	}

	public void land(Plane plane) {
		this.plane = plane;
		context.changeAvailability();
		draw();
		new Thread(new Runnable() {
			@Override
			public void run() {
				planeLand(plane);
				context.changeAvailability();
				notifyAboutTrack();
				draw();
			}
		}).start();


	}

	public void takeOff(Plane plane) {
		this.plane = plane;
		context.changeAvailability();
		draw();
		new Thread(new Runnable() {
			@Override
			public void run() {
				planeTakeoff(plane);
				context.changeAvailability();
				notifyAboutTrack();
				draw();
			}
		}).start();


	}

	private void planeTakeoff(Plane plane){
		plane.takeOff(this);
	}

	private void planeLand(Plane plane){
		plane.land(this);
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", context=" + context + "]";
	}

	@Override
	public void notifyAboutTrack() {
		observer.updateTrack(this);
	}

	@Override
	public void attachObserver(ControllerObserver observer) {
		this.observer = observer;
	}

	public void setDrawingController(DrawingController drawingController) {
		this.drawingController = drawingController;
	}

}
