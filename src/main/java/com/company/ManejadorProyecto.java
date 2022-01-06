package com.company;
import java.util.*;

public class ManejadorProyecto {
    private HashMap <String,Proyecto> proyectos;
    Cronometro pomodoro;
    BaseDeDatos bdd;

    public ManejadorProyecto() {
        proyectos = new HashMap<>();
        pomodoro = new Cronometro();
        bdd = new BaseDeDatos();
    }

    public void agregarProyecto(Proyecto proyecto){
        proyectos.put(proyecto.getTema(),proyecto);
    }

    public Proyecto buscarProyecto(String nombreProyecto){
        return proyectos.get(nombreProyecto);
    }
    public void eliminarProyecto(String nombreProyecto){
        proyectos.remove(nombreProyecto);
    }

    public boolean guardarProyectos(String username){
        try {
            return bdd.guardarDatosDeUsuario(username, proyectos);
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean cargarProyectos(String username){
        try {
            HashMap<String,Proyecto> proyectosObtenidos = bdd.obtenerDatosDeUsuario(username);
            if(proyectos != null){
                this.proyectos = proyectosObtenidos;
                return true;
            }
            return false;
        }
        catch (Exception e){
            return false;
        }
    }
        
    public Cronometro getPomodoro() {
        return pomodoro;
    }

    public HashMap<String,Proyecto> getProyectos() {
        return proyectos;
    }
}
