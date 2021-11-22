package com.company;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManejadorProyecto manejador = new ManejadorProyecto();
        System.out.println("Agregue un proyecto para empezar");
        System.out.println("Ingrese un tema para el proyecto: ");
        String tema = sc.nextLine();
        manejador.agregarProyecto(new Proyecto(tema));
    }
}
