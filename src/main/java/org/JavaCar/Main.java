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
        a= new Administrador(vehicles, clients);
        creacioClients();
        creacioVehicles();
        if (!clients.isEmpty()) {
            c = clients.get(0);
        } else {
            System.out.println("Error: No hi ha clients al sistema!");
            return;
        }
        menuPrincipal();
    }

    public static void menuPrincipal(){
        Scanner input = new Scanner(System.in);
        boolean sortir = false;
        do {
            System.out.println("""
                    Indiqui el tipus d'usuari:
                    1. Aministrador
                    2. Client
                    3. Sortir""");
            int opcio = input.nextInt();
            input.nextLine(); //consumir salto de linea
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
        clients.add(new Client(1, "Joan", "Garcia", a));
        clients.add(new Client(2, "Maria", "Lopez", a));
        clients.add(new Client(3, "Pere", "Martinez", a));
        clients.add(new Client(4, "Laura", "Soler", a));
        clients.add(new Client(5, "Andreu", "Puig", a));

        System.out.println("S'han creat " + clients.size() + " clients d'exemple.");
    }
    public static void creacioVehicles(){
        // Crear motors
        Motor motorGasolina = new Motor("Gasolina", 120);
        Motor motorDiesel = new Motor("Diesel", 150);
        Motor motorElectric = new Motor("Electric", 200);
        Motor motorHibrid = new Motor("Hibrid", 180);

        // Crear rodes
        Roda[] rodesCotxe1 = {
                new Roda("Michelin", 17),
                new Roda("Michelin", 17),
                new Roda("Michelin", 17),
                new Roda("Michelin", 17)
        };

        Roda[] rodesCotxe2 = {
                new Roda("Pirelli", 18),
                new Roda("Pirelli", 18),
                new Roda("Pirelli", 18),
                new Roda("Pirelli", 18)
        };

        Roda[] rodesMoto1 = {
                new Roda("Dunlop", 17),
                new Roda("Dunlop", 17)
        };

        Roda[] rodesMoto2 = {
                new Roda("Bridgestone", 16),
                new Roda("Bridgestone", 16)
        };

        Roda[] rodesFurgoneta1 = {
                new Roda("Continental", 19),
                new Roda("Continental", 19),
                new Roda("Continental", 19),
                new Roda("Continental", 19)
        };

        Roda[] rodesFurgoneta2 = {
                new Roda("Goodyear", 20),
                new Roda("Goodyear", 20),
                new Roda("Goodyear", 20),
                new Roda("Goodyear", 20)
        };

        // Crear cotxes
        Cotxe cotxe1 = new Cotxe("1234ABC", "Seat", "Ibiza", 50.0, 5, motorGasolina, rodesCotxe1);
        cotxe1.setAnyFabricacio(2018);

        Cotxe cotxe2 = new Cotxe("5678DEF", "Volkswagen", "Golf", 65.0, 5, motorDiesel, rodesCotxe2);
        cotxe2.setAnyFabricacio(2020);

        Cotxe cotxe3 = new Cotxe("9012GHI", "Tesla", "Model 3", 95.0, 5, motorElectric, rodesCotxe1);
        cotxe3.setAnyFabricacio(2022);

        // Crear motos
        Moto moto1 = new Moto("3456JKL", "Honda", "CBR", 40.0, 600, motorGasolina, rodesMoto1);
        moto1.setAnyFabricacio(2019);

        Moto moto2 = new Moto("7890MNO", "Yamaha", "MT-07", 45.0, 700, motorGasolina, rodesMoto2);
        moto2.setAnyFabricacio(2021);

        // Crear furgonetes
        Furgoneta furgoneta1 = new Furgoneta("2345PQR", "Renault", "Kangoo", 70.0, 800, motorDiesel, rodesFurgoneta1);
        furgoneta1.setAnyFabricacio(2017);

        Furgoneta furgoneta2 = new Furgoneta("6789STU", "Mercedes", "Sprinter", 85.0, 1200, motorDiesel, rodesFurgoneta2);
        furgoneta2.setAnyFabricacio(2020);

        Furgoneta furgoneta3 = new Furgoneta("0123VWX", "Nissan", "e-NV200", 75.0, 700, motorElectric, rodesFurgoneta1);
        furgoneta3.setAnyFabricacio(2022);

        // Afegir vehicles a la llista
        vehicles.add(cotxe1);
        vehicles.add(cotxe2);
        vehicles.add(cotxe3);
        vehicles.add(moto1);
        vehicles.add(moto2);
        vehicles.add(furgoneta1);
        vehicles.add(furgoneta2);
        vehicles.add(furgoneta3);

        System.out.println("S'han creat " + vehicles.size() + " vehicles d'exemple.");

    }
}