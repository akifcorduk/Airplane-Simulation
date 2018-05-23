package sim.observer.track;

import sim.observer.controller.ControllerObserver;

interface TrackSubject {

	public void notifyAboutTrack();

	public void attachObserver(ControllerObserver observer);

}
