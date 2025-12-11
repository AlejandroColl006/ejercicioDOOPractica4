package model;

public abstract class ArticuloElectronico implements Mostrable {

    protected String nombre;
    protected double precio;
    protected Marca marca;

    public ArticuloElectronico(String nombre, double precio, Marca marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Marca getMarca() {
        return marca;
    }
    @Override
    public abstract void mostrar();
}

