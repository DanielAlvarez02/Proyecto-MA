package com.company;
import java.util.*;

public class ManejadorProyecto {
    private LinkedList <Proyecto> lista;
    Cronometro pomodoro = new Cronometro();

    public ManejadorProyecto() {
        lista = new LinkedList<Proyecto>();
    }

    public void agregarProyecto(Proyecto proyecto){
        lista.add(proyecto);
    }
    public void abrirProyecto(Proyecto proyecto){
        proyecto.toString();
    }
    public void buscarProyecto(String nombreProyecto){
        Iterator <Proyecto>it = lista.iterator();
        while(it.hasNext()){
            String tema = it.next().getTema();
            if(tema.equalsIgnoreCase(nombreProyecto)){
                it.toString();
            }
        }
    }
    public void eliminarProyecto(String nombreProyecto){
        Iterator <Proyecto>it = lista.iterator();
        while(it.hasNext()){
            String tema = it.next().getTema();
            if(tema.equalsIgnoreCase(nombreProyecto)){
                it.remove();
            }

        }
    }
    public void editarPomodoro(){

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("1. Cambiar tiempo de actividad");
            System.out.println("2. Cambiar tiempo descanso corto");
            System.out.println("3. Cambiar tiempo de descanso largo");
            System.out.println("4. Cambiar número de ciclos");
            System.out.println("5. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el tiempo de actividad: \n");
                        int num = sn.nextInt();
                        pomodoro.modificarTiempoDeActividad(num);
                        break;
                    case 2:
                        System.out.println("Ingrese el tiempo de descanso corto: \n");
                        int num1 = sn.nextInt();
                        pomodoro.modificarTiempoDeDescansoCorto(num1);
                        break;
                    case 3:
                        System.out.println("Ingrese el tiempo de descanso largo: \n");
                        int num2 = sn.nextInt();
                        pomodoro.modificarTiempoDeDescansoLargo(num2);
                        break;
                    case 5:
                        System.out.println("Ingrese el número de ciclos deldescanso largo: \n");
                        int num3 = sn.nextInt();
                        pomodoro.modificarNumeroDeCiclosParaDescansoLargo(num3);
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

}
