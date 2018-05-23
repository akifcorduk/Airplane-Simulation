package state;

public class StateAvailable implements TrackState {

    @Override
	public void changeAvailability(TrackContext context){
    	TrackState state = new StateUnavailable();
        context.setState(state);
    }

    @Override
	public String toString() {
    	return "AVAILABLE";
    }
}
