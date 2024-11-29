/**
 * @file FlightTest.java
 * @brief Pruebas unitarias para la clase Flight.
 *
 * Este archivo contiene pruebas para validar el comportamiento de la clase Flight,
 * incluyendo la inicialización, manejo de pasajeros, y la validación de capacidad.
 */

package es.ull.flights;

import es.ull.passengers.Passenger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @class FlightTest
 * @brief Clase para realizar pruebas unitarias sobre la clase Flight.
 */
class FlightTest {

  /**
   * @brief Prueba la inicialización de un vuelo.
   *
   * Verifica que el número de vuelo y el número inicial de pasajeros
   * sean correctos después de crear un objeto Flight.
   */
  @Test
  void testFlightInitialization() {
    Flight flight = new Flight("AA1234", 5);
    assertEquals("AA1234", flight.getFlightNumber());
    assertEquals(0, flight.getNumberOfPassengers());
  }

  /**
   * @brief Prueba la validación de un número de vuelo inválido.
   *
   * Verifica que se lance una excepción cuando el número de vuelo
   * no cumple con el formato esperado.
   */
  @Test
  void testInvalidFlightNumber() {
    assertThrows(RuntimeException.class, () -> new Flight("INVALID123", 5));
  }

  /**
   * @brief Prueba la adición de un pasajero a un vuelo.
   *
   * Verifica que se pueda agregar un pasajero correctamente y que el
   * número de pasajeros aumente en consecuencia.
   */
  @Test
  void testAddPassenger() {
    Flight flight = new Flight("AA1234", 5);
    Passenger passenger = new Passenger("P123", "John Doe", "US");

    boolean added = flight.addPassenger(passenger);

    assertTrue(added);
    assertEquals(1, flight.getNumberOfPassengers());
  }

  /**
   * @brief Prueba agregar un pasajero cuando se excede la capacidad.
   *
   * Verifica que se lance una excepción al intentar agregar un pasajero
   * a un vuelo que ya ha alcanzado su capacidad máxima.
   */
  @Test
  void testAddPassengerExceedingCapacity() {
    Flight flight = new Flight("AA1234", 1);
    Passenger passenger1 = new Passenger("P123", "John Doe", "US");
    Passenger passenger2 = new Passenger("P124", "Jane Doe", "US");

    flight.addPassenger(passenger1);

    assertThrows(RuntimeException.class, () -> flight.addPassenger(passenger2));
  }

  /**
   * @brief Prueba la eliminación de un pasajero de un vuelo.
   *
   * Verifica que se pueda eliminar un pasajero registrado en el vuelo y
   * que el número de pasajeros disminuya correctamente.
   */
  @Test
  void testRemovePassenger() {
    Flight flight = new Flight("AA1234", 5);
    Passenger passenger = new Passenger("P123", "John Doe", "US");

    flight.addPassenger(passenger);
    boolean removed = flight.removePassenger(passenger);

    assertTrue(removed);
    assertEquals(0, flight.getNumberOfPassengers());
  }

  /**
   * @brief Prueba la eliminación de un pasajero que no está en el vuelo.
   *
   * Verifica que intentar eliminar un pasajero no registrado en el vuelo
   * no afecte al estado del vuelo y retorne `false`.
   */
  @Test
  void testRemovePassengerNotInFlight() {
    Flight flight = new Flight("AA1234", 5);
    Passenger passenger = new Passenger("P123", "John Doe", "US");

    boolean removed = flight.removePassenger(passenger);

    assertFalse(removed);
  }
}
