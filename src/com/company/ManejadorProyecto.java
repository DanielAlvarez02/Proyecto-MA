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
    public void abrirProyecto(){

        Scanner sn = new Scanner(System.in);
        while(true) {
            System.out.println("A continuación se muestran todos los proyecto: \n");
            System.out.println(lista.toString());
            System.out.println("Por favor ingrese el nombre del proyecto que desea abrir o presione q para salir: \n");
            String tema = sn.next();
            if(tema.equals("q")) return;
            Proyecto proyectoEncontrado = buscarProyecto(tema);
            if (proyectoEncontrado != null) proyectoEncontrado.menuProyecto();
            else System.out.println("ingrese un nombre valido o q para salir");
        }
    }
    public Proyecto buscarProyecto(String nombreProyecto){
        for(Proyecto proy : this.lista){
            if(proy.getTema().equals(nombreProyecto)){
                return proy;
            }
        }
        return null;
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


    public Cronometro getPomodoro() {
        return pomodoro;
    }
}
