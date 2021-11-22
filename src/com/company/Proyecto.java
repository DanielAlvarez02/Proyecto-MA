package com.company;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Proyecto {
    String tema;
    LinkedList <Tarea> lista;

    public Proyecto(String tema) {
        this.tema = tema;
        lista = new LinkedList<Tarea>();
    }

    public Proyecto(){
        tema=null;
        lista = new LinkedList<Tarea>();
    }

    public String getTema() {
        return tema;
    }

    public void ejecutar(){

    }
    public void agregarTarea(Tarea tarea){
        lista.add(tarea);
    }

    public void abrirTarea(Tarea tarea){
        tarea.toString();
    }
    public void buscarTarea(String tarea){
        Iterator<Tarea> it = lista.iterator();
        while(it.hasNext()){
            String tema = it.next().getTarea();
            if(tema.equalsIgnoreCase(tarea)){
                it.toString();
            }
        }
    }

    public void eliminarTarea(String tarea){
        Iterator<Tarea> it = lista.iterator();
        while(it.hasNext()){
            String tema = it.next().getTarea();
            if(tema.equalsIgnoreCase(tarea)){
                it.remove();
            }
        }
    }
    public void pausar(){

    }
    public void detener(){

    }

    public void menuProyecto(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("Menú Proyecto");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Buscar tarea");
            System.out.println("3. Abrir tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");

            try {
                System.out.println("Escoge una opción");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el título de la tarea: \n");
                        String titulo= sn.nextLine();
                        System.out.println("Ingrese la descripción de la tarea: \n");
                        String descripcion= sn.nextLine();
                        System.out.println("Ingrese el tiempo aproximado de la tarea: \n");
                        double tiempo= sn.nextDouble();
                        Tarea tarea = new Tarea(titulo,descripcion,tiempo);
                        lista.add(tarea);
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre de la tarea: \n");
                        titulo= sn.nextLine();
                        this.buscarTarea(titulo);
                        break;
                    case 3:
                        System.out.println("Ingrese el nombre de la tarea: \n");
                        titulo= sn.nextLine();
                        Tarea tarea1 = new Tarea(titulo);
                        this.abrirTarea(tarea1);
                        break;
                    case 4:
                        System.out.println("Ingrese el nombre de la tarea: \n");
                        titulo= sn.nextLine();
                        this.eliminarTarea(titulo);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo se aceptan números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "tema='" + tema + '\'' +
                ", lista=" + lista +
                '}';
    }
}
