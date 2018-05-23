package sim.observer.controller;
import java.util.Scanner;

import sim.Plane;

public class UserInterface implements LandingSubject, TakingOffSubject {

	private ControllerObserver observer;

	public void takeInput() {
		boolean notOver = true;
		while (notOver) {
			Scanner reader = new Scanner(System.in);
			String input = reader.nextLine().trim();
			if ("l".equals(input)) {
				notifyAboutLanding(); // add a plane to the landing queue
			} else if ("t".equals(input)) {
				notifyAboutTakingOff(); // add a plane to the taking off queue
			} else if ("q".equals(input)) {
				System.out.println("Quitting ...");
				reader.close();
				notOver = false;
			} else {
				System.out.println("Option unknown.");
			}

		}
	}

	@Override
	public void notifyAboutLanding() {
		observer.updateLandingPlane(new Plane());
	}

	@Override
	public void notifyAboutTakingOff() {
		observer.updateTakingOffPlane(new Plane());
	}

	@Override
	public void attachObserver(ControllerObserver observer) {
		this.observer = observer;
	}
}
