package org.JavaCar;

public class Moto extends Vehicle {
    public int cilindrada;

    public Moto(java.lang.String matricula, java.lang.String marca, java.lang.String model, double preuBase, Motor motor, Roda[] rodes, int cilindrada) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.cilindrada = cilindrada;

        if (cilindrada > 500) {
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
}
