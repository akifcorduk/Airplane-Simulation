package sim;

import java.util.List;

import interfaces.Drawable;

public class DrawingController implements Drawable {

	private List<Drawable> elements;

	public DrawingController(List<Drawable> drawables) {
		this.elements = drawables;
	}

	@Override
	public void draw() {
		for (Drawable drawable : elements) {
			drawable.draw();
		}
		System.out.println("____________");
		System.out.println();

	}

}
