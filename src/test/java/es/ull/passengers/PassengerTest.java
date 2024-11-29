/**
 * @file PassengerTest.java
 * @brief Pruebas unitarias para la clase Passenger.
 *
 * Este archivo contiene pruebas para verificar el comportamiento de la clase Passenger,
 * incluyendo la inicialización, validación de datos y asociación con vuelos.
 */

package es.ull.passengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @class PassengerTest
 * @brief Clase para realizar pruebas unitarias sobre la clase Passenger.
 */
class PassengerTest {

  /**
   * @brief Prueba la inicialización de un pasajero.
   *
   * Verifica que un objeto Passenger se cree correctamente con los
   * valores proporcionados (identificador, nombre y código de país).
   */
  @Test
  void testPassengerInitialization() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    assertEquals("P123", passenger.getIdentifier());
    assertEquals("John Doe", passenger.getName());
    assertEquals("US", passenger.getCountryCode());
  }

  /**
   * @brief Prueba la validación del código de país de un pasajero.
   *
   * Verifica que se lance una excepción cuando se crea un objeto Passenger
   * con un código de país inválido.
   */
  @Test
  void testPassengerInvalidCountryCode() {
    assertThrows(RuntimeException.class, () -> new Passenger("P123", "John Doe", "XX"));
  }

  /**
   * @brief Prueba que un pasajero pueda unirse a un vuelo.
   *
   * Verifica que un pasajero se asocie correctamente a un vuelo y que
   * el número de pasajeros en el vuelo se actualice en consecuencia.
   */
  @Test
  void testJoinFlight() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    Flight flight = new Flight("AA1234", 5);

    passenger.joinFlight(flight);

    assertEquals(flight, passenger.getFlight());
    assertEquals(1, flight.getNumberOfPassengers());
  }

  /**
   * @brief Prueba que un pasajero pueda cambiar de vuelo.
   *
   * Verifica que un pasajero se transfiera correctamente de un vuelo a otro,
   * actualizando las asociaciones y el número de pasajeros en ambos vuelos.
   */
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

  /**
   * @brief Prueba el método `toString` de la clase Passenger.
   *
   * Verifica que la representación en cadena de un objeto Passenger sea
   * la esperada y contenga toda la información relevante.
   */
  @Test
  void testToString() {
    Passenger passenger = new Passenger("P123", "John Doe", "US");
    String expected = "Passenger John Doe with identifier: P123 from US";
    assertEquals(expected, passenger.toString());
  }
}
