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
    assertEquals("US", passenger.getCountryCode());
  }

  @Test
  void testPassengerInvalidCountryCode() {
    assertThrows(RuntimeException.class, () -> new Passenger("P123", "John Doe", "XX"));
  }

  @Test
  void testJoinFlight() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    Flight flight = new Flight("AA1234", 5);

    passenger.joinFlight(flight);

    assertEquals(flight, passenger.getFlight());
    assertEquals(1, flight.getNumberOfPassengers());
  }

  @Test
  void testSwitchFlight() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    Flight flight1 = new Flight("AA1234", 5);
    Flight flight2 = new Flight("BB5678", 5);

    passenger.joinFlight(flight1);
    passenger.joinFlight(flight2);

    assertEquals(flight2, passenger.getFlight());
    assertEquals(0, flight1.getNumberOfPassengers());
    assertEquals(1, flight2.getNumberOfPassengers());
  }

  @Test
  void testToString() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    String expected = "Passenger John Doe with identifier: P123 from US";
    assertEquals(expected, passenger.toString());
  }







  @Test
  void testJoinFlightCannotRemovePassenger() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    Flight flight1 = new Flight("AA1234", 5);
    Flight flight2 = new Flight("BB5678", 5);

    // Simulamos la condición en la que `removePassenger` devuelve `false`.
    flight1.addPassenger(passenger);
    passenger.setFlight(flight1);
    assertThrows(RuntimeException.class, () -> {
      passenger.joinFlight(new Flight("MockFlight", 5) {
        @Override
        public boolean removePassenger(Passenger p) {
          return false; // Forzamos el fallo
        }
      });
    });
  }

  @Test
  void testJoinFlightCannotAddPassenger() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    Flight flight1 = new Flight("AA1234", 5);
    Flight flight2 = new Flight("BB5678", 5);

    // Simulamos la condición en la que `addPassenger` devuelve `false`.
    assertThrows(RuntimeException.class, () -> {
      passenger.joinFlight(new Flight("MockFlight", 5) {
        @Override
        public boolean addPassenger(Passenger p) {
          return false; // Forzamos el fallo
        }
      });
    });
  }
}


