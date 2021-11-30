package com.company;

import java.util.*;

public class Proyecto {
    String tema;
    HashMap<String,Tarea> tareas;

    public Proyecto(String tema) {
        this.tema = tema;
        tareas = new HashMap<>();
    }

    public Proyecto(){
        tema="sin tema";
        tareas = new HashMap<>();
    }

    public String getTema() {
        return tema;
    }

    public void ejecutar(){

    }
    public void agregarTarea(Tarea tarea){
        tareas.put(tarea.getTitulo(),tarea);
    }

    public void abrirTarea(Tarea tarea){
        tarea.toString();
    }
    public Tarea buscarTarea(String tituloDeTarea){
        return tareas.get(tituloDeTarea);
    }

    public void eliminarTarea(String tituloDeTarea){
        tareas.remove(tituloDeTarea);
    }
    public void pausar(){

    }
    public void detener(){

    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "tema='" + tema + '\'' +
                ", lista=" + tareas +
                '}';
    }
}
