package org.JavaCar;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Administrador {
    static Scanner input = new Scanner(System.in);
    private List<Vehicle> vehicles;
    private List<Client> clients;

    public Administrador(List<Vehicle> vehicles, List<Client> clients) {
        this.vehicles = vehicles;
        this.clients = clients;
    }

    public void menuAdmin() {
        boolean sortir = false;
        do {
            System.out.println("""
                    Benvingut a la gestió de JavaCar! Escull una opció:
                    1. Afegir un vehicle
                    2. Eliminar un vehicle
                    3. Veure tots els vehicles
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
        System.out.println("Quin tipus de vehicle vols afegir?");
        System.out.println("1. Cotxe");
        System.out.println("2. Moto");
        System.out.println("3. Furgoneta");

        int tipus = input.nextInt();
        input.nextLine();

        System.out.println("Introdueix la matrícula:");
        String matricula = input.nextLine();


        for (Vehicle v : vehicles) {
            if (v.getMatricula().equals(matricula)) {
                System.out.println("Error: Ja existeix un vehicle amb aquesta matrícula!");
                return;
            }
        }

        System.out.println("Introdueix la marca:");
        String marca = input.nextLine();

        System.out.println("Introdueix el model:");
        String model = input.nextLine();

        System.out.println("Introdueix el preu base per dia:");
        double preuBase = input.nextDouble();
        input.nextLine();

        System.out.println("Introdueix l'any de fabricació:");
        int anyFabricacio = input.nextInt();
        input.nextLine();

        System.out.println("Introdueix el tipus de motor (Gasolina, Diesel, Electric, Hibrid):");
        String tipusMotor = input.nextLine();

        System.out.println("Introdueix la potència del motor (CV):");
        int potencia = input.nextInt();
        input.nextLine();

        Motor motor = new Motor(tipusMotor, potencia);

        Roda[] rodes;
        if (tipus == 2) {
            rodes = new Roda[2];
        } else {
            rodes = new Roda[4];
        }

        System.out.println("Introdueix la marca de les rodes:");
        String marcaRodes = input.nextLine();

        System.out.println("Introdueix la mida de les rodes (polzades):");
        int midaRodes = input.nextInt();
        input.nextLine();

        for (int i = 0; i < rodes.length; i++) {
            rodes[i] = new Roda(marcaRodes, midaRodes);
        }

        Vehicle nouVehicle = null;

        switch (tipus) {
            case 1:
                System.out.println("Introdueix el nombre de places:");
                int places = input.nextInt();
                input.nextLine(); // Consumir el salt de línia
                nouVehicle = new Cotxe(matricula, marca, model, preuBase, places, motor, rodes);
                break;

            case 2: // Moto
                System.out.println("Introdueix la cilindrada:");
                int cilindrada = input.nextInt();
                input.nextLine(); // Consumir el salt de línia
                nouVehicle = new Moto(matricula, marca, model, preuBase, cilindrada, motor, rodes);
                break;

            case 3: // Furgoneta
                System.out.println("Introdueix la capacitat de càrrega (kg):");
                int capacitat = input.nextInt();
                input.nextLine(); // Consumir el salt de línia
                nouVehicle = new Furgoneta(matricula, marca, model, preuBase, capacitat, motor, rodes);
                break;

            default:
                System.out.println("Opció no válida.");
                return;
        }

        nouVehicle.setAnyFabricacio(anyFabricacio);
        vehicles.add(nouVehicle);
        System.out.println("Vehicle afegit correctament.");

        System.out.println(nouVehicle);
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