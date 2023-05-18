/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import xestiónpadel.db.BookingDB;
import xestiónpadel.db.PadelCourtDB;
import xestiónpadel.db.PadelManagerDB;
import xestiónpadel.model.Booking;
import xestiónpadel.model.DoubleBooking;
import xestiónpadel.model.PadelCourt;
import xestiónpadel.model.Player;
import xestiónpadel.model.SingleBooking;
import xestiónpadel.view.SelectBookingJDialog;
import xestiónpadel.view.SessionView;

/**
 * Clase que implementa o controlador da sesión.
 *
 * @author Miguel Bastos Gándara, 50% beneficios para gorgue por caridad ;)
 */
public class SessionController {

    private SessionView view;
    private Player sessionPlayer;

    /**
     * Constructor da clase SessionController.
     *
     * @param sessionPlayer Controlador de sesión.
     */
    public SessionController(Player sessionPlayer) {
        this.sessionPlayer = sessionPlayer;
        view = new SessionView(this);
    }

    /**
     * Devolve o xogador de sesión actual.
     *
     * @return Xogador de sesión actual.
     */
    public Player getSessionPlayer() {
        return sessionPlayer;
    }

    /**
     * Cambia o xogador de sesión actual.
     *
     * @param sessionPlayer Xogador de sesión actual.
     */
    public void setSessionPlayer(Player sessionPlayer) {
        this.sessionPlayer = sessionPlayer;
    }

    /**
     * Método que recarga a sesión.
     */
    public void loadSession() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, 0);
        view.showSessionMenu(BookingDB.findByUserAndDate(sessionPlayer.getId(),
                c.getTime()));
    }

    /**
     * Método que crea unha reserva.
     *
     * @param date Data da reserva.
     */
    public void createBooking(Date date) {
        view.selectCourtAndHour(date, PadelCourtDB.getAllCourts(), BookingDB.findByDate(date));
    }

    /**
     * Método que completa unha reserva.
     *
     * @param date Data da reserva.
     * @param hour Hora da reserva.
     * @param court Pista da reserva.
     */
    public void completeBooking(Date date, String hour, PadelCourt court) {
        if (court.getType() == PadelCourt.SINGLE) {
            SingleBooking booking = new SingleBooking(date, hour, court);
            booking.addPlayer(sessionPlayer);
            BookingDB.save(booking);
        } else {
            DoubleBooking booking = new DoubleBooking(date, hour, court);
            booking.addPlayer(sessionPlayer, 1);
            BookingDB.save(booking);
        }
        loadSession();
    }

    /**
     * Método que engade un xogador a unha reserva.
     *
     * @param date Data da reserva.
     */
    public void addPlayerToBooking(Date date) {
        ArrayList<Booking> dayBookings = new ArrayList<>();
        for (Booking booking : PadelManagerDB.getBookings()) {
            if (booking.getDate().equals(date) && !booking.isCompleted()) {
                dayBookings.add(booking);
            }
        }
        SelectBookingJDialog dialog = new SelectBookingJDialog(null, true);
        Booking[] bookings = new Booking[dayBookings.size()];
        for (int i = 0; i < dayBookings.size(); i++) {
            bookings[i] = dayBookings.get(i);
        }
        dialog.setBookings(bookings);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        if (dialog.isActionAccepted()) {
            if (dialog.getSelectedBooking() != null && !dialog.getSelectedBooking().containsPlayer(sessionPlayer.getId())) {
                if (dialog.getSelectedBooking().getCourt().getType() == PadelCourt.DOUBLE) {
                    DoubleBooking doubleBooking = (DoubleBooking) dialog.getSelectedBooking();
                    doubleBooking.addPlayer(sessionPlayer, dialog.getSelectedTeam());
                } else {
                    SingleBooking singleBooking = (SingleBooking) dialog.getSelectedBooking();
                    singleBooking.addPlayer(sessionPlayer);
                }
            } else {
                System.out.println("");
                System.out.println("------- Xa estás apuntado nese partido -------");
            }
            BookingDB.update(dialog.getSelectedBooking());
        } else {
            System.out.println("");
            System.out.println("-------------- Acción cancelada --------------");
        }
        loadSession();
    }
}
