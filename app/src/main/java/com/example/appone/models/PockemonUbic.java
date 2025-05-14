package com.example.appone.models;

public class PockemonUbic {
    private double latitud;
    private double longitud;

    public PockemonUbic(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }
    public PockemonUbic() {

    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
