/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package matias.fcmanager;

import java.time.LocalDate;
import java.util.Scanner;
import matias.fcmanager.model.Player;
import matias.fcmanager.model.Staff;
import matias.fcmanager.model.Team;

/**
 *
 * @author matin
 */

// Funcionando Actualmente:
// Se pueden registrar jugadores y personal del equipo y ver el equipo completo con sus respectivos datos relevantes

// Siguiente Actualización:
// Creada Clase Match, que permite registrar partidos y ver los partidos jugados (aún no implementado en el main)
// Puedes permitir a los usuarios registrar partidos, con detalles estadísticos.
// Actualizar el Main para Incluir los Partidos

// Futuras Actualizaciones:
// Clase Calendar y Clase Finance proximamente...
// Almacenar los datos en una base de datos proximamente...

public class FCManager {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Team equipo = new Team("Independiente San Felipe", LocalDate.of(1987, 10, 15), "Ricardo Palma", "Lima", "Peru", "Liga Distrital de Carabayllo");
        
        while (true) {
            System.out.println("\n--- Menu FCManager ---");
            System.out.println("1. Registrar jugador");
            System.out.println("2. Registrar personal");
            System.out.println("3. Ver equipo completo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea restante

            switch (opcion) {
                case 1:
                    // Lógica para registrar jugador
                    System.out.println("Ingrese el nombre del jugador: ");
                    String jugador_nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del jugador: ");
                    String jugador_apellido = scanner.nextLine();
                    System.out.println("Ingrese la fecha de nacimiento del jugador (yyyy-mm-dd): ");
                    String jugador_fechaNacimientoInput = scanner.nextLine();
                    LocalDate jugador_fechaNacimiento = validarFecha(jugador_fechaNacimientoInput);

                    System.out.println("Ingrese la nacionalidad del jugador: ");
                    String jugador_nacionalidad = scanner.nextLine();
                    System.out.println("Ingrese la posición del jugador: ");
                    String jugador_posicion = scanner.nextLine();
                    System.out.println("Ingrese el número de camiseta del jugador: ");
                    int jugador_numeroCamiseta = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea restante
                    System.out.println("Ingrese la fecha de inicio del contrato del jugador (yyyy-mm-dd): ");
                    String jugador_fechaInicioContratoInput = scanner.nextLine();
                    LocalDate jugador_fechaInicioContrato = validarFecha(jugador_fechaInicioContratoInput);

                    System.out.println("Ingrese el salario del jugador: ");
                    double jugador_salario = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea restante

                    // Crear jugador
                    Player jugador = new Player(
                        jugador_nombre,
                        jugador_apellido,
                        jugador_posicion,
                        jugador_fechaNacimiento,
                        jugador_nacionalidad,
                        jugador_numeroCamiseta,
                        jugador_fechaInicioContrato,
                        jugador_salario
                    );
                    
                    equipo.addPlayer(jugador);
                    break;

                case 2:
                    // Lógica para registrar personal
                    System.out.println("Ingrese el nombre del personal: ");
                    String personal_nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del personal: ");
                    String personal_apellido = scanner.nextLine();
                    System.out.println("Ingrese la fecha de nacimiento del personal (yyyy-mm-dd): ");
                    String personal_fechaNacimientoInput = scanner.nextLine();
                    LocalDate personal_fechaNacimiento = validarFecha(personal_fechaNacimientoInput);

                    System.out.println("Ingrese la nacionalidad del personal: ");
                    String personal_nacionalidad = scanner.nextLine();
                    System.out.println("Ingrese el rol del personal: ");
                    String personal_rol = scanner.nextLine();
                    System.out.println("Ingrese la fecha de inicio del contrato del personal (yyyy-mm-dd): ");
                    String personal_fechaInicioContratoInput = scanner.nextLine();
                    LocalDate personal_fechaInicioContrato = validarFecha(personal_fechaInicioContratoInput);

                    System.out.println("Ingrese el salario del personal: ");
                    double personal_salario = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea restante

                    // Crear personal
                    Staff personal = new Staff(
                        personal_nombre,
                        personal_apellido,
                        personal_fechaNacimiento,
                        personal_nacionalidad,
                        personal_rol,
                        personal_fechaInicioContrato,
                        personal_salario
                    );
                    
                    equipo.addStaff(personal);
                    break;

                case 3:
                    // Mostrar equipo
                    System.out.println(equipo.generarInforme());
                    break;

                case 4:
                    System.out.println("Saliendo de FCManager...");
                    return;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    // Método para validar fechas puede estar en una clase utilitaria
    private static LocalDate validarFecha(String fechaInput) {
        try {
            return LocalDate.parse(fechaInput);
        } catch (Exception e) {
            System.out.println("Fecha no válida. Intente de nuevo.");
            return null;
        }
    }
}