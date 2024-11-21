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
public class Player {
    private String id; 
    private String nombre;
    private String apellido;
    private String posicion;
    private LocalDate fechaNacimiento;
    private int edad;
    private String nacionalidad;
    private int numeroCamiseta;
    private double altura;
    private double peso;

    // Estadísticas de rendimiento
    private int goles;
    private int asistencias;
    private int tarjetasAmarillas;
    private int tarjetasRojas;
    private int partidosJugados;
    private int minutosJugados;
    private double porcentajePases;
    private double tirosACampo;
    private int duelosGanados;

    // Constructor
    public Player(String nombre, String apellido, String posicion, LocalDate fechaNacimiento, int numeroCamiseta) {
        this.id = generarId(nombre, apellido);
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroCamiseta = numeroCamiseta;
        this.edad = calcularEdad();
        this.goles = 0;
        this.asistencias = 0;
        this.tarjetasAmarillas = 0;
        this.tarjetasRojas = 0;
        this.partidosJugados = 0;
        this.minutosJugados = 0;
    }

    // Métodos internos
    private int calcularEdad() {
        return LocalDate.now().getYear() - this.fechaNacimiento.getYear();
    }

    private String generarId(String nombre, String apellido) {
        String id = "";
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * 10);
            id += random;
        }
        return nombre.substring(0, 1) + apellido.substring(0, 1) + id;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        return calcularEdad();
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        if (numeroCamiseta > 0) {
            this.numeroCamiseta = numeroCamiseta;
        } else {
            throw new IllegalArgumentException("El número de camiseta debe ser positivo.");
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public double getPorcentajePases() {
        return porcentajePases;
    }

    public double getTirosACampo() {
        return tirosACampo;
    }

    public void setTirosACampo(double tirosACampo) {
        this.tirosACampo = tirosACampo;
    }

    public int getDuelosGanados() {
        return duelosGanados;
    }

    public void setDuelosGanados(int duelosGanados) {
        this.duelosGanados = duelosGanados;
    }
}
