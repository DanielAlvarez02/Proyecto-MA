package com.company;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void menuPrincipal(ManejadorProyecto manejador){
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
                manejador.editarPomodoro();
            }
            else System.exit(1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManejadorProyecto manejador = new ManejadorProyecto();
        System.out.println("Agregue un proyecto para empezar");
        System.out.println("Ingrese un tema para el proyecto: ");
        String tema = sc.next();
        manejador.agregarProyecto(new Proyecto(tema));
        menuPrincipal(manejador);
    }
}
