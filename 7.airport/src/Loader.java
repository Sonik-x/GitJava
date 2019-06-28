import java.util.List;

public class Loader{
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        List<Aircraft> list = airport.getAllAircrafts();
        list.forEach(e -> System.out.println(e));

    }
}
