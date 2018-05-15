public class UnavailableState implements TrackState {

    public void changeAvailability(TrackContext context){
        System.out.println("Track is in unavailable state");
        context.changeAvailability(this);
    }
}
