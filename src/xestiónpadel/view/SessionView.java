/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import xestiónpadel.controller.SessionController;
import xestiónpadel.model.Booking;
import xestiónpadel.model.PadelCourt;

/**
 * Clase que implementa a vista de sesión.
 *
 * @author Miguel Bastos Gándara.
 */
public class SessionView {

    private SessionController controller;

    /**
     * Constructor da clase SessionView.
     *
     * @param controller Controlador da sesión
     */
    public SessionView(SessionController controller) {
        this.controller = controller;
    }

    /**
     * Méotodo que saca por pantalla o menú da sesión.
     *
     * @param bookings Reservas nas que está inscrita o xogador.
     */
    public void showSessionMenu(ArrayList<Booking> bookings) {
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Benvid@, " + controller.getSessionPlayer().getName());
        System.out.println("Saldo dispoñible: " + controller.getSessionPlayer().getBalance() + "€");
        System.out.println("+ As túas reservas: ");
        if (!bookings.isEmpty()) {
            System.out.println("-------------------------------------------");
        }
        for (Booking booking : bookings) {
            System.out.println(booking.getDescription());
            System.out.println("-------------------------------------------");
        }
        int choice;
        do {
            System.out.println("");
            System.out.println("Que queres facer?");
            System.out.println("1. Crear unha reserva para un partido");
            System.out.println("2. Apuntarme a un partido");
            System.out.println("3. Pechar a sesión");
            choice = scan.nextInt();
            scan.nextLine();
            Date date = null;
            if (choice == 1 || choice == 2) {
                System.out.println("Introduce a data para o partido (dd/mm/yyyy)");
                do {
                    try {
                        date = new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());
                    } catch (ParseException e) {
                        System.out.println("Esa non é unha data válida");
                    }
                } while (date == null);
            }
            switch (choice) {
                case 1:
                    controller.createBooking(date);
                    break;
                case 2:
                    controller.addPlayerToBooking(date);
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Ata a vista!");
                    System.out.println("");
                    break;
                default:
                    System.out.println("");
                    System.out.println("Opción non permitida");
            }
        } while (choice <= 0 || choice > 3);
    }

    /**
     * Método que saca por pantalla o menú de selección de pista e hora.
     *
     * @param date Data da reserva.
     * @param courts Pistas dispoñibles.
     * @param bookings Reservas para ese día.
     */
    public void selectCourtAndHour(Date date, ArrayList<PadelCourt> courts, ArrayList<Booking> bookings) {
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Estas son as horas dispoñibles para a data seleccionada: ");
        for (PadelCourt court : courts) {
            System.out.print("-> Pista " + court.getNumber());
            if (court.getType() == PadelCourt.SINGLE) {
                System.out.print(" (INDIVIDUAL)");
            }
            System.out.println("");
            System.out.print("Horas dispoñibles: ");
            for (String bookingHour : court.getBookingHours()) {
                boolean isReserved = false;
                for (int i = 0; i < bookings.size(); i++) {
                    if (bookingHour.equals(bookings.get(i).getHour())
                            && court.getNumber() == bookings.get(i).getCourt().getNumber()) {
                        isReserved = true;
                    }
                }
                if (!isReserved) {
                    System.out.print(bookingHour + " ");
                }
            }
            System.out.println("");
            System.out.println("------------------------------------------");
        }
        int courtNumber = 0;
        do {
            System.out.println("Indica o número de pista: ");
            courtNumber = scan.nextInt();
            scan.nextLine();
        } while (courtNumber <= 0 || courtNumber >= (courts.size() + 1));
        System.out.println("Indica a hora que desexas reservar: ");
        String hourBook = scan.nextLine();
        System.out.println("");
        controller.completeBooking(date, hourBook, courts.get(courtNumber - 1));
    }

}
