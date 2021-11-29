import com.company.Cronometro;
import com.company.Proyecto;
import com.company.Tarea;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import static org.junit.Assert.*;

public class PruebaCronometro {
    // 8 test unitarios con assert
    // 2 test unitarios con mocks
    // 2 test unitarios con parametros
    // 4 refactorizaciones


    //Juan
    // Mocks + ciclos descanso largo

    // Renato
    // 3 de abajo xd

    //Efra
    // agregar / eliminar tareas
    // 1 con parametros

    // Adri
    //  give_same_Cronometro_when_paused_then_ok
    //  buscar tarea: que retorne la tarea
    // 1 con parametros

    @Test
    public void give_same_Cronometro_when_modified_then_ok(){
        Cronometro pomodoro = new Cronometro();

        int nCEsperado = 2;
        pomodoro.modificarNumeroDeCiclosParaDescansoLargo(nCEsperado);
        assertEquals(nCEsperado, pomodoro.getNumeroDeCiclosParaDescansoLargo());


        int tiempoAEsperado = 5*60;
        pomodoro.modificarTiempoDeActividad(tiempoAEsperado);


        pomodoro.modificarTiempoDeDescansoLargo(6*60);

        pomodoro.modificarTiempoDeDescansoCorto(7*60);
    }


    //assertEquals
    //assertNotEquals


    @Test
    public void give_lista_de_tareas_when_agregarTarea_then_ok(){
        Proyecto proyecto = new Proyecto();
        Tarea tarea = new Tarea("Editar Perfil", "Cambiar los datos de mi perfil", 20);
        proyecto.agregarTarea(tarea);

        Tarea tareaEsperada = new Tarea("Editar Perfil", "Cambiar los datos de mi perfil", 25);
        LinkedList listaEsperada = new LinkedList<Tarea>();
        listaEsperada.add(tareaEsperada);

        assertNotEquals(listaEsperada, proyecto.getLista());

    }

    @Test
    public void give_lista_de_tareas_when_eliminarTarea_then_ok(){
        Proyecto proyecto = new Proyecto("Tareas diarias");
        Tarea tarea = new Tarea("Editar Perfil", "Cambiar los datos de mi perfil", 20);
        proyecto.agregarTarea(tarea);
        proyecto.eliminarTarea("Editar Perfil");
        assertTrue(proyecto.getLista().isEmpty());
    }

    //assertSame
    //assertNotSame

    // assertFalse
    // assertTrue(

    //assertNotNull

    @Test
    public void give_same_Cronometro_when_paused_then_ok(){
    }
}
