package model;

public class Movil extends ArticuloElectronico {

    private int ramGB;
    private String sistemaOperativo; // Android o iOS

    public Movil(String nombre, double precio, Marca marca, int ramGB, String sistemaOperativo) {
        super(nombre, precio, marca);

        sistemaOperativo = sistemaOperativo.toUpperCase();

        if (!sistemaOperativo.equals("ANDROID") && !sistemaOperativo.equals("IOS")) {
            throw new IllegalArgumentException("Sistema operativo inválido.");
        }

        this.ramGB = ramGB;
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public void mostrar() {
        System.out.println("Móvil: " + nombre +
                " | Precio: " + precio +
                " | Marca: " + marca.getNombre() +
                " | RAM: " + ramGB +
                "GB | SO: " + sistemaOperativo);
    }
}
