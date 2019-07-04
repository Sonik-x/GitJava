import core.Station;
import junit.framework.TestCase;
import org.junit.runners.model.TestClass;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRouteCalculator extends TestCase {

    List<Station> groute;


    @Override
    protected void setUp() throws Exception {
        RouteCalculator routeCalculator = Main.getRouteCalculator();


    }

    public void testGetShortestRoute() {
        List<Station> actual = new ArrayList<>();
        List<Station> expected = new ArrayList<>();

///TEST CODE HERE


        assertEquals(expected, actual);
    }




    @Override
    protected void tearDown() throws Exception {


    }
}
