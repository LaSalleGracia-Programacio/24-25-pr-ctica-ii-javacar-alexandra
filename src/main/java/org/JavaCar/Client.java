package org.JavaCar;

import javax.lang.model.element.AnnotationMirror;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Client {
    static Scanner input = new Scanner(System.in);
    private int unicID;
    private String nom;
    private String cognom;
    private Administrador admin;


    public Client(int unicID, String nom, String cognom, Administrador admin) {
        this.unicID = unicID;
        this.nom = nom;
        this.cognom = cognom;
        this.admin = admin;
    }

    public int getUnicID() {
        return unicID;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void menuClient(List<Vehicle> vehicles) { // Metode per printejar el menu client
        boolean sortir = false;
        do {
            System.out.println("""
                    Benvingut! Escull una opció:
                    1. Alquilar un vehicle
                    2. Veure vehicles disponibles
                    3  Filtrar vehicles per preu
                    4. Retornar un vehicle
                    5. Veure els teus vehicles alquilats
                    6. Tornar enrere""");
            int opcio = input.nextInt();
            input.nextLine();

            switch (opcio) {
                case 1:
                    alquilarVehicle(vehicles);
                    break;
                case 2:
                    mostrarVehicles(vehicles);
                    break;
                case 3:
                    filtrarVehicles(vehicles);
                    break;
                case 4:
                    retornarVehicle();
                    break;
                case 5:
                    veureAlquilats(vehicles);
                    break;
                case 6:
                    sortir = true;
                    break;
                default:
                    System.out.println("Opció no vàlida, torna a intentar-ho.");
            }
        } while (!sortir);
    }

    public void alquilarVehicle(List<Vehicle> vehicles) {
        // Mostrar vehicles disponibles
        List<Vehicle> disponibles = new ArrayList<>(); // Crear una llista per emmagatzemar els vehicles disponibles
        List<String> matriculesLlogades = admin.getMatriculesLlogades(); // Llista per emmagatzemar el vehicles ja alquilats

        for (Vehicle v : vehicles) { // Comprovem si els vehicles que hi han estan alquilats o no
            if (!matriculesLlogades.contains(v.getMatricula())) {
                disponibles.add(v); // Si no estan alquilats els emmagatzem en la llista
            }
        }

        if (disponibles.isEmpty()) {  // Si no emmagatzema res a la llista es perque no hi han.
            System.out.println("No hi ha vehicles disponibles per llogar.");
            return;
        }

        System.out.println("Vehicles disponibles per llogar:");
        System.out.println("==========================================");

        for (int i = 0; i < disponibles.size(); i++) { // Printejar vehicles disponibles
            System.out.println((i + 1) + ". " + disponibles.get(i).getMarca() + " " +
                    disponibles.get(i).getModel() + " (Matrícula: " + disponibles.get(i).getMatricula() +
                    ") - Preu/dia: " + disponibles.get(i).getPreuBase() + "€");
        }

        System.out.println("==========================================");
        System.out.println("Introdueix el número del vehicle que vols llogar (0 per cancel·lar):");

        int seleccio = input.nextInt();
        input.nextLine(); // Consumir el salt de línia

        if (seleccio <= 0 || seleccio > disponibles.size()) {  // Compovar que la seleccio sigui válida
            System.out.println("Operació cancel·lada o selecció no vàlida.");
            return;
        }

        Vehicle vehicleSeleccionat = disponibles.get(seleccio - 1);
        // Agafem la seleccio - 1 perque correspongui als numeros del vehicles printejats per pantalla.

        System.out.println("Quants dies vols llogar el vehicle?");
        int dies = input.nextInt();
        input.nextLine(); // Consumir el salt de línia

        if (dies <= 0) { // Validar que els dies siguin un numero positiu
            System.out.println("Error: Els dies han de ser un número positiu.");
            return;
        }

        double preuTotal = vehicleSeleccionat.calcularPreu(dies); // Cridem al metode per calcular el preu total

        System.out.println("Resum del lloguer:");
        System.out.println("Vehicle: " + vehicleSeleccionat.getMarca() + " " + vehicleSeleccionat.getModel());
        System.out.println("Matrícula: " + vehicleSeleccionat.getMatricula());
        System.out.println("Dies: " + dies);
        System.out.println("Preu total: " + preuTotal + "€");
        System.out.println("\nConfirmar el lloguer? (s/n)");

        String confirmacio = input.nextLine();

        if (confirmacio.equalsIgnoreCase("s")) { // Comprovem el input
            admin.afegirLloguer(unicID, vehicleSeleccionat.getMatricula(), dies); // Afegim el lloguer
            System.out.println("Vehicle llogat correctament!");
            System.out.println();
        } else {
            System.out.println("Operació cancel·lada.");
        }
    }

    public void mostrarVehicles(List<Vehicle> vehicles) {
        // Obtenir les matrícules dels vehicles llogats
        List<String> matriculesLlogades = admin.getMatriculesLlogades();

        System.out.println("Llistat de vehicles disponibles:");
        System.out.println("==========================================");

        boolean hiHaDisponibles = false;

        for (Vehicle v : vehicles) { // Comprovar quins vehicles están disponibles
            if (!matriculesLlogades.contains(v.getMatricula())) {
                hiHaDisponibles = true;
                System.out.println(v);
                System.out.println("==========================================");
            }
        }

        if (!hiHaDisponibles) {
            System.out.println("No hi ha vehicles disponibles actualment.");
        }
    }

    public void filtrarVehicles(List<Vehicle> vehicles) {

        System.out.println("Digues el preu per el qual vols filtrar: ");
        double preu = input.nextDouble();

        List<Vehicle> trobarVehicle = GestorLloguers.filtrar(vehicles, preu); // Cridar el metode pero filtrar per preu i ho emmagatzem a la llista

        if (trobarVehicle.isEmpty()) {
            System.out.println("No s'han trobat vehicles amb un preu inferior a " + preu + "€.");
            return;
        }

        System.out.println("Vehicles amb preu inferior a " + preu + "€:");
        System.out.println("==========================================");

        // Obtenir les matrícules dels vehicles llogats
        List<String> matriculesLlogades = admin.getMatriculesLlogades();

        boolean hiHaDisponibles = false;

        for (Vehicle v : trobarVehicle) {
            if (!matriculesLlogades.contains(v.getMatricula())) { // Comprovar quins están disponibles per alquilar
                hiHaDisponibles = true;
                System.out.println(v);
                System.out.println("==========================================");
            }
        }

        if (!hiHaDisponibles) {
            System.out.println("No hi ha vehicles disponibles amb aquest preu.");
        }
    }

    public void retornarVehicle() {
        List<String> vehiclesLlogats = admin.getMatriculesLlogadesPerClient(unicID);

        if (vehiclesLlogats.isEmpty()) {
            System.out.println("No tens cap vehicle llogat actualment.");
            return;
        }

        System.out.println("Els teus vehicles llogats:");
        System.out.println("==========================================");

        for (int i = 0; i < vehiclesLlogats.size(); i++) {
            System.out.println((i + 1) + ". Matrícula: " + vehiclesLlogats.get(i));
        }

        System.out.println("==========================================");
        System.out.println("Introdueix el número del vehicle que vols retornar:");

        int seleccio = input.nextInt();
        input.nextLine();


        if (seleccio <= 0 || seleccio > vehiclesLlogats.size()) { // Comprovar la seleccio
            System.out.println("Operació cancel·lada o selecció no vàlida.");
            return;
        }

        String matriculaARetornar = vehiclesLlogats.get(seleccio - 1);

        System.out.println("Estàs segur que vols retornar el vehicle? (s/n)");
        String confirmacio = input.nextLine();

        if (confirmacio.equalsIgnoreCase("s")) {
            // Verificant que aquest client és qui va llogar el vehicle
            boolean retornatCorrectament = admin.eliminarLloguer(matriculaARetornar, unicID);

            if (!retornatCorrectament) {
                System.out.println("No s'ha pogut retornar el vehicle. Comprova que siguis el client correcte.");
            }
        } else {
            System.out.println("Operació cancel·lada.");
        }
    }

    public void veureAlquilats(List<Vehicle> vehicles) {
        // Obtenir els vehicles llogats per aquest client
        List<String> vehiclesLlogats = admin.getMatriculesLlogadesPerClient(unicID);

        if (vehiclesLlogats.isEmpty()) {
            System.out.println("No tens cap vehicle llogat actualment.");
            return;
        }

        System.out.println("Els teus vehicles llogats:");
        System.out.println("==========================================");

        List<Lloguer> lloguers = admin.getLloguers();

        for (String matricula : vehiclesLlogats) {
            // Buscar el vehicle
            for (Vehicle v : vehicles) {
                if (v.getMatricula().equals(matricula)) {

                    // Buscar els dies de lloguer
                    int dies = 0;
                    for (Lloguer lloguer : lloguers) {
                        if (lloguer.getMatricula().equals(matricula) && lloguer.getClientID() == unicID) {
                            dies = lloguer.getDies();
                            break;
                        }
                    }

                    System.out.println("Vehicle: " + v.getMarca() + " " + v.getModel());
                    System.out.println("Matrícula: " + v.getMatricula());
                    System.out.println("Dies de lloguer: " + dies);
                    System.out.println("Cost total: " + v.calcularPreu(dies) + "€");
                    System.out.println("==========================================");
                    break;
                }
            }
        }
    }
}
