import com.company.Cronometro;
import org.junit.Test;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import static org.junit.Assert.*;

public class PruebaCronometro {
    // 8 test unitarios con assert
    // 2 test unitarios con mocks
    // 2 test unitarios con parametros
    // 4 refactorizaciones



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

    @Test
    public void give_same_Cronometro_when_paused_then_ok(){
    }
}
