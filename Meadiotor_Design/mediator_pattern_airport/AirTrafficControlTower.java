// Mediator Interface
package mediator_pattern_airport;

public interface AirTrafficControlTower {

    void requestTakeoff(Airplane airplane);

    void requestLanding(Airplane airplane);

}