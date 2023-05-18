/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.db;

import java.util.ArrayList;
import java.util.HashMap;
import xestiónpadel.model.Booking;
import xestiónpadel.model.PadelCourt;
import xestiónpadel.model.Player;

/**
 * Clase que mantén a persistencia de todos os datos da aplicación.
 *
 * @author Miguel Bastos Gándara.
 */
public class PadelManagerDB {

    /**
     * Fai referenza aos xogadores de padel.
     */
    private static HashMap<String, Player> players = new HashMap<>();

    /**
     * Fai referenza ás pistas de padel.
     */
    private static ArrayList<PadelCourt> courts = new ArrayList<>();

    /**
     * Fai referenza ás reservas de pistas.
     */
    private static ArrayList<Booking> bookings = new ArrayList<>();

    /**
     * Devolve os xogadores de padel.
     *
     * @return Xogadores de padel.
     */
    public static HashMap<String, Player> getPlayers() {
        return players;
    }

    /**
     * Cambia os xogadores de padel.
     *
     * @param players Xogadores de padel.
     */
    public static void setPlayers(HashMap<String, Player> players) {
        PadelManagerDB.players = players;
    }

    /**
     * Devolve as pistas de padel.
     *
     * @return Pistas de padel.
     */
    public static ArrayList<PadelCourt> getCourts() {
        return courts;
    }

    /**
     * Cambia as pistas de padel.
     *
     * @param courts Pistas de padel.
     */
    public static void setCourts(ArrayList<PadelCourt> courts) {
        PadelManagerDB.courts = courts;
    }

    /**
     * Devolve as reservas de pistas.
     *
     * @return Reservas de pistas.
     */
    public static ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * Cambia as reservas de pistas.
     *
     * @param bookings Reservas de pistas.
     */
    public static void setBookings(ArrayList<Booking> bookings) {
        PadelManagerDB.bookings = bookings;
    }

}
