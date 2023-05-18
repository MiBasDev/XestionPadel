/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.db;

import java.util.ArrayList;
import java.util.Date;
import xestiónpadel.model.Booking;

/**
 * Clase que mantén a persistencia das reservas de pistas de padel.
 *
 * @author Miguel Bastos Gándara.
 */
public class BookingDB {

    /**
     * Método que busca no array de bookings as que coincidan coa fecha dada.
     *
     * @param date Fecha a buscar.
     * @return Arraylist de reservas.
     */
    public static ArrayList<Booking> findByDate(Date date) {
        ArrayList<Booking> bookings = new ArrayList<>();
        for (Booking booking : PadelManagerDB.getBookings()) {
            if (date.compareTo(booking.getDate()) == 0) {
                bookings.add(booking);
            }
        }
        return bookings;
    }

    /**
     * Método que busca as reservas dun xogador e as suas datas.
     *
     * @param id Número de referencia do xogador.
     * @param date Data da reserva.
     * @return Reservas a partir de esa fecha.
     */
    public static ArrayList<Booking> findByUserAndDate(String id, Date date) {
        ArrayList<Booking> bookings = new ArrayList<>();
        for (Booking booking : PadelManagerDB.getBookings()) {
            if (date.compareTo(booking.getDate()) <= 0 && booking.containsPlayer(id)) {
                bookings.add(booking);
            }
        }
        return bookings;
    }

    /**
     * Método que guarda unha reserva no arraylist de reservas.
     *
     * @param booking Reserva a almacenar.
     */
    public static void save(Booking booking) {
        PadelManagerDB.getBookings().add(booking);
    }

    /**
     * Método que actualiza a reserva na base de datos.
     *
     * @param booking Reserva a actualizar.
     */
    public static void update(Booking booking) {

    }

}
