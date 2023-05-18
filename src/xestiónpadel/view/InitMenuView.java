/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.view;

import java.util.Scanner;
import xestiónpadel.controller.InitMenuController;

/**
 * Clase que implementa a vista da aplicación.
 *
 * @author Miguel Bastos Gándara.
 */
public class InitMenuView {

    private InitMenuController controller;

    /**
     * Contructor de clase InitMenuView.
     *
     * @param controller Controlador do menu view.
     */
    public InitMenuView(InitMenuController controller) {
        this.controller = controller;
    }

    /**
     * Método que saca por pantalla unah mensaxe de usuario invalido.
     */
    public void showInvalidUser() {
        System.out.println("----- As credencias introducidas non son correctas -----");
        System.out.println("");
    }

    /**
     * Método que saca por pantalla o menú de login da aplicación.
     *
     * @return True si cerra sesión, false se non.
     */
    public boolean showLoginMenu() {
        Scanner scan = new Scanner(System.in);
        String id;
        String pass;
        do {
            System.out.println("Benvid@ ao xestor de reservas. Identificate para usar a aplicacion.");
            System.out.println("Introduce o Id de usuario: ");
            id = scan.nextLine();
            if (id.isEmpty()) {
                return true;
            } else {
                System.out.println("Introduce o teu contrasinal: ");
                pass = scan.nextLine();
                controller.login(id, pass);
            }
        } while (!id.isEmpty());
        return false;
    }
}
