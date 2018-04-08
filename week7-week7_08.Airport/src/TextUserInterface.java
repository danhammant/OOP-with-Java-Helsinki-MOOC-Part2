import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Airplane airplanes;
    private Flight flights;

    public TextUserInterface(Scanner reader, Airplane airplanes, Flight flights) {
        this.reader = reader;
        this.airplanes = airplanes;
        this.flights = flights;
    }

    public void start() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println();

        while (true) {
            panelCommands();

            String operation = this.reader.nextLine();
            if (operation.equals("x")) {
                break;
            }
            handleInputFromPanel(operation);
        }

        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println();

        while (true) {
            serviceCommands();

            String operation = this.reader.nextLine();
            if (operation.equals("x")) {
                break;
            }
            handleInputFromService(operation);

        }

    }

    private void addAirplane() {
        System.out.print("Give plane ID: ");
        String planeID = this.reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(this.reader.nextLine());
        this.airplanes.addPlane(planeID, capacity);
    }

    private void addFlight() {
        System.out.print("Give plane ID: ");
        String airplane = this.airplanes.planeToString(this.reader.nextLine());
        System.out.print("Give departure airport code: ");
        String departureAirport = this.reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destinationAirport = this.reader.nextLine();
        this.flights.addFlight(airplane, departureAirport, destinationAirport);
    }

    private void panelCommands() {
        System.out.println("Choose operation:");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
        System.out.print("> ");
    }

    private void handleInputFromPanel(String operation) {
        if (operation.equals("1")) {
            addAirplane();
        } else if (operation.equals("2")) {
            addFlight();
        } else {
            System.out.println("Unknown operation!");
        }
    }

    private void serviceCommands() {
        System.out.println("Choose operation:");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");
        System.out.print("> ");
    }

    private void handleInputFromService(String operation) {
        if (operation.equals("1")) {
            printPlanes();
        } else if (operation.equals("2")) {
            printFlights();
        } else if (operation.equals("3")) {
            printPlaneInfo();
        } else {
            System.out.println("Unknown operation!");
        }
    }

    private void printPlanes() {
        for (String plane : this.airplanes.airplaneList()) {
            System.out.println(plane);
        }
    }

    private void printPlaneInfo() {
        System.out.print("Give plane ID: ");
        String plane = this.reader.nextLine();
        String planeInfo = this.airplanes.planeToString(plane);
        System.out.println(planeInfo);
    }

    private void printFlights() {
        this.flights.flightList();
    }
}
