package model;

public class Televisor extends ArticuloElectronico {

    private int pulgadas;
    private String tipoPantalla; // LED, QLED, OLED, QNED

    public Televisor(String nombre, double precio, Marca marca, int pulgadas, String tipoPantalla) {
        super(nombre, precio, marca);

        tipoPantalla = tipoPantalla.toUpperCase();

        if (!tipoPantalla.equals("LED") &&
                !tipoPantalla.equals("QLED") &&
                !tipoPantalla.equals("OLED") &&
                !tipoPantalla.equals("QNED")) {

            throw new IllegalArgumentException("Tipo de pantalla inválido.");
        }

        this.pulgadas = pulgadas;
        this.tipoPantalla = tipoPantalla;
    }

    @Override
    public void mostrar() {
        System.out.println("Televisor: " + nombre +
                " | Precio: " + precio +
                " | Marca: " + marca.getNombre() +
                " | Pulgadas: " + pulgadas +
                " | Pantalla: " + tipoPantalla);
    }
}

