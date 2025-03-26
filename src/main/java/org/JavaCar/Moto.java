package org.JavaCar;

public class Moto extends Vehicle {
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.cilindrada = cilindrada;

        if (cilindrada >500) {
            this.preuBase += 5;
        }
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public double calcularPreu(int dies) {
        return super.calcularPreu(dies);
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " | " +
                "Model: " + model + "\n" +
                "Matricula: " + matricula + " | " +
                "Any fabricació: " + anyFabricacio + "\n" +
                "Preu per dia: " + preuBase + " | " +
                "Cilindrada: " + cilindrada + "\n" +
                "Tipus de motor: " + motor.getTipus() + " | " +
                "Marca de roda: " + rodes[0].getMarca() + "\n";
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
