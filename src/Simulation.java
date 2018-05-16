import java.util.ArrayList;
import java.util.List;

public class Simulation {

	public static List<Track> createTrackArray() {
		List<Track> tracks = new ArrayList<>();
		Track track1 = new Track(1);
		Track track2 = new Track(2);
		Track track3 = new Track(3);

		tracks.add(track1);
		tracks.add(track2);
		tracks.add(track3);

		return tracks;
	}

	public static void main(String[] args) {
		List<Track> tracks = createTrackArray();

		Controller controller = new Controller(tracks);
		//controller.takeInput();

		DrawableController dc = new DrawableController(controller);
		dc.drawGUI();
	}

}
