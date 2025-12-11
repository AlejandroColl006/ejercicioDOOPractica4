import model.GestorDatos;
import model.Marca;
import model.Movil;
import model.Televisor;

public class Main {
    public static void main(String[] args) {

        // =============================
        // 1. Crear gestor de datos
        // =============================
        GestorDatos gestor = new GestorDatos();

        try {
            // =============================
            // 2. Se añade Marca (+0,5)
            // =============================
            Marca sony = new Marca("Sony", "Japón", 10000);
            Marca samsung = new Marca("Samsung", "Corea", 15000);

            gestor.agregarMarca(sony);
            gestor.agregarMarca(samsung);

            // =============================
            // 3. Se añade Televisor (+0,5)
            // =============================
            Televisor tv1 = new Televisor("TV001", 550.0, sony, 55, "LED");
            Televisor tv2 = new Televisor("TV002", 750.0, samsung, 65, "OLED");

            gestor.agregarTelevisor(tv1);
            gestor.agregarTelevisor(tv2);

            // =============================
            // 4. Se añade Móvil (+0,5)
            // =============================
            Movil m1 = new Movil("M001", 300.0, sony, 4000, 6.5);
            Movil m2 = new Movil("M002", 520.0, samsung, 5000, 6.8);

            gestor.agregarMovil(m1);
            gestor.agregarMovil(m2);

        } catch (Exception e) {
            System.out.println("ERROR al añadir datos: " + e.getMessage());
        }

        // ======================================================
        // 5. Gestión de Excepciones (+1)
        //    Probamos añadir algo incorrecto para comprobarlo
        // ======================================================
        try {
            Movil mError = new Movil("MERR", -10, new Marca("X","Y",0), 0, 0);
            gestor.agregarMovil(mError);
        } catch (Exception e) {
            System.out.println("Excepción controlada: " + e.getMessage());
        }

        // ======================================================
        // 6. Búsquedas necesarias (Marcas, Televisores, Móviles)
        // ======================================================

        // Se buscan marcas (+1)
        System.out.println("\nBuscando marca 'Sony':");
        Marca buscadaMarca = gestor.buscarMarca("Sony");
        if (buscadaMarca != null) System.out.println(buscadaMarca);
        else System.out.println("No encontrada");

        // Se busca Televisor (+1)
        System.out.println("\nBuscando televisor 'TV001':");
        Televisor buscadoTV = gestor.buscarTelevisor("TV001");
        if (buscadoTV != null) System.out.println(buscadoTV);
        else System.out.println("No encontrado");

        // Se busca Móvil (+1)
        System.out.println("\nBuscando móvil 'M001':");
        Movil buscadoMovil = gestor.buscarMovil("M001");
        if (buscadoMovil != null) System.out.println(buscadoMovil);
        else System.out.println("No encontrado");

        // ======================================================
        // 7. Mostrar Marcas (+0,5)
        // ======================================================
        System.out.println("\n--- MOSTRAR MARCAS ---");
        gestor.mostrarMarcas();
