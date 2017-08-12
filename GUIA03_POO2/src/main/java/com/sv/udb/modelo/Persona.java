/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author walte
 */
public class Persona {
    int codiPers;
    String nombPers, apelPers, mailPers;

    public Persona(int codiPers, String nombPers, String apelPers, String mailPers) {
        this.codiPers = codiPers;
        this.nombPers = nombPers;
        this.apelPers = apelPers;
        this.mailPers = mailPers;
    }

    public Persona() {
    }

    public int getCodiPers() {
        return codiPers;
    }

    public void setCodiPers(int codiPers) {
        this.codiPers = codiPers;
    }

    public String getNombPers() {
        return nombPers;
    }

    public void setNombPers(String nombPers) {
        this.nombPers = nombPers;
    }

    public String getApelPers() {
        return apelPers;
    }

    public void setApelPers(String apelPers) {
        this.apelPers = apelPers;
    }

    public String getMailPers() {
        return mailPers;
    }

    public void setMailPers(String mailPers) {
        this.mailPers = mailPers;
    }

    @Override
    public String toString() {
        return nombPers;
    }
    
}
