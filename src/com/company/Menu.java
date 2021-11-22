package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    ManejadorProyecto manejador;
    Scanner sc = new Scanner(System.in);

    public Menu(){
        Scanner sc = new Scanner(System.in);
        ManejadorProyecto manejador = new ManejadorProyecto();
        System.out.println("Agregue un proyecto para empezar");
        System.out.println("Ingrese un tema para el proyecto: ");
        String tema = sc.next();
        manejador.agregarProyecto(new Proyecto(tema));
        menuPrincipal(manejador);
    }

    public void menuPrincipal(ManejadorProyecto manejador){
        Scanner sc = new Scanner(System.in);
        String input;
        while(true) {
            while (true) {
                System.out.println("Seleccione que desea hacer:" +
                        "\n1. ver proyectos" +
                        "\n2. modificar pomodoro" +
                        "\n3. salir");
                input = sc.next();
                if (input.equals("1") || input.equals("2") || input.equals("3")) break;
                System.out.println("Input incorrecto, seleccione 1, 2 o 3");
            }
            if (input.equals("1")) {
                manejador.abrirProyecto();
            } else if(input.equals("2")){
                editarPomodoro();
            }
            else System.exit(1);
        }
    }

    public void editarPomodoro(){

        boolean salir = false;
        int opcion;
        Cronometro pomodoro = manejador.getPomodoro();

        while (!salir) {

            System.out.println("1. Cambiar tiempo de actividad");
            System.out.println("2. Cambiar tiempo descanso corto");
            System.out.println("3. Cambiar tiempo de descanso largo");
            System.out.println("4. Cambiar número de ciclos");
            System.out.println("5. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el tiempo de actividad: \n");
                        int num = sc.nextInt();
                        pomodoro.modificarTiempoDeActividad(num);
                        break;
                    case 2:
                        System.out.println("Ingrese el tiempo de descanso corto: \n");
                        int num1 = sc.nextInt();
                        pomodoro.modificarTiempoDeDescansoCorto(num1);
                        break;
                    case 3:
                        System.out.println("Ingrese el tiempo de descanso largo: \n");
                        int num2 = sc.nextInt();
                        pomodoro.modificarTiempoDeDescansoLargo(num2);
                        break;
                    case 4:
                        System.out.println("Ingrese el número de ciclos deldescanso largo: \n");
                        int num3 = sc.nextInt();
                        pomodoro.modificarNumeroDeCiclosParaDescansoLargo(num3);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }

}

}