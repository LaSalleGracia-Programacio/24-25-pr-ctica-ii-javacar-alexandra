package org.JavaCar;

import java.util.Scanner;

public class Administrador {
    static Scanner input = new Scanner(System.in);

    public void menuAdmin() {
        boolean sortir = false;
        do {
            System.out.println("""
                    Benvingut a la gestió de JavaCar! Escull una opció:
                    1. Afegir un vehicle
                    2. Eliminar un vehicle
                    3. Veure tots els vehicle
                    4. Veure vehicles alquilats
                    5. Tornar enrere
                    """);
            int opcio = input.nextInt();
            input.nextLine(); // Consumir el salt de línia

            switch (opcio) {
                case 1:
                    afegirVehicle();
                    break;
                case 2:
                    eliminarVehicle();
                    break;
                case 3:
                    veureVehicles();
                    break;
                case 4:
                    veureVehiclesAlquilats();
                    break;
                case 5:
                    sortir = true;
                    break;
                default:
                    System.out.println("Opció no vàlida, torna a intentar-ho.");
            }
        } while (!sortir);
    }

    public void afegirVehicle() {
        System.out.println("Afegint un vehicle...");

    }

    public void eliminarVehicle() {
        System.out.println("Eliminant un vehicle...");

    }
    public void veureVehicles() {
        System.out.println("Llistant tots els vehicles...");

    }

    public void veureVehiclesAlquilats() {
        System.out.println("Mostrant vehicles actualment alquilats...");

    }

}