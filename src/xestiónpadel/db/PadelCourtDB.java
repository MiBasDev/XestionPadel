/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.db;

import java.util.ArrayList;
import xestiónpadel.model.PadelCourt;

/**
 * Clase que mantén a persistencia das pistas de padel.
 *
 * @author Miguel Bastos Gándara.
 */
public class PadelCourtDB {

    /**
     * Método que devolve as pistas da aplicación.
     *
     * @return Pistas da aplicación.
     */
    public static ArrayList<PadelCourt> getAllCourts() {
        return PadelManagerDB.getCourts();
    }

}
