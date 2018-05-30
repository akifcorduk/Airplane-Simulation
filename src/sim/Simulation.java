package sim;
import java.util.ArrayList;
import java.util.List;

import interfaces.Drawable;
import sim.observer.controller.Controller;
import sim.observer.controller.TrackFrame;
import sim.observer.track.Track;

import javax.swing.*;

public class Simulation {


	public static List<Track> createTrackArray() {
		List<Track> tracks = new ArrayList<>();
		Track track1 = new Track();
		Track track2 = new Track();
		Track track3 = new Track();

		tracks.add(track1);
		tracks.add(track2);
		tracks.add(track3);

		return tracks;
	}

	private static List<Drawable> createDrawableArray(List<Track> tracks) {
		List<Drawable> drawables = new ArrayList<>();

		for (Track track : tracks) {
			drawables.add(track);
		}
		return drawables;
	}



	public static void main(String[] args) {

		List<Track> tracks = createTrackArray();
		TrackFrame frame = new TrackFrame();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//frame = new TrackFrame();

			}
		});
		List<Drawable> elements = createDrawableArray(tracks);
		Controller controller = new Controller(tracks, elements,frame);
		frame.attachObserver(controller);
		/*
		Thread thread = new Thread(new Runnable() {

			public void run() {
				createAndShowGUI();

			}
		});
		thread.start();*/

	}

}
