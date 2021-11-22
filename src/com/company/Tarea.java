package com.company;

public class Tarea {
    String titulo;
    String descripcion;
    boolean estado; // Terminado = true, no terminado = false

    public void modificarTitulo(String titulo){

    }
    public void modificarDescripcion(String descripcion){

    }
    public void modificarEstado(boolean estado){

    }
    public boolean verificarEstado(){
        return false;
    }
    public String getTarea() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
