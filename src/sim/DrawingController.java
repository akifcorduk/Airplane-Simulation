package sim;

import java.awt.*;
import java.util.List;

import interfaces.Drawable;
import sim.observer.controller.TrackFrame;

public class DrawingController implements Drawable {

	private List<Drawable> elements;
	public TrackFrame userInterface;

	public DrawingController(List<Drawable> drawables, TrackFrame frame) {
		userInterface = frame;
		this.elements = drawables;
	}

	@Override
	public void draw() {
		for (Drawable drawable : elements) {
			//drawable.draw();
		}
		/*
		System.out.println("____________");
		System.out.println();
		*/
	}

}
