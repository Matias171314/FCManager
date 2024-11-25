/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matias.fcmanager.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author matin
 */
public class Team {
    // Atributos
    private String nombreEquipo;
    private LocalDate fundacion;
    private String estadio;
    private String ciudad;
    private String pais;
    private String liga;
    private List<Player> listajugadores;  // Lista de jugadores del equipo
    private List<Staff> listapersonal;   // Lista del personal del equipo
    private List<Match> partidos; // Lista de partidos del equipo

    // Constructor
    public Team(String nombreEquipo, LocalDate fundacion, String estadio, String ciudad, String pais, String liga) {
        this.nombreEquipo = nombreEquipo;
        this.fundacion = fundacion;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.pais = pais;
        this.liga = liga;
        this.listajugadores = new ArrayList<>();
        this.listapersonal = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    // Métodos para Lista de jugadores
    public void addPlayer(Player player) {
        listajugadores.add(player);
        System.out.println("Jugador añadido: " + player.getNombre() + " " + player.getApellido());
    }

    public void removePlayer(String playerId) {
        boolean removed = listajugadores.removeIf(player -> player.getId().equals(playerId));
        if (removed) {
            System.out.println("Jugador eliminado: ID " + playerId);
        } else {
            System.out.println("No se encontró un jugador con ID: " + playerId);
        }
    }

    // Métodos para Lista de personal
    public void addStaff(Staff staff) {
        listapersonal.add(staff);
        System.out.println("Miembro del personal añadido: " + staff.getNombre() + " " + staff.getApellido());
    }

    public void removeStaff(String staffId) {
        boolean removed = listapersonal.removeIf(staff -> staff.getId().equals(staffId));
        if (removed) {
            System.out.println("Miembro del personal eliminado: ID " + staffId);
        } else {
            System.out.println("No se encontró un miembro del personal con ID: " + staffId);
        }
    }

    // Métodos para Lista de partidos
    public void addMatch(Match match) {
        partidos.add(match);
        System.out.println("Partido añadido: " + match.getFecha());
    }
    
    public void removeMatch(String matchId) {
        boolean removed = partidos.removeIf(match -> match.getId().equals(matchId));
        if (removed) {
            System.out.println("Partido eliminado: ID " + matchId);
        } else {
            System.out.println("No se encontró un partido con ID: " + matchId);
        }
    }

    public String mostrarPartidos() {
        if (partidos.isEmpty()) {
            return "No hay partidos registrados.";
        }
        StringBuilder sb = new StringBuilder("Lista de partidos:\n");
        for (Match partido : partidos) {
            sb.append(partido).append("\n");
        }
        return sb.toString();
    }
    


    // Método para generar informe del equipo
    public String generarInforme() {
        StringBuilder informe = new StringBuilder();
        informe.append("=== Informe del Equipo ===\n");
        informe.append("Nombre del equipo: ").append(nombreEquipo).append("\n");
        informe.append("Fundación: ").append(fundacion).append("\n");
        informe.append("Estadio: ").append(estadio).append("\n");
        informe.append("Ciudad: ").append(ciudad).append("\n");
        informe.append("País: ").append(pais).append("\n");
        informe.append("Liga: ").append(liga).append("\n");
        informe.append("Número de jugadores: ").append(listajugadores.size()).append("\n");
        informe.append("Número de personal: ").append(listapersonal.size()).append("\n");

        informe.append("\n--- Lista de Jugadores ---\n");
        for (Player jugador : listajugadores) {
            informe.append("ID: ").append(jugador.getId())
                    .append(" | Nombre: ").append(jugador.getNombre()).append(" ").append(jugador.getApellido())
                    .append(" | Posición: ").append(jugador.getPosicion())
                    .append(" | Número: ").append(jugador.getNumeroCamiseta()).append("\n");
        }

        informe.append("\n--- Lista de Personal ---\n");
        for (Staff staff : listapersonal) {
            informe.append("ID: ").append(staff.getId())
                    .append(" | Nombre: ").append(staff.getNombre()).append(" ").append(staff.getApellido())
                    .append(" | Rol: ").append(staff.getRol()).append("\n");
        }

        return informe.toString();
    }

    // Getters y Setters
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public LocalDate getFundacion() {
        return fundacion;
    }

    public void setFundacion(LocalDate fundacion) {
        this.fundacion = fundacion;
    }

    public List<Player> getJugadores() {
        return listajugadores;
    }

    public List<Staff> getPersonal() {
        return listapersonal;
    }

    public List<Match> getPartidos() {
        return partidos;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getLiga() {
        return liga;
    }
}