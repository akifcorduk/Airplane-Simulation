import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Controller extends UserInterface {

	private Queue<Plane> landQueue = new ConcurrentLinkedQueue<>();
	private Queue<Plane> takeOffQueue = new ConcurrentLinkedQueue<>();
	private List<Track> availableTracks = new ArrayList<>();

	public Controller(List<Track> availableTracks) {
		this.availableTracks = availableTracks;
	}

	@Override
	public void notifyAddLandingPlane() {
		Plane plane = new Plane();
		landQueue.add(plane);
	}

	@Override
	public void notifyAddTakingOffPlane() {
		Plane plane = new Plane();
		takeOffQueue.add(plane);
	}

	public static void main(String args[]) {
		new Controller(null).takeInput();
	}
}
