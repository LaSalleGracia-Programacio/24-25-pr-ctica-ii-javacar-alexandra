package org.JavaCar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                    menuClient();
                    break;
                case 2:

                case 3:
                    sortir = true;
                    System.out.println("Fins aviat!");
                    break;
            }
        } while (!sortir);
    }
}