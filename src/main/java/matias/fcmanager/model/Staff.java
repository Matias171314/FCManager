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
public class Staff {
    // Datos personales
    private String id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private int edad;
    private String nacionalidad;
    private double altura;
    private double peso;

    // Datos Contractuales
    private LocalDate fechaContratacion;
    private double salario;
    private String direccion;
    private String telefono;
    private String email;
    private String rol;
    private int experienciaAnios;

// Constructor
    public Staff(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String rol, LocalDate fechaContratacion, double salario) {
        this.id = generarId(nombre, apellido);
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad();
        this.nacionalidad = nacionalidad;
        this.rol = rol;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
        // Otros atributos inicializados por defecto
        this.altura = 0.0;
        this.peso = 0.0;
        this.direccion = "";
        this.telefono = "";
        this.email = "";
        this.experienciaAnios = calcularExperiencia();
    }

    private int calcularEdad() {
        return LocalDate.now().getYear() - this.fechaNacimiento.getYear();
    }

    private int calcularExperiencia() {
        return LocalDate.now().getYear() - this.fechaContratacion.getYear();
    }

    private String generarId(String nombre, String apellido) {
        String id = "";
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * 10);
            id += random;
        }
        return nombre.substring(0, 1).toUpperCase() + apellido.substring(0, 1).toUpperCase() + id;
    }

    public String generarInforme() {
        return "ID: " + id + "\n" +
            "Nombre: " + nombre + " " + apellido + "\n" +
            "Edad: " + edad + " años\n" +
            "Nacionalidad: " + nacionalidad + "\n" +
            "Rol: " + rol + "\n" +
            "Fecha de contratación: " + fechaContratacion + "\n" +
            "Salario: $" + salario + "\n" +
            "Años de experiencia: " + experienciaAnios + "\n";
    }

        // Getters y Setters
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
            this.edad = calcularEdad();
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
    
        public String getRol() {
            return rol;
        }
    
        public void setRol(String rol) {
            this.rol = rol;
        }
    
        public int getExperienciaAnios() {
            return experienciaAnios;
        }
    
        public void setExperienciaAnios(int experienciaAnios) {
            this.experienciaAnios = experienciaAnios;
        }
}