public class AvailableState implements TrackState {

    @Override
	public void changeAvailability(TrackContext context){
        System.out.println("Track is in available state");
        context.changeAvailability(this);
    }
}
