package com.deliciososabor.platos;

import java.util.ArrayList;
import java.util.List;

public class PlatoPrincipal extends PlatoBase {
    private List<OpcionExtra> opcionesExtras;

    public PlatoPrincipal(String nombre, double precio) {
        super(nombre, precio);
        this.opcionesExtras = new ArrayList<>();
    }

    public void agregarOpcionExtra(OpcionExtra extra) {
        opcionesExtras.add(extra);
    }

    @Override
    public void imprimirDetalles() {
        System.out.println(getNombre() + " - $" + getPrecio());
        if (getDescripcion() != null) {
            System.out.println("\tDescripción: " + getDescripcion());
        }
        if (!opcionesExtras.isEmpty()) {
            System.out.println("\tOpciones Extras:");
            for (OpcionExtra extra : opcionesExtras) {
                System.out.println("\t\t- " + extra.getNombre());
            }
        }
    }
}
