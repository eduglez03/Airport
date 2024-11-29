package es.ull.flights;

import es.ull.passengers.Passenger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

  @Test
  void testFlightInitialization() {
    Flight flight = new Flight("AA1234", 5);
    assertEquals("AA1234", flight.getFlightNumber());
    assertEquals(0, flight.getNumberOfPassengers());
  }

  @Test
  void testInvalidFlightNumber() {
    assertThrows(RuntimeException.class, () -> new Flight("INVALID123", 5));
  }

  @Test
  void testAddPassenger() {
    Flight flight = new Flight("AA1234", 5);
    Passenger passenger = new Passenger("P123", "John Doe", "US");

    boolean added = flight.addPassenger(passenger);

    assertTrue(added);
    assertEquals(1, flight.getNumberOfPassengers());
  }

  @Test
  void testAddPassengerExceedingCapacity() {
    Flight flight = new Flight("AA1234", 1);
    Passenger passenger1 = new Passenger("P123", "John Doe", "US");
    Passenger passenger2 = new Passenger("P124", "Jane Doe", "US");

    flight.addPassenger(passenger1);

    assertThrows(RuntimeException.class, () -> flight.addPassenger(passenger2));
  }

  @Test
  void testRemovePassenger() {
    Flight flight = new Flight("AA1234", 5);
    Passenger passenger = new Passenger("P123", "John Doe", "US");

    flight.addPassenger(passenger);
    boolean removed = flight.removePassenger(passenger);

    assertTrue(removed);
    assertEquals(0, flight.getNumberOfPassengers());
  }

  @Test
  void testRemovePassengerNotInFlight() {
    Flight flight = new Flight("AA1234", 5);
    Passenger passenger = new Passenger("P123", "John Doe", "US");

    boolean removed = flight.removePassenger(passenger);

    assertFalse(removed);
  }
}
