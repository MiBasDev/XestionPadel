/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.db;

import xestiónpadel.model.Player;

/**
 * Clase que mantén a persistencia dos xogadores.
 *
 * @author Miguel Bastos Gándara.
 */
public class PlayerDB {

    /**
     * Método que comproba que exista un xogador.
     *
     * @param id Número identificador do xogador.
     * @param password Contrasinal do xogador.
     * @return Xogador con esas credenciais.
     */
    public static Player findByIdAndPassword(String id, String password) {
        Player playerToFind = PadelManagerDB.getPlayers().get(id);
        if (playerToFind != null && playerToFind.getPassword().equals(password)) {
            return playerToFind;
        }
        return null;
    }
}
