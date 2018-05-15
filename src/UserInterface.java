import java.util.Scanner;

public abstract class UserInterface {

	public abstract void notifyAddLandingPlane();

	public abstract void notifyAddTakingOffPlane();

	public void takeInput() {
		boolean notOver = true;
		while (notOver) {
			Scanner reader = new Scanner(System.in);
			String input = reader.nextLine().trim();
			if ("l".equals(input)) {
				notifyAddLandingPlane();
			} else if ("t".equals(input)) {
				notifyAddTakingOffPlane();
			} else if ("q".equals(input)) {
				System.out.println("Quitting ...");
				reader.close();
				notOver = false;
			} else {
				System.out.println(
						"Option unknown. Try 'l' for adding a plane to the landing queue or 't' for adding a plane to the take off queue");
			}

		}
	}

}
