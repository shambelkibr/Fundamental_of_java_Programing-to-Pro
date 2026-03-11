// Main Class
package mediator_pattern_airport;

public class MediatorAirplaneExample {

    public static void main(String[] args) {

        // Create Mediator
        AirTrafficControlTower controlTower = new AirportControlTower();

        // Create Airplanes
        Airplane airplane1 = new CommercialAirplane(controlTower);
        Airplane airplane2 = new CommercialAirplane(controlTower);

        // Request operations
        airplane1.requestTakeoff();
        airplane2.requestLanding();

    }

}