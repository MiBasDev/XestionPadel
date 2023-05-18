/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.model;

/**
 * Clase que implementa unha pista de padel.
 *
 * @author Miguel Bastos Gándara.
 */
public class PadelCourt {

    private int number;
    private int type;
    private String[] bookingHours;

    /**
     * Fai referencia ao tipo de pista individual.
     */
    public static final int SINGLE = 1;

    /**
     * Fai referencia ao tipo de pista dobre.
     */
    public static final int DOUBLE = 2;

    /**
     * Constructor da clase PadelCourt.
     *
     * @param number Número de pista.
     * @param type Tipo de pista.
     * @param bookingHours Horas nas que se pode reservar a pista.
     */
    public PadelCourt(int number, int type, String[] bookingHours) {
        this.number = number;
        this.type = type;
        this.bookingHours = bookingHours;
    }

    /**
     * Devolve o número de pista.
     *
     * @return Número de pista.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Cambia o número de pista.
     *
     * @param number Número de pista.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Devolve o tipo de pista.
     *
     * @return Tipo de pista.
     */
    public int getType() {
        return type;
    }

    /**
     * Cambia o tipo de pista.
     *
     * @param type Tipo de pista.
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Devolve as horas nas que se pode reservar a pista.
     *
     * @return Horas nas que se pode reservar a pista.
     */
    public String[] getBookingHours() {
        return bookingHours;
    }

    /**
     * Cambia a horas nas que se pode reservar a pista.
     *
     * @param bookingHours Horas nas que se pode reservar a pista.
     */
    public void setBookingHours(String[] bookingHours) {
        this.bookingHours = bookingHours;
    }

}
