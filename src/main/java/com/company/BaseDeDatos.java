package com.company;

import java.io.IOException;
import java.util.HashMap;

public class BaseDeDatos {
    public boolean guardarDatosDeUsuario(String nombreDeUsuario, HashMap<String,Proyecto> proyectos) throws IOException {
        return true;
    }
    public HashMap<String,Proyecto> obtenerDatosDeUsuario(String nombreDeUsuario) throws IOException{
        return null;
    }
}
