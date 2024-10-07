package com.deliciososabor.platos;

public class Postre extends PlatoBase {
    public Postre(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public void imprimirDetalles() {
        System.out.println(getNombre() + " - $" + getPrecio());
        if (getDescripcion() != null) {
            System.out.println("\tDescripción: " + getDescripcion());
        }
    }
}
