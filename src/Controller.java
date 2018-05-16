public class Controller {

    private Plane[] planes;

    public Plane[] getPlanes() {
        return planes;
    }

    public Track[] getTracks() {
        return tracks;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    private Track[] tracks;
    private int numberOfTracks;

    public Controller(){
        numberOfTracks = 3;
        tracks = new Track[3];
        for(int i=0 ; i< numberOfTracks ; i++){
            tracks[i] = new Track(i);
        }
    }


}
