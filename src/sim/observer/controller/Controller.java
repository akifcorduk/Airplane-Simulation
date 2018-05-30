package sim.observer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import interfaces.Drawable;
import sim.DrawingController;
import sim.Plane;
import sim.observer.track.Track;

public class Controller extends ControllerObserver {

	private static Queue<Plane> landQueue = new ConcurrentLinkedQueue<>();
	private static Queue<Plane> takeOffQueue = new ConcurrentLinkedQueue<>();
	private List<Track> availableTracks = new ArrayList<>();
	private Random random = new Random();


	public Controller(List<Track> availableTracks, List<Drawable> elements, TrackFrame frame) {
		this.availableTracks = availableTracks;
		DrawingController drawingController = new DrawingController(elements,frame);
		for (Track track : availableTracks ) {
			track.attachObserver(this);
			track.setDrawingController(drawingController);
		}

		//drawingController.draw();
		//control();
		new Thread(new Runnable() {
			@Override
			public void run() {
				control();
			}
		}).start();
	}

	public void control() {
		while (true) {
			if (!availableTracks.isEmpty()&&(!landQueue.isEmpty() || !takeOffQueue.isEmpty())) {
				Track track = getAvailableTrack();
				if (random.nextBoolean()) { // picking random between queues
					if (!landQueue.isEmpty()) {
						Plane plane = landQueue.poll();

						track.land(plane);
					}
					else if(!takeOffQueue.isEmpty()) {
						Plane plane = takeOffQueue.poll();
						//Track track = getAvailableTrack();
						track.takeOff(plane);
					}

				} else {

					if (!takeOffQueue.isEmpty()) {
						Plane plane = takeOffQueue.poll();
						//Track track = getAvailableTrack();
						track.takeOff(plane);
					}
					else if (!landQueue.isEmpty()) {
						Plane plane = landQueue.poll();
						//Track track = getAvailableTrack();
						track.land(plane);
					}

				}
			}
		}
	}

	public Track getAvailableTrack() {
		Track track = availableTracks.get(0);
		availableTracks.remove(track);

		return track;
	}

	@Override
	public void updateTakingOffPlane(Plane plane) {
		takeOffQueue.add(plane);
	}

	@Override
	public void updateTrack(Track track) {
		availableTracks.add(track);
	}

	@Override
	public void updateLandingPlane(Plane plane) {
		landQueue.add(plane);
	}
	
	
	public static int getQueueLength(String queue) {
		if (queue == "takeOff") {
			return takeOffQueue.size();
		}
		if (queue == "land") {
			return landQueue.size();
		}
		else {
			return 666;
		}
	}

}
