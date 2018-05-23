package sim.observer.controller;

interface TakingOffSubject {

	public void notifyAboutTakingOff();

	public void attachObserver(ControllerObserver observer);

}
