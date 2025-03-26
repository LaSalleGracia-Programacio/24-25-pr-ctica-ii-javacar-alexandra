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

    public void menuClient(List<Vehicle> vehicles){
        boolean sortir = false;
        do{
            System.out.println("""
                    Benvingut a JavaCar!Escull una opció:
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
                    mostrarVehicles();
                    break;
                case 3:
                    filtrarVehicles(vehicles);
                case 4:
                    retornarVehicle();
                    break;
                case 5:
                    veureAlquilats();
                    break;
                case 6:
                    sortir = true;
                    break;
                default:
                    System.out.println("Opció no vàlida, torna a intentar-ho.");
            }
        } while (!sortir);
    }
    public void alquilarVehicle(List<Vehicle> vehicles){
        // Mostrar vehicles disponibles
        List<Vehicle> disponibles = new ArrayList<>();
        List<String> matriculesLlogades = admin.getMatriculesLlogades();

        for (Vehicle v : vehicles) {
            if (!matriculesLlogades.contains(v.getMatricula())) {
                disponibles.add(v);
            }
        }

        if (disponibles.isEmpty()) {
            System.out.println("No hi ha vehicles disponibles per llogar.");
            return;
        }

        System.out.println("Vehicles disponibles per llogar:");
        System.out.println("==========================================");

        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i).getMarca() + " " +
                        disponibles.get(i).getModel() + " (Matrícula: " + disponibles.get(i).getMatricula() +
                        ") - Preu/dia: " + disponibles.get(i).getPreuBase() + "€");
        }

        System.out.println("==========================================");
        System.out.println("Introdueix el número del vehicle que vols llogar (0 per cancel·lar):");

        int seleccio = input.nextInt();
        input.nextLine(); // Consumir el salt de línia

        if (seleccio <= 0 || seleccio > disponibles.size()) {
            System.out.println("Operació cancel·lada o selecció no vàlida.");
            return;
        }

        Vehicle vehicleSeleccionat = disponibles.get(seleccio - 1);

        System.out.println("Quants dies vols llogar el vehicle?");
        int dies = input.nextInt();
        input.nextLine(); // Consumir el salt de línia

        if (dies <= 0) {
            System.out.println("Error: Els dies han de ser un número positiu.");
            return;
        }

        double preuTotal = vehicleSeleccionat.calcularPreu(dies);

        System.out.println("Resum del lloguer:");
        System.out.println("Vehicle: " + vehicleSeleccionat.getMarca() + " " + vehicleSeleccionat.getModel());
        System.out.println("Matrícula: " + vehicleSeleccionat.getMatricula());
        System.out.println("Dies: " + dies);
        System.out.println("Preu total: " + preuTotal + "€");
        System.out.println("\nConfirmar el lloguer? (s/n)");

        String confirmacio = input.nextLine();

        if (confirmacio.equalsIgnoreCase("s")) {
            admin.afegirLloguer(unicID, vehicleSeleccionat.getMatricula(), dies);
            System.out.println("Vehicle llogat correctament!");
        } else {
            System.out.println("Operació cancel·lada.");
        }
    }

    public void mostrarVehicles(){

    }

    public void filtrarVehicles(List<Vehicle> vehicles){

        System.out.println("Digues el preu per el qual vols filtrar: ");
        double preu = input.nextDouble();

        List<Vehicle> trobarVehicle = GestorLloguers.filtrar(vehicles, preu);

        System.out.println(trobarVehicle);

    }

    public void retornarVehicle(){

    }

    public void veureAlquilats(){

    }


}
