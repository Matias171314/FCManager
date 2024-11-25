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
public class Finance {
    private List<Transaction> transacciones;

    public Finance() {
        this.transacciones = new ArrayList<>();
    }

    // Registrar una transacción
    public void registrarTransaccion(Transaction transaccion) {
        transacciones.add(transaccion);
    }

    // Generar un reporte financiero
    public String generarReporte() {
        double totalIngresos = transacciones.stream()
                .filter(t -> t.isEsIngreso())
                .mapToDouble(Transaction::getMonto)
                .sum();

        double totalEgresos = transacciones.stream()
                .filter(t -> !t.isEsIngreso())
                .mapToDouble(Transaction::getMonto)
                .sum();

        double balance = totalIngresos - totalEgresos;

        return "Reporte Financiero:\n" +
                "Total Ingresos: " + totalIngresos + "€\n" +
                "Total Egresos: " + totalEgresos + "€\n" +
                "Balance: " + balance + "€\n";
    }
}
