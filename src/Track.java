public class Track implements Drawable{

    private int ID;
    private TrackContext context;

    public static void main(String[] args) {
        TrackContext context = new TrackContext();

        AvailableState startState = new AvailableState();
        startState.changeAvailability(context);

        System.out.println(context.getState().toString());

        UnavailableState stopState = new UnavailableState();
        stopState.changeAvailability(context);

        System.out.println(context.getState().toString());
    }

    public void draw() {

    }

    public void land(Plane plane){

    }

    public void takeOff(Plane plane){

    }
}

