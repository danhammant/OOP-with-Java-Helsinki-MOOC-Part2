import java.util.ArrayList;

public class Flight {
    private ArrayList<String> flights;
    private Airplane airplane;

    public Flight() {
        this.flights = new ArrayList<>();
    }

    public void addFlight(String airplane, String departure, String destination) {
        String flight = airplane + " (" + departure + "-" + destination + ")";

        this.flights.add(flight);
    }

    public void flightList() {
        for (String flight : this.flights) {
            System.out.println(flight);
        }
    }


}
