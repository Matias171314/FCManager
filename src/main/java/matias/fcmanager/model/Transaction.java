/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matias.fcmanager.model;

import java.time.LocalDate;

/**
 *
 * @author matin
 */
public class Transaction {
    private String descripcion;
    private LocalDate fecha;
    private double monto;
    private boolean esIngreso; // true = ingreso, false = egreso

    public Transaction(String descripcion, LocalDate fecha, double monto, boolean esIngreso) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.monto = monto;
        this.esIngreso = esIngreso;
    }

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isEsIngreso() {
        return esIngreso;
    }

    public void setEsIngreso(boolean esIngreso) {
        this.esIngreso = esIngreso;
    }   


    @Override
    public String toString() {
        return (esIngreso ? "Ingreso" : "Egreso") + ": " + descripcion + " - " + monto + "€ (" + fecha + ")";
    }
}
