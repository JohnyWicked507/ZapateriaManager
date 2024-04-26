import java.util.Scanner;

public class Main {
    static class Producto {
        String nombre;
        int cantidadInicial;
        int cantidadVendida;
        int cantidadDisponible;

        public Producto(String nombre, int cantidadInicial) {
            this.nombre = nombre;
            this.cantidadInicial = cantidadInicial;
            this.cantidadVendida = 0;
            this.cantidadDisponible = cantidadInicial;
        }

        public void vender(int cantidad) {
            if (cantidadDisponible >= cantidad) {
                cantidadDisponible -= cantidad;
                cantidadVendida += cantidad;
                System.out.println("Venta realizada: " + cantidad + " unidades de " + nombre);
            } else {
                System.out.println("No hay suficiente stock para realizar esta venta.");
            }
        }

        public void duplicarInventario() {
            cantidadInicial *= 2;
            cantidadDisponible = cantidadInicial - cantidadVendida;
            System.out.println("Inventario de " + nombre + " duplicado.");
        }

        public void mostrarInformacion() {
            System.out.println("Producto: " + nombre);
            System.out.println("Cantidad inicial: " + cantidadInicial);
            System.out.println("Cantidad vendida: " + cantidadVendida);
            System.out.println("Cantidad disponible: " + cantidadDisponible);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producto[] inventario = new Producto[3];

        for (int i = 0; i < inventario.length; i++) {
            System.out.println("Ingrese información del producto " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Cantidad inicial: ");
            int cantidadInicial = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            inventario[i] = new Producto(nombre, cantidadInicial);
        }

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Vender producto");
            System.out.println("2. Duplicar inventario");
            System.out.println("3. Mostrar información del inventario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número de producto a vender: ");
                    int productoIndex = scanner.nextInt();
                    System.out.print("Ingrese la cantidad a vender: ");
                    int cantidadVenta = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    inventario[productoIndex - 1].vender(cantidadVenta);
                    break;
                case 2:
                    System.out.print("Ingrese el número de producto a duplicar: ");
                    int productoDuplicar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    inventario[productoDuplicar - 1].duplicarInventario();
                    break;
                case 3:
                    for (Producto producto : inventario) {
                        producto.mostrarInformacion();
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
