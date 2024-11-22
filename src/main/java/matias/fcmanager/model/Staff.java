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
}