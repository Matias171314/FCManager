/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package matias.fcmanager;

import java.time.LocalDate;
import java.util.Scanner;
import matias.fcmanager.model.Player;

/**
 *
 * @author matin
 */

// Funcionando Actualmente:
// Probador de Clase Player - Funciona bien el registro del jugador de forma inicial, el generar informe como prueba tambien funciona.

// Pendiente Siguiente Actualización:
// Siguiente paso sería terminar la clase Staff y el resgistro del staff de la misma manera que el del jugador
// Implementar la clase Team y hacer que el jugador pertenezca al equipo
// Se supone que los jugadores al ser registrado ya pertenecen al equipo, pero la clase Team deberia anlinear los jugadores en lista de titulares y suplentes
// 11 titulares y 7 suplentes (o 9 y 7, dependiendo de la liga (esto se debe configurar según sea el caso de las normas de liga))
// Debe haber un metodo que permita cambiar un jugador de titular a suplente y viceversa (gets y sets)
// Habrá distintas formas de alinear un equipo (4-4-2, 4-3-3, 3-5-2, etc) y se debe poder cambiar la alineación en cualquier momento

public class FCManager {

    public static void main(String[] args) {
        System.out.println("Bienvenido a FCManager");
        System.out.println("Generando informe de jugador...");

        Scanner scanner = new Scanner(System.in);

        // Captura de datos
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del jugador: ");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del jugador (yyyy-mm-dd): ");
        String fechaNacimientoInput = scanner.next();
        LocalDate fechaNacimiento = validarFecha(fechaNacimientoInput);

        System.out.println("Ingrese la nacionalidad del jugador: ");
        scanner.nextLine(); // Consumir salto de línea
        String nacionalidad = scanner.nextLine();
        System.out.println("Ingrese la posición del jugador: ");
        String posicion = scanner.nextLine();
        System.out.println("Ingrese el número de camiseta del jugador: ");
        int numeroCamiseta = scanner.nextInt();
        System.out.println("Ingrese la fecha de inicio del contrato del jugador (yyyy-mm-dd): ");
        String fechaInicioContratoInput = scanner.next();
        LocalDate fechaInicioContrato = validarFecha(fechaInicioContratoInput);

        System.out.println("Ingrese el salario del jugador: ");
        double salario = scanner.nextDouble();

        // Crear jugador
        Player jugador = new Player(
            nombre,
            apellido,
            posicion,
            fechaNacimiento,
            nacionalidad,
            numeroCamiseta,
            fechaInicioContrato,
            salario
        );

        // Mostrar informe
        System.out.println(jugador.generarInforme());

        // Cerrar scanner
        scanner.close();
    }

    // Método para validar fechas puede estar en una clase utilitaria (proximamente)
    private static LocalDate validarFecha(String fechaInput) {
        try {
            return LocalDate.parse(fechaInput);
        } catch (Exception e) {
            System.out.println("Fecha no válida. Intente de nuevo.");
            throw e; // Re-lanzar para manejo externo
        }
    }
}
