package org.JavaCar;

public class Lloguer {
    private int clientID;
    private String matricula;
    private int dies;

    public Lloguer(int clientID, String matricula, int dies) {
        this.clientID = clientID;
        this.matricula = matricula;
        this.dies = dies;
    }

    public int getClientID() {
        return clientID;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getDies() {
        return dies;
    }
}
