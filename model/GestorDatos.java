package model;

import java.util.ArrayList;
import java.util.Collections;

public class GestorDatos {

    private ArrayList<Marca> marcas = new ArrayList<>();
    private ArrayList<ArticuloElectronico> articulos = new ArrayList<>();

    // ----------- AGREGAR -----------

    public void agregarMarca(Marca m) {
        marcas.add(m);
    }

    public void agregarTelevisor(Televisor t) {
        if (!marcas.contains(t.getMarca()))
            throw new IllegalArgumentException("La marca no existe");

        articulos.add(t);
    }

    public void agregarMovil(Movil m) {
        if (!marcas.contains(m.getMarca()))
            throw new IllegalArgumentException("La marca no existe");

        articulos.add(m);
    }

    // ----------- BUSCAR -----------

    public Marca buscarMarca(String nombre) {
        for (Marca m : marcas) {
            if (m.getNombre().equalsIgnoreCase(nombre))
                return m;
        }
        return null;
    }

    public Televisor buscarTelevisor(String nombre) {
        for (ArticuloElectronico a : articulos) {
            if (a instanceof Televisor && a.getNombre().equalsIgnoreCase(nombre))
                return (Televisor) a;
        }
        return null;
    }

    public Movil buscarMovil(String nombre) {
        for (ArticuloElectronico a : articulos) {
            if (a instanceof Movil && a.getNombre().equalsIgnoreCase(nombre))
                return (Movil) a;
        }
        return null;
    }

    // ----------- MOSTRAR -----------

    public void mostrarMarcas() {
        Collections.sort(marcas);
        for (Marca m : marcas) {
            System.out.println(m);
        }
    }

    public void mostrarArticulos() {
        articulos.sort((a, b) -> {
            int cmpMarca = a.getMarca().getNombre().compareTo(b.getMarca().getNombre());
            if (cmpMarca != 0) return cmpMarca;

            int cmpPrecio = Double.compare(a.getPrecio(), b.getPrecio());
            if (cmpPrecio != 0) return cmpPrecio;

            return a.getNombre().compareTo(b.getNombre());
        });

        for (ArticuloElectronico a : articulos) {
            a.mostrar();
        }
    }
}

