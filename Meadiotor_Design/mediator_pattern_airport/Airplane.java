package mediator_pattern_airport;

public interface Airplane {

    void requestTakeoff();

    void requestLanding();

    void notifyAirTrafficControl(String message);

}