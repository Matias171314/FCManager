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
    // Datos personales
    private String id; 
    private String nombre;
    private String apellido;
    private String apodo; // Opcional
    private LocalDate fechaNacimiento;
    private int edad;
    private String nacionalidad;
    private double altura;
    private double peso;
    private boolean lesionado; // Indica si está lesionado
    private String tipoLesion; // Descripción de la lesión
    private LocalDate fechaRecuperacion; // Fecha estimada de recuperación
    private String rutaFoto; // Ruta a la imagen del jugador

    // Datos contractuales
    private LocalDate fechaContratacion;
    private LocalDate fechaFinContrato; // Fecha de fin del contrato
    private double salario;
    private double clausulaRescision; // Cláusula de rescisión
    private String direccion;
    private String telefono;
    private String email;
    private String representante; // Agente del jugador

    // Estadísticas de rendimiento
    private String posicion;
    private int numeroCamiseta;
    private int goles;
    private int asistencias;
    private int tarjetasAmarillas;
    private int tarjetasRojas;
    private int partidosJugados;
    private int minutosJugados;
    private double porcentajePases;
    private double tirosACampo;
    private int duelosGanados;
    private int balonesRecuperados; // Nuevas métricas
    private double porcentajeDisparosAlArco;
    private double porcentajeRegatesExitosos;

    // Estadísticas avanzadas
    private int golesEsperados; // xG
    private int asistenciasEsperadas; // xA
    private double precisionDefensiva;

    // Metadatos del jugador
    private LocalDate fechaUltimaActualizacion;
    private boolean activo; // Indica si sigue en el equipo


// Constructor para registrar un jugador
public Player(String nombre, String apellido, String posicion, LocalDate fechaNacimiento, String nacionalidad, int numeroCamiseta, LocalDate fechaContratacion, double salario) {
    this.id = generarId(nombre, apellido);
    this.nombre = nombre;
    this.apellido = apellido;
    this.posicion = posicion;
    this.fechaNacimiento = fechaNacimiento;
    this.nacionalidad = nacionalidad;
    this.numeroCamiseta = numeroCamiseta;
    this.fechaContratacion = fechaContratacion;
    this.salario = salario;
    this.edad = calcularEdad(); // Calculada automáticamente

    // Inicialización de otros atributos con valores predeterminados, se llenará posteriormente o modificar
    this.altura = 0.0;
    this.peso = 0.0;
    this.direccion = "";
    this.telefono = "";
    this.email = "";

    this.goles = 0;
    this.asistencias = 0;
    this.tarjetasAmarillas = 0;
    this.tarjetasRojas = 0;
    this.partidosJugados = 0;
    this.minutosJugados = 0;
    this.porcentajePases = 0.0;
    this.tirosACampo = 0.0;
    this.duelosGanados = 0;
    this.golesEsperados = 0;
    this.asistenciasEsperadas = 0;
    this.porcentajeDisparosAlArco = 0.0;
    this.porcentajeRegatesExitosos = 0.0;
    this.balonesRecuperados = 0;
    this.precisionDefensiva = 0.0;

    this.fechaUltimaActualizacion = LocalDate.now(); // La fecha actual
    this.activo = true; // Por defecto, el jugador está activo
    }

    // Métodos
    private int calcularEdad() {
        return LocalDate.now().getYear() - this.fechaNacimiento.getYear();
    }    

    private String generarId(String nombre, String apellido) {
        String id = "";
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * 10);
            id += random;
        }
        return nombre.substring(0, 1).toUpperCase() + apellido.substring(0, 1).toUpperCase() + id;
    }

    public double calcularPromedioMinutosPorPartido() {
        if (partidosJugados == 0) return 0;
        return (double) minutosJugados / partidosJugados;
    }

    public double calcularGolesPorPartido() {
        if (partidosJugados == 0) return 0;
        return (double) goles / partidosJugados;
    }

    public String calcularEfectividadPases() {
        return String.format("%.2f%%", porcentajePases * 100);
    }

    public String calcularPrecisionTiros() {
        return String.format("%.2f%%", tirosACampo * 100);
    }    

    public void registrarPartido(int minutosJugados, int goles, int asistencias, int tarjetasAmarillas, int tarjetasRojas) {
        this.partidosJugados++;
        this.minutosJugados += minutosJugados;
        this.goles += goles;
        this.asistencias += asistencias;
        this.tarjetasAmarillas += tarjetasAmarillas;
        this.tarjetasRojas += tarjetasRojas;
    
        // Actualizamos la última fecha de modificación
        actualizarFechaUltimaActualizacion();
    }

    public void cambiarEstado(boolean activo) {
        this.activo = activo;
        actualizarFechaUltimaActualizacion();
    }

    public String mostrarInformacion() {
        return String.format(
            "ID: %s\nNombre: %s %s\nPosición: %s\nNacionalidad: %s\nNúmero de camiseta: %d\nEdad: %d\nAltura: %.2f m\nPeso: %.2f kg\nEstado: %s\n",
            id, nombre, apellido, posicion, nacionalidad, numeroCamiseta, edad, altura, peso, (activo ? "Activo" : "Inactivo")
        );
    }
    
    public String mostrarEstadisticas() {
        return String.format(
            "Partidos Jugados: %d\nMinutos Jugados: %d\nGoles: %d\nAsistencias: %d\nTarjetas Amarillas: %d\nTarjetas Rojas: %d\nPorcentaje de Pases: %.2f%%\nDuelos Ganados: %d\n",
            partidosJugados, minutosJugados, goles, asistencias, tarjetasAmarillas, tarjetasRojas, porcentajePases * 100, duelosGanados
        );
    }    

    public boolean validarEmail() {
        return email != null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    public boolean validarTelefono() {
        return telefono != null && telefono.matches("\\+?[0-9]{7,15}");
    }
    

    public int compararRendimiento(Player otroJugador) {
        // Compara por goles
        return Integer.compare(this.goles, otroJugador.getGoles());
    }

    public String generarInforme() {
        return mostrarInformacion() + "\n" + mostrarEstadisticas();
    }    

    private void actualizarFechaUltimaActualizacion() {
        this.fechaUltimaActualizacion = LocalDate.now();
    }

    // Getters y Setters para datos personales
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad(); // Recalcula la edad
    }

    public int getEdad() {
        return edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    // Getters y Setters para datos contractuales
    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters y Setters para estadísticas de rendimiento
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
        actualizarFechaUltimaActualizacion();
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
        actualizarFechaUltimaActualizacion();
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
        actualizarFechaUltimaActualizacion();
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
        actualizarFechaUltimaActualizacion();
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
        actualizarFechaUltimaActualizacion();
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
        actualizarFechaUltimaActualizacion();
    }

    public double getPorcentajePases() {
        return porcentajePases;
    }

    public void setPorcentajePases(double porcentajePases) {
        this.porcentajePases = porcentajePases;
        actualizarFechaUltimaActualizacion();
    }

    public double getTirosACampo() {
        return tirosACampo;
    }

    public void setTirosACampo(double tirosACampo) {
        this.tirosACampo = tirosACampo;
        actualizarFechaUltimaActualizacion();
    }

    public int getDuelosGanados() {
        return duelosGanados;
    }

    public void setDuelosGanados(int duelosGanados) {
        this.duelosGanados = duelosGanados;
        actualizarFechaUltimaActualizacion();
    }

    // Getters y Setters para atributos adicionales
    public LocalDate getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}