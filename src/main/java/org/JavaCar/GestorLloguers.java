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

    public static List<Vehicle> trobarPerPreu(List<Vehicle> vehicles, double preuMax) {
        List<Vehicle> trobarVehicle = new ArrayList<>();

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getPreuBase() < preuMax)
                trobarVehicle.add(vehicles.get(i));
        }
        return trobarVehicle;
    }
}
