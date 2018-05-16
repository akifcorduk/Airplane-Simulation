import java.util.ArrayList;
import java.util.List;

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

	public static void main(String[] args) {
		List<Track> tracks = createTrackArray();

		new Controller(tracks).takeInput();
	}

}
