package model;

import java.util.ArrayList;
import java.util.Collections;

public class GestorDatos {

    private ArrayList<Marca> marcas = new ArrayList<>();
    private ArrayList<ArticuloElectronico> articulos = new ArrayList<>();

    public void añadirMarca(Marca m) {
        marcas.add(m);
    }

    public Marca buscarMarca(String nombre, String pais) {
        for (Marca m : marcas) {
            if (m.getNombre().equalsIgnoreCase(nombre)
                    && m.getPais().equalsIgnoreCase(pais)) {
                return m;
            }
        }
        return null;
    }

    public void añadirArticulo(ArticuloElectronico art) {
        articulos.add(art);
    }

    public ArrayList<Marca> getMarcasOrdenadas() {
        ArrayList<Marca> ordenadas = new ArrayList<>(marcas);
        Collections.sort(ordenadas);
        return ordenadas;
    }

    public ArrayList<ArticuloElectronico> getArticulosOrdenados() {
        ArrayList<ArticuloElectronico> ordenados = new ArrayList<>(articulos);
        ordenados.sort((a, b) -> {
            int c1 = a.getMarca().getNombre().compareToIgnoreCase(b.getMarca().getNombre());
            if (c1 != 0) return c1;

            int c2 = Double.compare(a.getPrecio(), b.getPrecio());
            if (c2 != 0) return c2;

            return a.getNombre().compareToIgnoreCase(b.getNombre());
        });
        return ordenados;
    }
}

