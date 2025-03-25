package org.JavaCar;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner input = new Scanner(System.in);
    static List<Vehicle> vehicles = new ArrayList<>();
    static List<Client> clients = new ArrayList<>();

    static Administrador a;
    static Client c;


    public static void main(String[] args) {
        creacioClients();
        creacioVehicles();
        menuPrincipal();
    }

    public static void menuPrincipal(){
        Scanner input = new Scanner(System.in);
        boolean sortir = false;
        do {
            System.out.println("""
                    Indiqui el tipus d'usuari:
                    1. Administrador
                    2. Client
                    3. Sortir""");
            int opcio = input.nextInt();
            switch (opcio) {
                case 1:
                    a.menuAdmin();
                    break;
                case 2:
                    c.menuClient(vehicles);
                    break;
                case 3:
                    sortir = true;
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opció no vàlida, torna a intentar-ho.");
            }
        } while (!sortir);
    }


    public static void creacioClients(){

    }
    public static void creacioVehicles(){

    }
}