package es.ull.passengers;

import java.util.Arrays;
import java.util.Locale;
import es.ull.flights.Flight;

/**
 * @file Passenger.java
 * @brief Representa un pasajero asociado a un vuelo.
 *
 * Esta clase gestiona la información de un pasajero, incluyendo su identificador, nombre,
 * código de país y el vuelo en el que está registrado.
 */
public class Passenger {

    /**
     * Identificador único del pasajero.
     */
    private String identifier;

    /**
     * Nombre del pasajero.
     */
    private String name;

    /**
     * Código de país ISO del pasajero.
     */
    private String countryCode;

    /**
     * Vuelo al que está asociado el pasajero.
     */
    private Flight flight;

    /**
     * @brief Constructor de la clase Passenger.
     *
     * Inicializa un nuevo pasajero con el identificador, nombre y código de país proporcionados.
     *
     * @param identifier Identificador único del pasajero.
     * @param name Nombre del pasajero.
     * @param countryCode Código de país ISO del pasajero.
     *
     * @throw RuntimeException Si el código de país no es válido.
     */
    public Passenger(String identifier, String name, String countryCode) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
            throw new RuntimeException("Invalid country code");
        }

        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    /**
     * @brief Obtiene el identificador del pasajero.
     *
     * @return Identificador único del pasajero.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @brief Obtiene el nombre del pasajero.
     *
     * @return Nombre del pasajero.
     */
    public String getName() {
        return name;
    }

    /**
     * @brief Obtiene el código de país del pasajero.
     *
     * @return Código de país ISO del pasajero.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @brief Obtiene el vuelo al que está asociado el pasajero.
     *
     * @return Instancia del vuelo al que está asociado el pasajero, o null si no tiene vuelo asignado.
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * @brief Asocia el pasajero a un vuelo.
     *
     * Si el pasajero ya estaba en otro vuelo, lo elimina de ese vuelo antes de asignarlo al nuevo.
     *
     * @param flight Vuelo al que se desea asociar el pasajero.
     *
     * @throw RuntimeException Si no se puede eliminar al pasajero de su vuelo anterior
     *                         o agregarlo al nuevo vuelo.
     */
    public void joinFlight(Flight flight) {
        Flight previousFlight = this.flight;
        if (null != previousFlight) {
            if (!previousFlight.removePassenger(this)) {
                throw new RuntimeException("Cannot remove passenger");
            }
        }
        setFlight(flight);
        if (null != flight) {
            if (!flight.addPassenger(this)) {
                throw new RuntimeException("Cannot add passenger");
            }
        }
    }


    /**
     * @brief Establece el vuelo asociado al pasajero.
     *
     * @param flight Vuelo al que se desea asociar el pasajero.
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * @brief Genera una representación en texto del pasajero.
     *
     * @return Una cadena que describe al pasajero, incluyendo su nombre, identificador y país.
     */
    @Override
    public String toString() {
        return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
    }
}

