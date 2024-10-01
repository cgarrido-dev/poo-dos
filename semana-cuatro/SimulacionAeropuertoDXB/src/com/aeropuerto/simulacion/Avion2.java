package com.aeropuerto.simulacion;

public class Avion2 extends Thread {
    @Override
    public void run() {
        System.out.println("Avión 2: Aterrizando.");
        try {
            Thread.sleep(3000); // --> Simulación del tiempo de aterrizaje
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Avión 2: Ha aterrizado.");
    }
}
