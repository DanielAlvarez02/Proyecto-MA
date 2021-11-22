package com.company;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Menu {
    ManejadorProyecto manejador;
    Scanner sc = new Scanner(System.in);

    public Menu() {
        ManejadorProyecto manejador = new ManejadorProyecto();
        String tema = ingresoDeDatos("Agregue un proyecto para empezar \nIngrese un tema para el proyecto: "
                ,"Ingrese un nombre distinto de q"
                , s -> !s.equals("q"));
        manejador.agregarProyecto(new Proyecto(tema));
        menuPrincipal(manejador);
    }

    private String ingresoDeDatos(String mensaje, String mensajeDeError, Predicate<String> validacion) {
        while (true) {
            System.out.println(mensaje);
            String input = sc.next();
            if (validacion == null) return input;
            else if (validacion.test(input)) return input;
            System.out.println(mensajeDeError);
        }
    }

    public void menuPrincipal(ManejadorProyecto manejador) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            input = ingresoDeDatos(" que desea hacer:\n1. ver proyectos \n2. modificar pomodoro\n3. salir"
                    , "\"Input incorrecto, seleccione 1, 2 o 3\""
                    , s -> (s.equals("1") || s.equals("2") || s.equals("3")));
            if (input.equals("1")) {
                abrirProyecto();
            } else if (input.equals("2")) {
                editarPomodoro();
            } else System.exit(1);
        }
    }

    public void editarPomodoro() {

        boolean salir = false;
        int opcion;
        Cronometro pomodoro = manejador.getPomodoro();

        String input = ingresoDeDatos("Escribe una de las opciones\n 1. Cambiar tiempo de actividad \n 2. Cambiar tiempo descanso corto " +
                        "\n 3. Cambiar tiempo de descanso largo \n 4. Cambiar número de ciclos \n 5. Salir"
                ,"Inserta un número entre 1 y 5"
                , s -> (s.matches("1|2|3|4|5")));

        switch (input) {
            case "1":
                System.out.println("Ingrese el tiempo de actividad: \n");
                int num = sc.nextInt();
                pomodoro.modificarTiempoDeActividad(num);
                break;
            case "2":
                System.out.println("Ingrese el tiempo de descanso corto: \n");
                int num1 = sc.nextInt();
                pomodoro.modificarTiempoDeDescansoCorto(num1);
                break;
            case "3":
                System.out.println("Ingrese el tiempo de descanso largo: \n");
                int num2 = sc.nextInt();
                pomodoro.modificarTiempoDeDescansoLargo(num2);
                break;
            case "4":
                System.out.println("Ingrese el número de ciclos deldescanso largo: \n");
                int num3 = sc.nextInt();
                pomodoro.modificarNumeroDeCiclosParaDescansoLargo(num3);
                break;
            case "5":
                salir = true;
                break;
            default:
                System.out.println();
        }

    }

    public void abrirProyecto() {
        LinkedList<Proyecto> proyectos = manejador.getProyectos();
        while (true) {
            System.out.println("A continuación se muestran todos los proyecto: \n");
            System.out.println(proyectos.toString());

            String input = ingresoDeDatos("Por favor ingrese el nombre del proyecto que desea abrir o presione q para salir: \n"
                    ,"ingrese un nombre valido o q para salir"
                    ,s -> manejador.buscarProyecto(s) != null);

            if (input.equals("q")) return;
            menuProyecto(manejador.buscarProyecto(input));
        }
    }

    public void menuProyecto(Proyecto proyecto) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        String input = ingresoDeDatos("Menú Proyecto\n1. Agregar tarea\n2. Buscar tarea"
                        + "\n3. Abrir tarea\n4. Eliminar tarea\n5. Salir\nEscoge una opción\n"
                , "Solo se aceptan números entre 1 y 5"
                , s -> (s.matches("1|2|3|4|5")) );

        switch (input) {
            case "1":
                System.out.println("Ingrese el título de la tarea: \n");
                String titulo = sn.nextLine();
                System.out.println("Ingrese la descripción de la tarea: \n");
                String descripcion = sn.nextLine();
                System.out.println("Ingrese el tiempo aproximado de la tarea: \n");
                double tiempo = sn.nextDouble();
                Tarea tarea = new Tarea(titulo, descripcion, tiempo);
                proyecto.agregarTarea(tarea);
                break;
            case "2":
                System.out.println("Ingrese el nombre de la tarea: \n");
                titulo = sn.nextLine();
                proyecto.buscarTarea(titulo);
                break;
            case "3":
                System.out.println("Ingrese el nombre de la tarea: \n");
                titulo = sn.nextLine();
                Tarea tarea1 = new Tarea(titulo);
                proyecto.abrirTarea(tarea1);
                break;
            case "4":
                System.out.println("Ingrese el nombre de la tarea: \n");
                titulo = sn.nextLine();
                proyecto.eliminarTarea(titulo);
                break;
            case "5":
                break;
            default:
                System.out.println();
        }
    }


}