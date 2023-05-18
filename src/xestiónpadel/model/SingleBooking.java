/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.model;

import java.util.Date;

/**
 * Clase que implementa unha reserva individual.
 *
 * @author Miguel Bastos Gándara.
 */
public class SingleBooking extends Booking {

    private Player[] players;

    /**
     * Constructor da clase SingleBooking.
     *
     * @param date Data da reserva.
     * @param hour Hora da reserva.
     * @param court Pista reservada.
     */
    public SingleBooking(Date date, String hour, PadelCourt court) {
        super(date, hour, court);
        this.players = new Player[2];
    }

    /**
     * Devolve os xogadores da reserva.
     *
     * @return Xogadores da reserva.
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Cambia os xogadores da reserva.
     *
     * @param players Xogadores da reserva.
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * Método que calcula o precio por xogador da pista.
     *
     * @return Precio por xogador.
     */
    @Override
    public double getPrice() {
        return 0;
    }

    /**
     * Método que comproba se a reserva está completa ou non.
     *
     * @return True si completa, false si non.
     */
    @Override
    public boolean isCompleted() {
        for (Player player : players) {
            if (player == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Método que comproba se un xogador está ou non nunha reserva.
     *
     * @param id Número identificador do xogador.
     * @return True si está na reserva, false se non.
     */
    @Override
    public boolean containsPlayer(String id) {
        for (Player player : players) {
            if ((player != null) && (player.getId().equals(id))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que xera un escrito cos datos da reserva.
     *
     * @return Escrito cos datos da reserva.
     */
    @Override
    public String getDescription() {
        String description = super.getDescription();
        description += "\n";
        description += "-> Xogadores: " + "\n";
        for (Player player : players) {
            if ((player != null) && (containsPlayer(player.getId()))) {
                description += player.getName() + " (" + player.getScore() + ") ";
            } else {
                description += " PENDENTE ";
            }
        }
        return description;
    }

    /**
     * Método que agrega un xogador a unha reserva.
     *
     * @param player Xogador a engadir.
     */
    public void addPlayer(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
                return;
            }
        }
    }

}
