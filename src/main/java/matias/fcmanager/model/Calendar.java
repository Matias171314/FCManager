/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matias.fcmanager.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matin
 */
public class Calendar {
    private List<Event> eventos;

    public Calendar() {
        this.eventos = new ArrayList<>();
    }

    // Agregar un evento al calendario
    public void agregarEvento(Event evento) {
        eventos.add(evento);
    }

    // Eliminar un evento por título
    public void eliminarEvento(String titulo) {
        eventos.removeIf(event -> event.getTitulo().equalsIgnoreCase(titulo));
    }

    // Listar todos los eventos
    public String mostrarEventos() {
        if (eventos.isEmpty()) {
            return "No hay eventos programados.";
        }
        StringBuilder sb = new StringBuilder("Eventos programados:\n");
        for (Event evento : eventos) {
            sb.append(evento.toString()).append("\n");
        }
        return sb.toString();
    }
}
