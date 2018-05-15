public class UnavailableState implements TrackState {

    @Override
	public void changeAvailability(TrackContext context){
    	System.out.println("Track is available");
        TrackState state = new AvailableState();
        context.setState(state);
    }
}
