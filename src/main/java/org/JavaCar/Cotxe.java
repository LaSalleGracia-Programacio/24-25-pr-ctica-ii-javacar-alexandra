package org.JavaCar;
import java.util.Arrays;
public class Cotxe extends Vehicle{
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.nombrePlaces = nombrePlaces;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    @Override
    public String toString() {
        String infoCotxe = "Marca: " + marca + " | " +
                "Model: " + model + "\n" +
                "Matricula: " + matricula + " | " +
                "Preu per dia: " + preuBase + " | " +
                "Numero de places: " + nombrePlaces + "\n" +
                "Tipus de motor: " + motor.getTipus() + " | " +
                "Marca de roda: " + rodes[0].getMarca() + "\n" +
                "Any Fabricació: " + anyFabricacio + "\n" +
                "Etiqueta Ambiental: " + etiquetaAmbiental;

        return infoCotxe;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }
}

