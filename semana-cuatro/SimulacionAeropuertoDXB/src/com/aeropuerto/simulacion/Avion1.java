package com.aeropuerto.simulacion;

public class Avion1 extends Thread {
    @Override
    public void run() {
        System.out.println("Avión 1: Despegando.");
        try {
            Thread.sleep(3000); // --> Simulación del tiempo de despegue

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Avión 1: Ha despegado.");
    }
}
