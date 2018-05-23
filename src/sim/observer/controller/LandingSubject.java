package sim.observer.controller;

interface LandingSubject {

	public void notifyAboutLanding();

	public void attachObserver(ControllerObserver observer);

}
