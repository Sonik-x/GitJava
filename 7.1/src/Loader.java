import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Loader {
    public static void main(String[] args) {


        Airport airport = Airport.getInstance();
        List<Terminal> terms = airport.getTerminals();


        Date now = new Date();
        Date inTwoHours = (Date) now.clone();
        inTwoHours.setHours(inTwoHours.getHours() + 2);

        ArrayList<Flight> flights = airport.getAllFlights();
        flights.stream()
                .filter(f -> f.getType() == Flight.Type.DEPARTURE && f.getDate().before(inTwoHours) && f.getDate().after(now))  //вылетающие в ближайшие 2 часа
                .sorted(Comparator.comparing(Flight::getDate))
                .forEach(f -> System.out.println(Flight.HOUR_FORMAT.format(f.getDate()) + " " + f.getAircraft().getModel()));  //распечатать время вылета и модели самолётов




    }
}
