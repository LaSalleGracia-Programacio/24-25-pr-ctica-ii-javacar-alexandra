package org.JavaCar;
import java.util.Scanner;

public class Main {

    static Client c;
    static Administrador a;
    public static void main(String[] args) {
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
                    c.menuClient();
                case 3:
                    sortir = true;
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opció no vàlida, torna a intentar-ho.");
            }
        } while (!sortir);
    }
}