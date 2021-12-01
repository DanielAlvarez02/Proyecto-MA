import com.company.Cronometro;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class PomodoroParametrizadoTest {
    private int expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{2});
        objects.add(new Object[]{8});
        objects.add(new Object[]{9});
        objects.add(new Object[]{7});
        objects.add(new Object[]{1});
        objects.add(new Object[]{5});
        objects.add(new Object[]{3});
        return objects;
    }

    public PomodoroParametrizadoTest(int expected) {
        this.expected = expected;
    }

    @Test
    public void give_numero_de_ciclos_when_numeroDeCiclos_modified_then_ok() {
        Cronometro pomodoro = new Cronometro();
        pomodoro.modificarNumeroDeCiclosParaDescansoLargo(expected);
        assertEquals(expected, pomodoro.getNumeroDeCiclosParaDescansoLargo());

        //HEAD
    }
}
