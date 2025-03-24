package org.JavaCar;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Client {
    static Scanner input = new Scanner(System.in);
    private int unicID;
    private String nom;
    private String cognom;
    private List<Vehicle> vehiclesClient;

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

    public void menuClient(){
        boolean sortir = false;
        do{
            System.out.println("""
                    Benvingut a JavaCar!Escull una opció:
                    1. Alquilar un vehicle
                    2. Veure vehicles disponibles
                    3. Retornar un vehicle.
                    4. Veure els teus vehicles alquilats
                    5. Tornar enrere.""");
            int opcio = input.nextInt();
            switch (opcio) {
                case 1:
                    alquilarVehicle();
                    break;
                case 2:
                    mostrarVehicles();
                    break;
                case 3:
                    retornarVehicle();
                    break;
                case 4:
                    veureAlquilats();
                    break;
                case 5:
                    sortir = true;
                    break;
            }
        } while (!sortir);
    }

    public void alquilarVehicle(){
    }

    public void mostrarVehicles(){

    }

    public void retornarVehicle(){

    }

    public void veureAlquilats(){

    }
}
