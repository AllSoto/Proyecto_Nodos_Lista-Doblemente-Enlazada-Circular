# Examen Parcial 2 - Estructuras de Datos

## INformacion 
- Nombre: Alberto Jose Soto Zuñiga
- Carné: 201902254
- Curso: Estructuras de Datos
- Catedrático:Ing. Brandon Chitay

## Descripción del Proyecto
Este proyecto consiste en la implementación de una Lista Doblemente Enlazada Circular en Java. 
Se desarrollaron las operaciones de insertar al inicio, insertar al final, eliminar al inicio, eliminar al final, buscar un elemento e imprimir la lista, además de un menú interactivo para probar cada función.

## Video Explicativo
https://drive.google.com/drive/folders/1YuQ3bXq2zfnhvipzRVN8D5hz1Z5wHtG1?usp=sharing


## Repositorio en Github
Repositorio: https://github.com/AllSoto/Proyecto_Nodos_Lista-Doblemente-Enlazada-Circular.git

## Instrucciones de Compilación y Ejecución
```bash
java Nodo.java ListaDobleCircular.java Main.java
correr 
java Main

##Codigo##

## Nodo.java ##
public class Nodo {
    int dato;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}

## ListaDobleCircular.java ##
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

## Main.java ##
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


## Resultados
PS F:\tareas u\parcial 2\Proyecto_Nodos>  & 'C:\Program Files\Java\jdk-17\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\Alberto\AppData\Roaming\Code\User\workspaceStorage\6c3c28b6e9f5c0636af49e27ad355f45\redhat.java\jdt_ws\Proyecto_Nodos_24e507e5\bin' 'Main'
========================================
 LISTA DOBLEMENTE ENLAZADA CIRCULAR     
========================================
1. Insertar al inicio
2. Insertar al final
3. Eliminar al inicio
4. Eliminar al final
5. Buscar elemento
6. Imprimir lista
7. Salir
========================================
Seleccione una opción:

## PASO 1 ##
## Insertamos un dato en --Insertar al inicio 
## En este caso insertaremos el numero 10

========================================
 LISTA DOBLEMENTE ENLAZADA CIRCULAR
========================================
1. Insertar al inicio
2. Insertar al final
3. Eliminar al inicio
4. Eliminar al final
5. Buscar elemento
6. Imprimir lista
7. Salir
========================================
Seleccione una opción: 1
Ingrese el dato a insertar al inicio: 10
Elemento insertado al inicio correctamente.


## PASO 2 ##
## Insertamos un dato en --Insertar al final 
## Insertaremos el numero 20

========================================
 LISTA DOBLEMENTE ENLAZADA CIRCULAR
========================================
1. Insertar al inicio
2. Insertar al final
3. Eliminar al inicio
4. Eliminar al final
5. Buscar elemento
6. Imprimir lista
7. Salir
========================================
Seleccione una opción: 2
Ingrese el dato a insertar al final: 20


## PASO 3 ##
## Insertamos un nuevo dato en --Insertar al inicio
## En este caso INsertamos el numero 5

 LISTA DOBLEMENTE ENLAZADA CIRCULAR
========================================
1. Insertar al inicio
2. Insertar al final
3. Eliminar al inicio
4. Eliminar al final
5. Buscar elemento
6. Imprimir lista
7. Salir
========================================
Seleccione una opción: 1
Ingrese el dato a insertar al inicio: 5
Elemento insertado al inicio correctamente.
Lista: 5 <-> 10 <-> 20 <-> (circular -> 5)


## PASO 4 ##
## Buscamos un elemento en este caso el numero 10 
## Si el elemento esta insertado lo mostrara como: Elemento encontrado.
LISTA DOBLEMENTE ENLAZADA CIRCULAR
========================================
1. Insertar al inicio
2. Insertar al final
3. Eliminar al inicio
4. Eliminar al final
5. Buscar elemento
6. Imprimir lista
7. Salir
========================================
Seleccione una opción: 5
Ingrese el dato a buscar: 10
Resultado: Elemento encontrado.

## Si el elemento no esta insertado lo mostrara como: Elemneto no encontrado.

 LISTA DOBLEMENTE ENLAZADA CIRCULAR
========================================
1. Insertar al inicio
2. Insertar al final
3. Eliminar al inicio
4. Eliminar al final
5. Buscar elemento
6. Imprimir lista
7. Salir
========================================
Seleccione una opción: 5                                                            
Ingrese el dato a buscar: 7
Resultado: Elemento no encontrado.

## PASO 5 ##
## Eliminamos al inicio en este caso eliminare el numero 5 ya que este es el dato que se encuentra al inicio.

LISTA DOBLEMENTE ENLAZADA CIRCULAR
========================================
1. Insertar al inicio
2. Insertar al final
3. Eliminar al inicio
4. Eliminar al final
5. Buscar elemento
6. Imprimir lista
7. Salir
========================================
Seleccione una opción: 3
Elemento eliminado al inicio correctamente.
Lista: 10 <-> 20 <-> (circular -> 10)

## PASO 6 ##
## Eliminamos al Final en este caso eliminare el numero 20 ya que este es el dato que se encuentra al Final.

 LISTA DOBLEMENTE ENLAZADA CIRCULAR
========================================
1. Insertar al inicio
2. Insertar al final
3. Eliminar al inicio
4. Eliminar al final
5. Buscar elemento
6. Imprimir lista
7. Salir
========================================
Seleccione una opción: 4
Elemento eliminado al final correctamente.
Lista: 10 <-> 5 <-> (circular -> 10)

## PASO 7 ##
## Por ultimo podemos imprimir lo que es un listado con todos los datos insertados.

========================================
 LISTA DOBLEMENTE ENLAZADA CIRCULAR
========================================
1. Insertar al inicio
2. Insertar al final
3. Eliminar al inicio
4. Eliminar al final
5. Buscar elemento
6. Imprimir lista
7. Salir
========================================
Seleccione una opción: 6
Lista: 5 <-> 10 <-> 15 <-> 20 <-> 25 <-> (circular -> 5)

## Con esto se evidencia que el codigo Corre correctamente ##
## Adiciona se adjunta un PDF con las capturas del codigo al igual que el video ##
