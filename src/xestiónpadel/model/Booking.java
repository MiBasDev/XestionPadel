/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que implementa unha reserva.
 *
 * @author Miguel Bastos Gándara.
 */
public abstract class Booking {

    /**
     * Fai referencia á data da reserva.
     */
    protected Date date;

    /**
     * Fai referencia á hora da reserva.
     */
    protected String hour;

    /**
     * Fai referencia á pista reservada.
     */
    protected PadelCourt court;

    /**
     * Constructor da clase Booking.
     *
     * @param date Data da reserva.
     * @param hour Hora da reserva.
     * @param court Pista reservada.
     */
    public Booking(Date date, String hour, PadelCourt court) {
        this.date = date;
        this.hour = hour;
        this.court = court;
    }

    /**
     * Devolve a data da reserva.
     *
     * @return Data da reserva.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Cambia a data da reserva.
     *
     * @param date Data da reserva.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Devolve a hora da reserva.
     *
     * @return Hora da reserva.
     */
    public String getHour() {
        return hour;
    }

    /**
     * Cambia a hora da reserva.
     *
     * @param hour Hora da reserva.
     */
    public void setHour(String hour) {
        this.hour = hour;
    }

    /**
     * Devolve a pista reservada.
     *
     * @return Pista reservada.
     */
    public PadelCourt getCourt() {
        return court;
    }

    /**
     * Cambia a pista reservada.
     *
     * @param court Pista reservada.
     */
    public void setCourt(PadelCourt court) {
        this.court = court;
    }

    /**
     * Método que calcula o precio por xogador da pista.
     *
     * @return Precio por xogador.
     */
    public abstract double getPrice();

    /**
     * Método que comproba se a reserva está completa ou non.
     *
     * @return True si completa, false si non.
     */
    public abstract boolean isCompleted();

    /**
     * Método que comproba se un xogador está ou non nunha reserva.
     *
     * @param id Número identificador do xogador.
     * @return True si está na reserva, false se non.
     */
    public abstract boolean containsPlayer(String id);

    /**
     * Método que xera un escrito cos datos da reserva.
     *
     * @return Escrito cos datos da reserva.
     */
    public String getDescription() {
        String description = "";
        if (!isCompleted()) {
            description += "Reserva pendente: ";
        } else {
            description += "Reserva completa: ";
        }
        description += "\n";
        description += "Data: " + new SimpleDateFormat("dd/MM/yyyy").format(date) + " // Hora: " + hour + " // Pista " + court.getNumber();
        return description;
    }
}
