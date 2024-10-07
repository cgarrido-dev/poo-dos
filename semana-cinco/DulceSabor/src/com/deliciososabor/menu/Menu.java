package com.deliciososabor.menu;

import com.deliciososabor.platos.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<PlatoPrincipal> platosPrincipales;
    private List<Acompanamiento> acompanamientos;
    private List<Postre> postres;

    public Menu() {
        platosPrincipales = new ArrayList<>();
        acompanamientos = new ArrayList<>();
        postres = new ArrayList<>();
    }

    public void agregarPlato(PlatoBase plato) {
        if (plato instanceof PlatoPrincipal) {
            platosPrincipales.add((PlatoPrincipal) plato);
        } else if (plato instanceof Acompanamiento) {
            acompanamientos.add((Acompanamiento) plato);
        } else if (plato instanceof Postre) {
            postres.add((Postre) plato);
        }
    }

    public void imprimirMenu() {
        System.out.println("----- MENU DELICIOSO SABOR -----");
        for (PlatoPrincipal plato : platosPrincipales) {
            plato.imprimirDetalles();
        }
        for (Acompanamiento acomp : acompanamientos) {
            acomp.imprimirDetalles();
        }
        for (Postre postre : postres) {
            postre.imprimirDetalles();
        }
        System.out.println("Total del Menú: $" + calcularTotal());
    }

    public double calcularTotal() {
        double total = 0.0;
        for (PlatoPrincipal plato : platosPrincipales) {
            total += plato.getPrecio();
        }
        for (Acompanamiento acomp : acompanamientos) {
            total += acomp.getPrecio();
        }
        for (Postre postre : postres) {
            total += postre.getPrecio();
        }
        return total;
    }
}
