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

    @Override
    public String toString() {
        return "Proyecto{" +
                "tema='" + tema + '\'' +
                ", lista=" + lista +
                '}';
    }
}
