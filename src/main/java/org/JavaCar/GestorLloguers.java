package org.JavaCar;
import java.util.List;
import java.util.ArrayList;

public class GestorLloguers {
    static public double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {

        double preutotal = 0;
        for (Vehicle vehicle : vehicles) {
            preutotal += vehicle.calcularPreu(dies);
        }
        return preutotal;
    }

    public static List<Vehicle> filtrar(List<Vehicle> vehicles, double preu) {
        List<Vehicle> trobarVehicle = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPreuBase() < preu)
                trobarVehicle.add(vehicle);
        }
        return trobarVehicle;
    }
}
