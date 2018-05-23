package sim;
import java.util.ArrayList;
import java.util.List;

import interfaces.Drawable;
import sim.observer.controller.Controller;
import sim.observer.controller.UserInterface;
import sim.observer.track.Track;

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
		List<Drawable> elements = createDrawableArray(tracks);
		Controller controller = new Controller(tracks, elements);


		UserInterface gui = new UserInterface();
		gui.attachObserver(controller);
		gui.takeInput();
	}

}
