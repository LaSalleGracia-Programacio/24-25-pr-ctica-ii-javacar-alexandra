package org.JavaCar;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Administrador {
    static Scanner input = new Scanner(System.in);
    private List<Vehicle> vehicles;
    private List<Client> clients;

    private List<Lloguer> lloguers = new ArrayList<>();

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
            input.nextLine();

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
        //Calcular etiqueta ambiental
        EtiquetaAmbiental etiqueta = nouVehicle.calculEtiqueta();
        nouVehicle.setEtiquetaAmbiental(etiqueta);
        System.out.println("Etiqueta ambiental assignada: " + etiqueta);
        vehicles.add(nouVehicle);
        System.out.println("Vehicle afegit correctament.");

    }

    public void eliminarVehicle() {
        System.out.println("Eliminant un vehicle...");

    }
    public void veureVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No hi ha vehicles registrats.");
            return;
        }

        System.out.println("Llista de tots els vehicles:");
        System.out.println("==========================================");

        for (Vehicle v : vehicles) {
            System.out.println(v);
            System.out.println("==========================================");
        }
    }

    public List<String> getMatriculesLlogadesPerClient(int clientID) {
        List<String> matricules = new ArrayList<>();
        for (Lloguer lloguer : lloguers) {
            if (lloguer.getClientID() == clientID) {
                matricules.add(lloguer.getMatricula());
            }
        }
        return matricules;
    }

    public List<String> getMatriculesLlogades() {
        List<String> matricules = new ArrayList<>();
        for (Lloguer lloguer : lloguers) {
            matricules.add(lloguer.getMatricula());
        }
        return matricules;
    }

    public void veureVehiclesAlquilats() {
        System.out.println("Mostrant vehicles actualment alquilats...");

    }
    public void afegirLloguer(int clientID, String matricula, int dies) {
        lloguers.add(new Lloguer(clientID, matricula, dies));
    }

    public boolean eliminarLloguer(String matricula, int clientID) {
        // Cercar el lloguer específic
        boolean trobat = false;

        for (Lloguer lloguer : new ArrayList<>(lloguers)) {
            if (lloguer.getMatricula().equals(matricula)) {
                //Verificar que el client que intenta retornar és qui el va llogar
                if (lloguer.getClientID() == clientID) {
                    lloguers.remove(lloguer);
                    System.out.println("Vehicle amb matrícula " + matricula + " ha estat retornat per el client " +
                            clientID + " i ara està disponible per a nous lloguers.");
                    trobat = true;
                } else {
                    System.out.println("Error: Aquest vehicle va ser llogat per un altre client (ID: " +
                            lloguer.getClientID() + "). No pots retornar-lo.");
                    return false;
                }
            }
        }

        if (!trobat) {
            System.out.println("Error: No s'ha trobat cap lloguer per a aquest vehicle.");
            return false;
        }

        return true;
    }
    public List<Lloguer> getLloguers() {
        return lloguers;
    }

}