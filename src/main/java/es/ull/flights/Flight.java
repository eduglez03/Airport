package es.ull.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.passengers.Passenger;

/**
 * @file Flight.java
 * @brief Representa un vuelo con su información básica y pasajeros asociados.
 *
 * Esta clase gestiona los datos de un vuelo, incluyendo su número de vuelo,
 * capacidad de asientos y la lista de pasajeros que contiene.
 */
public class Flight {

    /**
     * Número único que identifica al vuelo.
     */
    private String flightNumber;

    /**
     * Capacidad máxima de asientos del vuelo.
     */
    private int seats;

    /**
     * Conjunto de pasajeros registrados en el vuelo.
     */
    private Set<Passenger> passengers = new HashSet<>();

    /**
     * Expresión regular para validar el formato del número de vuelo.
     */
    private static String flightNumberRegex = "^[A-Z]{2}\\d{3,4}$";

    /**
     * Patrón precompilado para validar números de vuelo.
     */
    private static Pattern pattern = Pattern.compile(flightNumberRegex);

    /**
     * @brief Constructor de la clase Flight.
     *
     * Inicializa un vuelo con el número de vuelo y capacidad de asientos.
     *
     * @param flightNumber Número único del vuelo (debe seguir el formato "XX1234").
     * @param seats Número máximo de asientos del vuelo.
     *
     * @throw RuntimeException Si el número de vuelo no es válido.
     */
    public Flight(String flightNumber, int seats) {
        Matcher matcher = pattern.matcher(flightNumber);
        if (!matcher.matches()) {
            throw new RuntimeException("Invalid flight number");
        }
        this.flightNumber = flightNumber;
        this.seats = seats;
    }

    /**
     * @brief Obtiene el número del vuelo.
     *
     * @return Número único del vuelo.
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * @brief Obtiene el número de pasajeros actuales en el vuelo.
     *
     * @return Cantidad de pasajeros registrados en el vuelo.
     */
    public int getNumberOfPassengers() {
        return passengers.size();
    }

    /**
     * @brief Agrega un pasajero al vuelo.
     *
     * Registra un pasajero en el vuelo si hay asientos disponibles.
     *
     * @param passenger Instancia del pasajero que se desea agregar al vuelo.
     *
     * @return `true` si el pasajero fue agregado correctamente.
     *
     * @throw RuntimeException Si no hay suficientes asientos disponibles.
     */
    public boolean addPassenger(Passenger passenger) {
        if (getNumberOfPassengers() >= seats) {
            throw new RuntimeException("Not enough seats for flight " + getFlightNumber());
        }
        passenger.setFlight(this);
        return passengers.add(passenger);
    }

    /**
     * @brief Elimina un pasajero del vuelo.
     *
     * Remueve a un pasajero del vuelo y actualiza su estado.
     *
     * @param passenger Instancia del pasajero que se desea eliminar del vuelo.
     *
     * @return `true` si el pasajero fue eliminado correctamente.
     */
    public boolean removePassenger(Passenger passenger) {
        passenger.setFlight(null);
        return passengers.remove(passenger);
    }
}