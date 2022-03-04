/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author visitante
 */
public class Maestro {
    int id_maestro;
    String nombre_maestro;
    String pago_maestro;

    public Maestro(int id_maestro) {
        this.id_maestro = id_maestro;
    }

    public Maestro() {
    }

    public Maestro(String nombre_maestro, int id_maestro, String pago_maestro) {
        this.nombre_maestro = nombre_maestro;
        this.id_maestro = id_maestro;
        this.pago_maestro = pago_maestro;
    }

    public int getId_maestro() {
        return id_maestro;
    }

    public void setId_maestro(int id_maestro) {
        this.id_maestro = id_maestro;
    }

    public String getNombreMaestro() {
        return nombre_maestro;
    }

    public void setNombreMaestro(String nombre_maestro) {
        this.nombre_maestro = nombre_maestro;
    }

    public String getPago() {
        return pago_maestro;
    }

    public void setPago(String pago_maestro) {
        this.pago_maestro = pago_maestro;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id-maestro=" + id_maestro + ", nombre-maestro=" + nombre_maestro + ", pago-maestro=" +pago_maestro + '}';
    }
    

}