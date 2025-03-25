package org.JavaCar;
import java.util.List;
import java.util.ArrayList;

public class GestorLloguers {
    static public double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {

        double preutotal = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            preutotal += vehicles.get(i).calcularPreu(dies);
        }
        return preutotal;
    }

    public static List<Vehicle> filtrar(List<Vehicle> vehicles, double preu) {
        List<Vehicle> trobarVehicle = new ArrayList<>();

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getPreuBase() < preu)
                trobarVehicle.add(vehicles.get(i));
        }
        return trobarVehicle;
    }
}
