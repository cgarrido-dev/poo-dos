package com.deliciososabor.platos;

public abstract class PlatoBase {
    private String nombre;
    private double precio;
    private String descripcion;

    public PlatoBase(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract void imprimirDetalles();
}
