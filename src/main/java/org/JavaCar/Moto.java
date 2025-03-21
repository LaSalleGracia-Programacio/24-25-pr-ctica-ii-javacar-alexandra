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
    public String toString() {
        String motoInfo = "Marca: " + marca + " | " +
                "Model: " + model + "\n" +
                "Matricula: " + matricula + " | " +
                "Any matriculació: " + anyMatriculacio + "\n" +
                "Preu per dia: " + preuBase + " | " +
                "Cilindrada: " + cilindrada + "\n" +
                "Tipus de motor: " + motor.getTipus() + " | " +
                "Marca de roda: " + rodes[0].getMarca() + "\n";
        return motoInfo;
    }

    @Override
    public double calcularPreu(int dies) {
        return 0;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
