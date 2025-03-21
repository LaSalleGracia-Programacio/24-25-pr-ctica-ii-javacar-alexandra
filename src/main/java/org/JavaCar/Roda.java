package org.JavaCar;

public class Roda {
    private String marca;
    private int diametre;


    public Roda(String marca, int diametre) {
        this.marca = marca;
        this.diametre = diametre;
    }

    public String getMarca() {
        return marca;
    }

    public int getDiametre() {
        return diametre;
    }

    @Override
    public String toString() {
        return "Roda{" +
                "marca='" + marca + '\'' +
                ", diametre=" + diametre +
                '}';
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }
}
