import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Producto implements Comparable<Producto> {
    private String nombre;
    private String descripcion;
    private double precio;

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public int compareTo(Producto otroProducto) {
        return Double.compare(this.precio, otroProducto.getPrecio());
    }

    @Override
    public String toString() {
        if (descripcion.contains("Unidad de venta")) {
            return "Nombre: " + nombre + " /// Precio: $" + quitarDecimales(precio) + " /// " + descripcion;
        } else {
            return "Nombre: " + nombre + " /// " + descripcion + " /// Precio: $" + quitarDecimales(precio);
        }
    }

    //Quita los decimales al imprimir
    private String quitarDecimales(double numero) {
        if (numero == (int) numero) {
            return String.format("%d", (int) numero);
        } else {
            return String.format("%s", numero);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = cargarProductos();

        imprimirLista(productos);

        Collections.sort(productos, Collections.reverseOrder());

        System.out.println("=============================");
        System.out.println("Producto más caro: " + productos.get(0).getNombre());
        System.out.println("Producto más barato: " + productos.get(productos.size() - 1).getNombre());
    }

    private static List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Coca-Cola Zero", "Litros: 1.5", 20));
        productos.add(new Producto("Coca-Cola", "Litros: 1.5", 18));
        productos.add(new Producto("Shampoo Sedal", "Contenido: 500ml", 19));
        productos.add(new Producto("Frutillas", "Unidad de venta: kilo", 64));
        return productos;
    }

    private static void imprimirLista(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}