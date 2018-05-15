public class TrackContext {

    private TrackState state;

    public TrackContext() {

        this.state= null;

    }

    public void changeAvailability(TrackState state){
        setState(state);
    }

    public void setState(TrackState state) {

        this.state = state;

    }

    public TrackState getState() {

        return state;

    }
}
