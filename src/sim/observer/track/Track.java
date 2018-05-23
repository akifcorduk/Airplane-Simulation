package sim.observer.track;

import interfaces.Drawable;
import sim.DrawingController;
import sim.Plane;
import sim.observer.controller.ControllerObserver;
import state.StateAvailable;
import state.TrackContext;

public class Track implements Drawable, TrackSubject {

	private static int idCounter = 1;
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

	public void land(Plane plane) {
		this.plane = plane;
		drawingController.draw(); // draw the empty track
		context.changeAvailability(); // make track unavailable
		drawingController.draw(); // draw the busy track
		plane.land(this); // land the plane (wait 1s)
		context.changeAvailability(); // make track available again
		notifyAboutTrack();
		drawingController.draw(); // draw the empty track again
	}

	public void takeOff(Plane plane) {
		this.plane = plane;
		drawingController.draw(); // draw the empty track
		context.changeAvailability(); // make track unavailable
		drawingController.draw(); // draw the busy track
		plane.takeOff(this); // take off the plane (wait 1s)
		context.changeAvailability(); // make track available again
		notifyAboutTrack();
		drawingController.draw(); // draw the empty track again

		drawingController.draw();
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
