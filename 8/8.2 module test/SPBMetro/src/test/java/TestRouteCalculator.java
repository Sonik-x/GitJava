import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.runners.model.TestClass;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRouteCalculator extends TestCase {


    // заходит тестировщик в бар...


    @Override
    protected void setUp() throws Exception {
        Line green = new Line(1, "green");
        Station green1 = new Station("green 1", green);
        Station green2 = new Station("green 2", green);

        Line blue = new Line(2, "blue");
        Station blue1 = new Station("blue 1", blue);
        Station blue2 = new Station("blue 2", blue);
        Station blue3 = new Station("blue 3", blue);





        StationIndex stationIndex = new StationIndex();
        // INITIALISE

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);


    }




    public void testGetShortestRoute() {
        List<Station> actual = new ArrayList<>();
        List<Station> expected = new ArrayList<>();

///TEST CODE HERE


        assertEquals(expected, actual);
    }

    public void testCalculateDuration() {
        double actual = 0;
        double expected = 0;





        assertEquals(actual, expected);
    }

    public void testGetRouteOnTheLine() {
        List<Station> actual = new ArrayList<>();
        List<Station> expected = new ArrayList<>();

///TEST CODE HERE


        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection() {
        List<Station> actual = new ArrayList<>();
        List<Station> expected = new ArrayList<>();

///TEST CODE HERE


        assertEquals(expected, actual);
    }


    public void testGetRouteWithTwoConnections() {
        List<Station> actual = new ArrayList<>();
        List<Station> expected = new ArrayList<>();

///TEST CODE HERE


        assertEquals(expected, actual);
    }

    public void testGetRouteViaConnectedLine() {
        List<Station> actual = new ArrayList<>();
        List<Station> expected = new ArrayList<>();

///TEST CODE HERE


        assertEquals(expected, actual);
    }

    public void testIsConnected() {
        boolean actual = false;
        boolean expected = true;

///TEST CODE HERE


        assertEquals(expected, actual);
    }








    @Override
    protected void tearDown() throws Exception {


    }
}
