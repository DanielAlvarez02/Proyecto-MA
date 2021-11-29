import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(value = Parameterized.class)
public class PomodoroParametrizadoTest {
    private int a, b, expected;
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{});

    }
}
