import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.runners.model.TestClass;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRouteCalculator extends TestCase {


    // заходит тестировщик в бар...


    RouteCalculator routeCalculator = null;
    Line green = null;
    Station green1 = null;
    Station green2 = null;

    Line blue = null;
    Station blue1 = null;
    Station blue2 = null;
    Station blue3 = null;

    Line red = null;
    Station red1 = null;
    Station red2 = null;
    Station red3 = null;
    Station red4 = null;

    Line white = null;
    Station white1 = null;
    Station white2 = null;
    Station white3 = null;
    Station white4 = null;
    Station white5 = null;

    Line bubble = null;
    Station bubble1 = null;
    Station bubble2 = null;

    @Override
    protected void setUp() throws Exception {
        green = new Line(1, "green");
        green1 = new Station("green 1", green);
        green2 = new Station("green 2", green);

        blue = new Line(2, "blue");
        blue1 = new Station("blue 1", blue);
        blue2 = new Station("blue 2", blue);
        blue3 = new Station("blue 3", blue);

        red = new Line(3, "red");
        red1 = new Station("red 1", red);
        red2 = new Station("red 2", red);
        red3 = new Station("red 3", red);
        red4 = new Station("red 4", red);

        white = new Line(4, "white");
        white1 = new Station("white 1", white);
        white2 = new Station("white 2", white);
        white3 = new Station("white 3", white);
        white4 = new Station("white 4", white);
        white5 = new Station("white 5", white);

        bubble = new Line(5, "bubble");
        bubble1 = new Station("bubble 1", bubble);
        bubble2 = new Station("surprise!", bubble);

        List<Station> connection1 = new ArrayList<>();
        connection1.add(green2);
        connection1.add(red2);
        connection1.add(blue1);

        List<Station> connection2 = new ArrayList<>();
        connection2.add(blue3);
        connection2.add(white2);

        List<Station> connection3 = new ArrayList<>();
        connection3.add(red4);
        connection3.add(white4);

        List<Station> connectionBubble = new ArrayList<>();
        connectionBubble.add(white5);
        connectionBubble.add(bubble1);


        StationIndex stationIndex = new StationIndex();
        stationIndex.addLine(green);
        stationIndex.addLine(blue);
        stationIndex.addLine(red);
        stationIndex.addLine(white);
        stationIndex.addLine(bubble);
        stationIndex.addStation(green1);
        stationIndex.addStation(green2);
        stationIndex.addStation(blue1);
        stationIndex.addStation(blue2);
        stationIndex.addStation(blue3);
        stationIndex.addStation(red1);
        stationIndex.addStation(red2);
        stationIndex.addStation(red3);
        stationIndex.addStation(red4);
        stationIndex.addStation(white1);
        stationIndex.addStation(white2);
        stationIndex.addStation(white3);
        stationIndex.addStation(white4);
        stationIndex.addStation(white5);
        stationIndex.addStation(bubble1);
        stationIndex.addStation(bubble2);
        stationIndex.addConnection(connection1);
        stationIndex.addConnection(connection2);
        stationIndex.addConnection(connection3);
        stationIndex.addConnection(connectionBubble);


        routeCalculator = new RouteCalculator(stationIndex);


    }


    public void testGetShortestRoute1() {
        List<Station> expected = new ArrayList<>();
        expected.add(green1);

        List<Station> actual = routeCalculator.getShortestRoute(green1, green1);


        assertEquals(expected, actual);
    }


    public void testGetShortestRoute2() {
        List<Station> expected = new ArrayList<>();
        expected.add(green1);
        expected.add(green2);

        List<Station> actual = routeCalculator.getShortestRoute(green1, green2);


        assertEquals(expected, actual);
    }

    public void testGetShortestRoute3() {
        List<Station> expected = new ArrayList<>();
        expected.add(green1);
        expected.add(green2);
        expected.add(blue1);
        expected.add(blue2);
        expected.add(blue3);
        expected.add(white2);

        List<Station> actual = routeCalculator.getShortestRoute(green1, white2);


        assertEquals(expected, actual);
    }

    public void testCalculateDuration1() {
        double expected = 0;

        List<Station> route = new ArrayList<>();
        route.add(green1);
        double actual = RouteCalculator.calculateDuration(route);


        assertEquals(actual, expected);
    }

    public void testCalculateDuration2() {
        double expected = 2.5;

        List<Station> route = new ArrayList<>();
        route.add(green1);
        route.add(green2);
        double actual = RouteCalculator.calculateDuration(route);


        assertEquals(actual, expected);
    }

    public void testCalculateDuration3() {
        double expected = 8.5;

        List<Station> route = new ArrayList<>();
        route.add(green1);
        route.add(green2);
        route.add(red2);
        route.add(red1);
        double actual = RouteCalculator.calculateDuration(route);


        assertEquals(actual, expected);
    }

    public void testCalculateDuration4() {   // здесь 3 пересадки, но коду всё равно, так и надо
        double expected = 23;

        List<Station> route = new ArrayList<>();
        route.add(green1);
        route.add(green2);
        route.add(red2);
        route.add(red3);
        route.add(red4);
        route.add(white4);
        route.add(white5);
        route.add(bubble1);
        route.add(bubble2);
        double actual = RouteCalculator.calculateDuration(route);


        assertEquals(actual, expected);
    }


    // остальные методы приватные, и их работа проверяется через эти тесты

    //====================================================================================================================================================================

    public void testGetShortestRoute4() {   // 3 пересадки!

        // я изучила карты метро и, вроде бы, отсутствие подобной ситуации в реальной жизни обеспечивается инженерами/дизайнерами самого метро, так что не баг


        List<Station> expected = new ArrayList<>();
        expected.add(green1);
        expected.add(green2);
        expected.add(red2);
        expected.add(red3);
        expected.add(red4);
        expected.add(white4);
        expected.add(white5);
        expected.add(bubble1);
        expected.add(bubble2);

        List<Station> actual = routeCalculator.getShortestRoute(green1, bubble2);


        assertEquals(expected, actual);
    }

    public void testNotConnected() {
        Line brandNewLine = new Line(6, "Yammy");
        Station brandNewStation = new Station("Welcome!", brandNewLine);

        List<Station> expected = new ArrayList<>();
        List<Station> actual = routeCalculator.getShortestRoute(green1, brandNewStation);


        assertEquals(expected, actual);
    }

    public void testFlyDirection() {
        double expected = 3.5;

        List<Station> route = new ArrayList<>();
        route.add(green1);
        route.add(bubble2);
        double actual = RouteCalculator.calculateDuration(route);


        assertEquals(actual, expected);
    }



    @Override
    protected void tearDown() throws Exception {


    }
}
