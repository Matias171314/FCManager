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
    private Team equipoLocal;
    private Team equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private String ubicacion;
    
    // Estadísticas adicionales
    private int tarjetasAmarillasLocal;
    private int tarjetasAmarillasVisitante;
    private int tarjetasRojasLocal;
    private int tarjetasRojasVisitante;
    private String comentarios;

    // Constructor
    public Match(String id, LocalDate fecha, Team equipoLocal, Team equipoVisitante, 
                int golesLocal, int golesVisitante, String ubicacion) {
        this.id = id;
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.ubicacion = ubicacion;
        this.tarjetasAmarillasLocal = 0; // Predeterminado
        this.tarjetasAmarillasVisitante = 0; // Predeterminado
        this.tarjetasRojasLocal = 0; // Predeterminado
        this.tarjetasRojasVisitante = 0; // Predeterminado
        this.comentarios = "";
    }

    // Métodos adicionales
    public String resumenPartido() {
        return "Partido: " + equipoLocal.getNombreEquipo() + " vs " + equipoVisitante.getNombreEquipo() + 
            "\nFecha: " + fecha +
            "\nResultado: " + golesLocal + " - " + golesVisitante + 
            "\nUbicación: " + ubicacion +
            "\nTarjetas Amarillas Local: " + tarjetasAmarillasLocal +
            "\nTarjetas Amarillas Visitante: " + tarjetasAmarillasVisitante +
            "\nTarjetas Rojas Local: " + tarjetasRojasLocal +
            "\nTarjetas Rojas Visitante: " + tarjetasRojasVisitante;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Team getEquipoLocal() {
        return equipoLocal;
    }

    public Team getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getTarjetasAmarillasLocal() {
        return tarjetasAmarillasLocal;
    }

    public int getTarjetasAmarillasVisitante() {
        return tarjetasAmarillasVisitante;
    }

    public int getTarjetasRojasLocal() {
        return tarjetasRojasLocal;
    }

    public int getTarjetasRojasVisitante() {
        return tarjetasRojasVisitante;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
