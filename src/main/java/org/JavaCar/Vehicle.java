package org.JavaCar;

public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;

    protected int anyFabricacio;
    protected EtiquetaAmbiental etiquetaAmbiental;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.etiquetaAmbiental = calculEtiqueta();

        anyFabricacio = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public int getAnyFabricacio() {
        return anyFabricacio;
    }

    public double getPreuBase() {
        return preuBase;
    }

    public Motor getMotor() {
        return motor;
    }

    public Roda[] getRodes() {
        return rodes;
    }


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void setRodes(Roda[] rodes) {
        this.rodes = rodes;
    }

    public void setAnyFabricacio(int anyFabricacio) {
        this.anyFabricacio = anyFabricacio;
    }


    public EtiquetaAmbiental getEtiquetaAmbiental() {
        return etiquetaAmbiental;
    }

    public void setEtiquetaAmbiental(EtiquetaAmbiental etiquetaAmbiental) {
        this.etiquetaAmbiental = etiquetaAmbiental;
    }

    @Override
    public double calcularPreu(int dies) {
        return dies * preuBase;
    }

    public EtiquetaAmbiental calculEtiqueta() {
        if (anyFabricacio < 2000) {
            etiquetaAmbiental = EtiquetaAmbiental.SenseDistintiu;
        } else if (anyFabricacio <= 2005) {
            etiquetaAmbiental = EtiquetaAmbiental.B;
        } else {
            etiquetaAmbiental = EtiquetaAmbiental.C;
            if (motor.getTipus().equalsIgnoreCase("Hibrid") || motor.getTipus().equals("Gas") || anyFabricacio > 2015) {
                etiquetaAmbiental = EtiquetaAmbiental.ECO;
            }
            if (motor.getTipus().equalsIgnoreCase("Electric")) {
                etiquetaAmbiental = EtiquetaAmbiental.ZeroEmisions;
            }
        }
        return etiquetaAmbiental;
    }
}

