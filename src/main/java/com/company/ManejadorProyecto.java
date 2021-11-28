package com.company;
import java.util.*;

public class ManejadorProyecto {
    private LinkedList <Proyecto> proyectos;
    Cronometro pomodoro = new Cronometro();

    public ManejadorProyecto() {
        proyectos = new LinkedList<Proyecto>();
    }

    public void agregarProyecto(Proyecto proyecto){
        proyectos.add(proyecto);
    }

    public Proyecto buscarProyecto(String nombreProyecto){
        for(Proyecto proy : this.proyectos){
            if(proy.getTema().equals(nombreProyecto)){
                return proy;
            }
        }
        return null;
    }
    public void eliminarProyecto(String nombreProyecto){
        Iterator <Proyecto>it = proyectos.iterator();
        while(it.hasNext()){
            String tema = it.next().getTema();
            if(tema.equalsIgnoreCase(nombreProyecto)){
                it.remove();
            }
        }
    }


    public Cronometro getPomodoro() {
        return pomodoro;
    }

    public LinkedList<Proyecto> getProyectos() {
        return proyectos;
    }
}
