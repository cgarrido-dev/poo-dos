package com.aeropuerto.simulacion;

public class Main {
    public static void main(String[] args) {

        Avion1 avion1 = new Avion1();
        Avion2 avion2 = new Avion2();

        avion1.start();
        avion2.start();
    }
}
