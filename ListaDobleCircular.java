public class ListaDobleCircular {
    private Nodo head;

    public ListaDobleCircular() {
        head = null;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (head == null) {
            nuevoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior = nuevoNodo;
            head = nuevoNodo;
        } else {
            Nodo ultimo = head.anterior;

            nuevoNodo.siguiente = head;
            nuevoNodo.anterior = ultimo;
            ultimo.siguiente = nuevoNodo;
            head.anterior = nuevoNodo;
            head = nuevoNodo;
        }

        System.out.println("Elemento insertado al inicio correctamente.");
    }

    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (head == null) {
            nuevoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior = nuevoNodo;
            head = nuevoNodo;
        } else {
            Nodo ultimo = head.anterior;

            nuevoNodo.siguiente = head;
            nuevoNodo.anterior = ultimo;
            ultimo.siguiente = nuevoNodo;
            head.anterior = nuevoNodo;
        }

        System.out.println("Elemento insertado al final correctamente.");
    }

    public void eliminarAlInicio() {
        if (head == null) {
            System.out.println("Error: la lista está vacía.");
            return;
        }

        if (head.siguiente == head) {
            head = null;
        } else {
            Nodo ultimo = head.anterior;
            head = head.siguiente;
            head.anterior = ultimo;
            ultimo.siguiente = head;
        }

        System.out.println("Elemento eliminado al inicio correctamente.");
    }

    public void eliminarAlFinal() {
        if (head == null) {
            System.out.println("Error: la lista está vacía.");
            return;
        }

        if (head.siguiente == head) {
            head = null;
        } else {
            Nodo ultimo = head.anterior;
            Nodo penultimo = ultimo.anterior;

            penultimo.siguiente = head;
            head.anterior = penultimo;
        }

        System.out.println("Elemento eliminado al final correctamente.");
    }

    public boolean buscar(int valorBuscado) {
        if (head == null) {
            return false;
        }

        Nodo actual = head;

        do {
            if (actual.dato == valorBuscado) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != head);

        return false;
    }

    public void imprimir() {
        if (head == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo actual = head;
        System.out.print("Lista: ");

        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != head);

        System.out.println("(circular -> " + head.dato + ")");
    }
}