public class AvailableState implements TrackState {

    @Override
	public void changeAvailability(TrackContext context){
    	System.out.println("Track is unavailable");
    	TrackState state = new UnavailableState();
        context.setState(state);
    }
}
