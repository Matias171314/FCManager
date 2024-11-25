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

public class Match {
    // Datos del partido
    private String id;
    private LocalDate fecha;
    private String equipoLocal;
    private String equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private String estadio;
    
    // Estadísticas adicionales
    private int tarjetasAmarillasLocal;
    private int tarjetasAmarillasVisitante;
    private int tarjetasRojasLocal;
    private int tarjetasRojasVisitante;
    private String comentarios;

    // Constructor
    public Match(String equipoLocal, String equipoVisitante, LocalDate fecha, 
                boolean enCasa, String estadio ,int golesLocal, int golesVisitante) {
        
        this.id = generarId(equipoLocal, equipoVisitante, fecha);
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.estadio = estadio;
        this.tarjetasAmarillasLocal = 0; // Predeterminado
        this.tarjetasAmarillasVisitante = 0; // Predeterminado
        this.tarjetasRojasLocal = 0; // Predeterminado
        this.tarjetasRojasVisitante = 0; // Predeterminado
        this.comentarios = "";
    }

    // Métodos
    private String generarId(String equipoLocal, String equipoVisitante, LocalDate fecha) {
        String id = "";
        return equipoLocal.substring(0, 1).toUpperCase() + "-" + equipoVisitante.substring(0, 1).toUpperCase() + fecha.toString();
    }

    // Resumen del partido
    public String resumenPartido() {
        return "Partido: " + equipoLocal + " vs " + equipoVisitante + 
            "\nFecha: " + fecha +
            "\nResultado: " + golesLocal + " - " + golesVisitante + 
            "\nUbicación: " + estadio +
            "\nTarjetas Amarillas Local: " + tarjetasAmarillasLocal +
            "\nTarjetas Amarillas Visitante: " + tarjetasAmarillasVisitante +
            "\nTarjetas Rojas Local: " + tarjetasRojasLocal +
            "\nTarjetas Rojas Visitante: " + tarjetasRojasVisitante +
            "\nComentarios: " + comentarios;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public String getEstadio() {
        return estadio;
    }

    public int getTarjetasAmarillasLocal() {
        return tarjetasAmarillasLocal;
    }

    public void setTarjetasAmarillasLocal(int tarjetasAmarillasLocal) {
        this.tarjetasAmarillasLocal = tarjetasAmarillasLocal;
    }

    public int getTarjetasAmarillasVisitante() {
        return tarjetasAmarillasVisitante;
    }

    public void setTarjetasAmarillasVisitante(int tarjetasAmarillasVisitante) {
        this.tarjetasAmarillasVisitante = tarjetasAmarillasVisitante;
    }

    public int getTarjetasRojasLocal() {
        return tarjetasRojasLocal;
    }

    public void setTarjetasRojasLocal(int tarjetasRojasLocal) {
        this.tarjetasRojasLocal = tarjetasRojasLocal;
    }

    public int getTarjetasRojasVisitante() {
        return tarjetasRojasVisitante;
    }

    public void setTarjetasRojasVisitante(int tarjetasRojasVisitante) {
        this.tarjetasRojasVisitante = tarjetasRojasVisitante;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return resumenPartido();
    }
}
