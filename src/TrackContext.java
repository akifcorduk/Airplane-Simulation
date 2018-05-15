public class TrackContext {

	private TrackState state;

	public TrackContext(TrackState state) {
		this.state = state;
	}

	public void changeAvailability() {
		state.changeAvailability(this);
	}

	public void setState(TrackState state) {
		this.state = state;
	}

	public TrackState getState() {
		return state;
	}
}
