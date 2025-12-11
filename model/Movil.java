package model;

public class Movil extends ArticuloElectronico {

    private int ramGB;
    private double pantallaPulgadas;
    private String sistemaOperativo; // Android o iOS

    public Movil(String nombre, double precio, Marca marca,
                 int ramGB, double pantallaPulgadas, String sistemaOperativo) {

        super(nombre, precio, marca);

        if (ramGB <= 0)
            throw new IllegalArgumentException("La RAM debe ser mayor que 0");

        if (pantallaPulgadas <= 0)
            throw new IllegalArgumentException("Las pulgadas deben ser mayores que 0");

        if (!sistemaOperativo.equalsIgnoreCase("Android") &&
                !sistemaOperativo.equalsIgnoreCase("iOS"))
            throw new IllegalArgumentException("Sistema operativo no válido");

        this.ramGB = ramGB;
        this.pantallaPulgadas = pantallaPulgadas;
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public void mostrar() {
        System.out.println("Móvil: " + nombre +
                " | Precio: " + precio +
                " | Marca: " + marca.getNombre() +
                " | RAM: " + ramGB + "GB" +
                " | Pantalla: " + pantallaPulgadas + "''" +
                " | SO: " + sistemaOperativo);
    }
}
