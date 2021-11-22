package com.company;

public class Tarea {
    String titulo;
    String descripcion;
    double tiempoAproximado;
    boolean estado; // Terminado = true, no terminado = false

    public Tarea(String titulo) {
        this.titulo = titulo;
    }

    public Tarea(String titulo, String descripcion, double tiempoAproximado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tiempoAproximado = tiempoAproximado;
        this.estado = false;
    }

    public void modificarTitulo(String titulo){
        this.titulo = titulo;
    }
    public void modificarDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void modificarEstado(boolean estado){
        this.estado = estado;
    }
    public boolean verificarEstado(){
        return estado;
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
