package com.company;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

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
    

}
