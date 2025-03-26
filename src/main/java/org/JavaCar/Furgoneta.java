package org.JavaCar;
import java.util.List;
public class Furgoneta extends Vehicle {
    private int capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, int capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
        if (capacitatCarga >1000)
        {
            this.preuBase += 10;
        }
    }

    public int getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        return super.calcularPreu(dies);
    }
    @Override
    public String toString() {
        String infoFurgoneta= "Marca: " + marca + " | " +
                "Model: " + model + "\n" +
                "Matricula: " + matricula + " | " +
                "Preu/dia: " + preuBase + " | " +
                "Capacitat de càrrega: " + capacitatCarga + "kg\n" +
                "Tipus de motor: " + motor.getTipus() + " | " +
                "Marca de roda: " + rodes[0].getMarca() + "\n" +
                "Any de fabricació: " + anyFabricacio + "\n" +
                "Etiqueta Ambiental: " + etiquetaAmbiental;

        return infoFurgoneta;
    }

    public void setCapacitatCarga(int capacitatCarga) {
        this.capacitatCarga = capacitatCarga;
    }
}