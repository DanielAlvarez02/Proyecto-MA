import com.company.Cronometro;
import com.company.Proyecto;
import com.company.Tarea;
import org.junit.Test;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
    public void give_same_Cronometro_when_numeroDeCiclos_modified_then_ok() {
        Cronometro pomodoro = new Cronometro();
        int nCEsperado = 2;

        pomodoro.modificarNumeroDeCiclosParaDescansoLargo(nCEsperado);
        assertEquals(nCEsperado, pomodoro.getNumeroDeCiclosParaDescansoLargo());

        //HEAD
    }

    @Test
    public void give_same_Cronometro_when_modified_activity_time_then_ok(){
        Cronometro pomodoro = new Cronometro();
        int tiempoAEsperado = 5*60;

        pomodoro.modificarTiempoDeActividad(tiempoAEsperado);
        assertEquals(tiempoAEsperado, pomodoro.getTiempoDeActividad());
    }

    @Test
    public void give_same_Cronometro_when_modified_long_rest_time_then_ok(){
        Cronometro pomodoro = new Cronometro();
        int tiempoAEsperado = 5*60;
        
        pomodoro.modificarTiempoDeDescansoLargo(tiempoAEsperado);
        assertEquals(tiempoAEsperado, pomodoro.getTiempoDeDescansoLargo());
    }

    @Test
    public void give_same_Cronometro_when_modified_short_rest_time_then_ok(){
        Cronometro pomodoro = new Cronometro();
        int tiempoAEsperado = 5*60;

        pomodoro.modificarTiempoDeDescansoCorto(tiempoAEsperado);
        assertEquals(tiempoAEsperado, pomodoro.getTiempoDeDescansoCorto());
    }

    @Test
    public void give_same_Tarea_when_searched_then_ok(){
        Tarea tarea = new Tarea("ejemplo");
        Proyecto proyecto = new Proyecto();

        proyecto.agregarTarea(tarea);

        assertTrue(tarea.equals(proyecto.buscarTarea("tarea")));
    };


//        int tiempoAEsperado = 5*60;
//        pomodoro.modificarTiempoDeActividad(tiempoAEsperado);
//
//
//        pomodoro.modificarTiempoDeDescansoLargo(6*60);
//
//        pomodoro.modificarTiempoDeDescansoCorto(7*60);
//    }


        //3ee902437874f2157d71d43b21375fb0b1ace391
    //assertEquals
    //assertNotEquals

    //assertSame
    //assertNotSame

    // assertFalse
    // assertTrue(

    //assertNotNull

    public void give_same_time_in_Cronometro_when_paused_then_ok(){
        Cronometro pomodoro = new Cronometro();
        pomodoro.iniciarCiclos();
        int pausa1 = pomodoro.getSegundosRestantesActuales();
        pomodoro.pausarCiclos();
        int pausa2 = pomodoro.getSegundosRestantesActuales();
        assertTrue(pausa1 == pausa2);
    }

    public void give_countdown_in_Cronometro_when_iniciarCiclos_then_ok(){
        Cronometro mockCronometro = mock(Cronometro.class);
    }
}
