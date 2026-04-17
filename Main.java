import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDobleCircular lista = new ListaDobleCircular();
        int opcion;
        int dato;

        do {
            System.out.println("========================================");
            System.out.println(" LISTA DOBLEMENTE ENLAZADA CIRCULAR");
            System.out.println("========================================");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Eliminar al inicio");
            System.out.println("4. Eliminar al final");
            System.out.println("5. Buscar elemento");
            System.out.println("6. Imprimir lista");
            System.out.println("7. Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el dato a insertar al inicio: ");
                    dato = sc.nextInt();
                    lista.insertarAlInicio(dato);
                    lista.imprimir();
                    break;

                case 2:
                    System.out.print("Ingrese el dato a insertar al final: ");
                    dato = sc.nextInt();
                    lista.insertarAlFinal(dato);
                    lista.imprimir();
                    break;

                case 3:
                    lista.eliminarAlInicio();
                    lista.imprimir();
                    break;

                case 4:
                    lista.eliminarAlFinal();
                    lista.imprimir();
                    break;

                case 5:
                    System.out.print("Ingrese el dato a buscar: ");
                    dato = sc.nextInt();

                    if (lista.buscar(dato)) {
                        System.out.println("Resultado: Elemento encontrado.");
                    } else {
                        System.out.println("Resultado: Elemento no encontrado.");
                    }
                    break;

                case 6:
                    lista.imprimir();
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            System.out.println();

        } while (opcion != 7);

        sc.close();
    }
}