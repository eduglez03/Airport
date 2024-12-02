package es.ull.passengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

  @Test
  void testPassengerInitialization() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    assertEquals("P123", passenger.getIdentifier());
    assertEquals("John Doe", passenger.getName());
  }

  @Test
  void testJoinFlight() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    Flight flight = new Flight("AA1234", 5);

    passenger.joinFlight(flight);

    assertEquals(flight, passenger.getFlight());
  }

  @Test
  void testSwitchFlight() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    Flight flight1 = new Flight("AA1234", 5);
    Flight flight2 = new Flight("BB5678", 5);

    passenger.joinFlight(flight1);
    passenger.joinFlight(flight2);

    assertEquals(flight2, passenger.getFlight());
  }

  @Test
  void testToString() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    String expected = "Passenger John Doe with identifier: P123 from US";
    assertEquals(expected, passenger.toString());
  }
}
