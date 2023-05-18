/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xestiónpadel.model;

/**
 * Clase que implementa un xogador.
 *
 * @author Miguel Bastos Gándara.
 */
public class Player {

    private String id;
    private String password;
    private String name;
    private double score;
    private double balance;

    /**
     * Constructor de clase Player.
     *
     * @param id Número identificador de xogador.
     * @param password Contrasinal do xogador.
     * @param name Nome do xogador.
     * @param score Puntuación que indica o nivel do xogador.
     * @param balance Saldo de cartos que ten o xogador.
     */
    public Player(String id, String password, String name, double score, double balance) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.score = score;
        this.balance = balance;
    }

    /**
     * Devolve o número identificador de xogador.
     *
     * @return Número identificador de xogador.
     */
    public String getId() {
        return id;
    }

    /**
     * Cambia o número identificador de xogador.
     *
     * @param id Número identificador de xogador.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Devolve o contrasinal do xogador.
     *
     * @return Contrasinal do xogador.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Cambia o contrasinal do xogador.
     *
     * @param password Contrasinal do xogador.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Devolve o nome do xogador.
     *
     * @return Nome do xogador.
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia o nome do xogador.
     *
     * @param name Nome do xogador.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devolve a puntuación que indica o nivel do xogador.
     *
     * @return Puntuación que indica o nivel do xogador.
     */
    public double getScore() {
        return score;
    }

    /**
     * Cambia a puntuación que indica o nivel do xogador.
     *
     * @param score Puntuación que indica o nivel do xogador.
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Devolve o saldo de cartos que ten o xogador.
     *
     * @return Saldo de cartos que ten o xogador.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Cambia o saldo de cartos que ten o xogador.
     *
     * @param balance Saldo de cartos que ten o xogador.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

}
