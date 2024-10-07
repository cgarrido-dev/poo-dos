package com.deliciososabor.menu;

import com.deliciososabor.platos.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        PlatoPrincipal salmon = new PlatoPrincipal("Filete de Salmon", 10990);
        salmon.setDescripcion("Delisioso Filete de salmon fresco.");
        salmon.agregarOpcionExtra(new OpcionExtra("Agregar doble porción de queso"));
        salmon.agregarOpcionExtra(new OpcionExtra("Agregar Arroz"));

        Acompanamiento arroz = new Acompanamiento("Arroz", 2990);
        arroz.agregarOpcionExtra(new OpcionExtra("Agregar Verduras"));

        Postre helado = new Postre("Helado de Vainilla", 1990);

        menu.agregarPlato(salmon);
        menu.agregarPlato(arroz);
        menu.agregarPlato(helado);

        menu.imprimirMenu();
    }
}
