package sim;

import interfaces.Drawable;
import interfaces.Movable;
import sim.observer.track.Track;

public class Plane implements Movable, Drawable {

	private static int lastId = 0;
	private int id;

	public Plane() {
		int id = ++lastId;
		System.out.println(id);
		this.id = id;
	}

	@Override
	public void move() {

	}

	public void land(Track track) {
		waitSomeTime();
	}

	public void takeOff(Track track) {
		waitSomeTime();
	}

	@Override
	public String toString() {
		return "Plane [id=" + id + "]";
	}

	private void waitSomeTime() {
		for (int i = 0; i <= 30000000; i++) {
			System.out.print("");
		}
	}

	public int getId() {
		return id;
	}

	@Override
	public void draw() {
		System.out.println("|  __|__   |");
		System.out.println("|*--oOo---*|");
		System.out.println("|  plane" + id + "  |");
	}

}
