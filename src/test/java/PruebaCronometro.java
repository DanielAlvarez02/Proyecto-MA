import com.company.*;
import org.junit.Test;
import java.util.*;
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
    public void give_same_time_in_Cronometro_when_paused_then_ok(){
        Cronometro pomodoro = new Cronometro();
        pomodoro.iniciarCiclos();
        int pausa1 = pomodoro.getSegundosRestantesActuales();
        pomodoro.pausarCiclos();
        int pausa2 = pomodoro.getSegundosRestantesActuales();
        assertTrue(pausa1 == pausa2);
    }

    @Test
    public void load_data_from_database_when_cargarProyectos_then_ok(){
        BaseDeDatos bdd = mock(BaseDeDatos.class);
        HashMap<String,Proyecto> proyectos = new HashMap<>();

        Proyecto proyecto1 = new Proyecto();
        proyecto1.agregarTarea(new Tarea("tarea 1"));
        proyecto1.agregarTarea(new Tarea("tarea 2"));

        Proyecto proyecto2 = new Proyecto();
        proyecto2.agregarTarea(new Tarea("tarea 3"));
        proyecto2.agregarTarea(new Tarea("tarea 4"));

        proyectos.put(proyecto1.getTema(),proyecto1);
        proyectos.put(proyecto1.getTema(),proyecto2);

        try {
            when(bdd.obtenerDatosDeUsuario("daniel")).thenReturn(proyectos);
        }
        catch (Exception e){

        }

        ManejadorProyecto manejadorProyecto = new ManejadorProyecto();

        manejadorProyecto.cargarProyectos("daniel");

        assertEquals(proyectos, manejadorProyecto.getProyectos());
    }

    @Test
    public void save_data_in_database_when_guardarProyectos_then_ok(){
        BaseDeDatos bdd = mock(BaseDeDatos.class);
        HashMap<String,Proyecto> proyectos = new HashMap<>();

        Proyecto proyecto1 = new Proyecto();
        proyecto1.agregarTarea(new Tarea("tarea 1"));
        proyecto1.agregarTarea(new Tarea("tarea 2"));

        Proyecto proyecto2 = new Proyecto();
        proyecto2.agregarTarea(new Tarea("tarea 3"));
        proyecto2.agregarTarea(new Tarea("tarea 4"));

        proyectos.put(proyecto1.getTema(),proyecto1);
        proyectos.put(proyecto1.getTema(),proyecto2);

        try {
            when(bdd.guardarDatosDeUsuario("daniel",proyectos)).thenReturn(true);
        }
        catch (Exception e){

        }

        ManejadorProyecto manejadorProyecto = new ManejadorProyecto();
        manejadorProyecto.agregarProyecto(proyecto1);
        manejadorProyecto.agregarProyecto(proyecto2);
        assertTrue(manejadorProyecto.guardarProyectos("daniel"));
    }

}
