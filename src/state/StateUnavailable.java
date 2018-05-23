package state;

public class StateUnavailable implements TrackState {

    @Override
	public void changeAvailability(TrackContext context){
        TrackState state = new StateAvailable();
        context.setState(state);
    }

    @Override
  	public String toString() {
      	return "UNAVAILABLE";
      }
}
