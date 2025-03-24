package org.JavaCar;

import java.util.Scanner;

public class Administrador {
    Scanner scanner = new Scanner(System.in);

    public void menuAdministrador() {
        boolean sortir = false;
        System.out.println("""
            Benvingut a la gestió de JavaCar! Escull una opció:
            1. Afegir un vehicle
            2. Eliminar un vehicle
            3. Veure tots els vehicles
            4. Veure ingressos totals
            5. Veure vehicles alquilats
            6. Tornar enrere
            """);
        int opcio = scanner.nextInt();
    }
}