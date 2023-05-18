/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.model;

import java.util.Date;

/**
 * Clase quue implementa unha reserva doble.
 *
 * @author Miguel Bastos Gándara.
 */
public class DoubleBooking extends Booking {

    private Player[][] teams;

    /**
     * Constructor da clase DoubleBooking.
     *
     * @param date Data da reserva.
     * @param hour Hora da reserva.
     * @param court Pista reservada.
     */
    public DoubleBooking(Date date, String hour, PadelCourt court) {
        super(date, hour, court);
        this.teams = new Player[2][2];
    }

    /**
     * Devolve os xogadores dos equipos da reserva.
     *
     * @return Xogadores dos equipos da reserva.
     */
    public Player[][] getTeams() {
        return teams;
    }

    /**
     * Cambia os xogadores dos equipos da reserva.
     *
     * @param teams Xogadores dos equipos da reserva.
     */
    public void setTeams(Player[][] teams) {
        this.teams = teams;
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
        for (Player[] team : teams) {
            for (Player player : team) {
                if (player == null) {
                    return false;
                }
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
        for (Player[] team : teams) {
            for (Player player : team) {
                if ((player != null) && (player.getId().equals(id))) {
                    return true;
                }
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
        description += "-> Xogadores: ";
        for (int i = 0; i < teams.length; i++) {
            description += "\n" + "Equipo " + (i + 1) + ":  ";
            for (int j = 0; j < teams.length; j++) {
                if ((teams[i][j] != null) && (containsPlayer(teams[i][j].getId()))) {
                    description += teams[i][j].getName() + " (" + teams[i][j].getScore() + ") ";
                } else {
                    description += "PENDENTE  ";
                }
            }
        }
        return description;
    }

    /**
     * Método que agrega un xogador a unha reserva.
     *
     * @param player Xogador a engadir.
     * @param teamNumber Número de equipo no que vai xogar.
     */
    public void addPlayer(Player player, int teamNumber) {
        for (int i = 0; i < teams.length; i++) {
            for (int j = 0; j < teams.length; j++) {
                if (teams[i][j] == null && (i + 1) == teamNumber) {
                    teams[i][j] = player;
                    return;
                }
            }
        }
    }

}
