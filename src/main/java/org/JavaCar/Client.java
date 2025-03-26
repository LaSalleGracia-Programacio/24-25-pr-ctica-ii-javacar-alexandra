package org.JavaCar;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Client {
    static Scanner input = new Scanner(System.in);
    private int unicID;
    private String nom;
    private String cognom;

    public Client(int unicID, String nom, String cognom) {
        this.unicID = unicID;
        this.nom = nom;
        this.cognom = cognom;
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
                    alquilarVehicle();
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

    public void alquilarVehicle(){

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
