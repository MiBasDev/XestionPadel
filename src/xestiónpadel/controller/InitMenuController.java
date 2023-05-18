/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import xestiónpadel.db.PadelManagerDB;
import xestiónpadel.db.PlayerDB;
import xestiónpadel.model.DoubleBooking;
import xestiónpadel.view.InitMenuView;
import xestiónpadel.model.Player;
import xestiónpadel.model.PadelCourt;
import xestiónpadel.model.SingleBooking;
import xestiónpadel.view.SelectBookingJDialog;

/**
 * Clase que controla a aplicación.
 *
 * @author Miguel Bastos Gándara.
 */
public class InitMenuController {

    private InitMenuView view;

    /**
     * Constructor da clase InitMenuController.
     */
    public InitMenuController() {
        view = new InitMenuView(this);
    }

    /**
     * Método que inicia a aplicación.
     */
    public void initApp() {
        view.showLoginMenu();
    }

    /**
     * Método que logea a un xogador na aplicación.
     *
     * @param id Número de referencia do xogador.
     * @param password Contrasinal do xogador.
     */
    public void login(String id, String password) {
        if (PlayerDB.findByIdAndPassword(id, password) != null) {
            SessionController controller = new SessionController(PlayerDB.findByIdAndPassword(id, password));
            controller.loadSession();
        } else {
            view.showInvalidUser();
            view.showLoginMenu();
        }
    }

    /**
     * Método main.
     *
     * @param args
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectBookingJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectBookingJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectBookingJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectBookingJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // Creamos os datos de partida
        Player player1 = new Player("miguel", "123", "Miguel Bastos", 10, 310.50);
        Player player2 = new Player("bilinho", "123", "Bilinho dos Santos", 2.03, 70);
        PadelCourt court1 = new PadelCourt(1, PadelCourt.DOUBLE, new String[]{"9:00", "11:00", "13:00", "16:00"});
        PadelCourt court2 = new PadelCourt(2, PadelCourt.SINGLE, new String[]{"9:00", "11:00", "13:00", "16:00"});
        PadelCourt court3 = new PadelCourt(3, PadelCourt.DOUBLE, new String[]{"9:00", "11:00"});
        //Bookings
        SingleBooking booking1 = new SingleBooking(new SimpleDateFormat("dd/MM/yyyy").parse("10/03/2023"), "9:00", court2);
        DoubleBooking booking2 = new DoubleBooking(new SimpleDateFormat("dd/MM/yyyy").parse("10/03/2023"), "11:00", court1);
        DoubleBooking booking3 = new DoubleBooking(new SimpleDateFormat("dd/MM/yyyy").parse("10/03/2023"), "13:00", court3);
        // Engadimos os datos á base de datos
        PadelManagerDB.getPlayers().put(player1.getId(), player1);
        PadelManagerDB.getPlayers().put(player2.getId(), player2);
        PadelManagerDB.getCourts().add(court1);
        PadelManagerDB.getCourts().add(court2);
        PadelManagerDB.getCourts().add(court3);
        booking1.addPlayer(player1);
        booking2.addPlayer(player1, 1);
        //Bookings
        PadelManagerDB.getBookings().add(booking1);
        PadelManagerDB.getBookings().add(booking2);
        PadelManagerDB.getBookings().add(booking3);
        // Creamos un obxecto InitMenuController para iniciar a aplicacion
        InitMenuController imc = new InitMenuController();
        imc.initApp();
    }

}
