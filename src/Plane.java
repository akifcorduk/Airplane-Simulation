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

	@Override
	public void draw() {

	}

	public void land(Track track) {

	}

	public void takeOff(Track track) {

	}

}
