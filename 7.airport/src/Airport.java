
import java.util.*;


public class Airport {
    private final Random random = new Random(1L);
    private List<Terminal> terminals = new ArrayList();

    private Airport() {
    }

    public static Airport getInstance() {
        Airport airport = new Airport();
        airport.initializeAirport();
        return airport;
    }

    public List<Aircraft> getAllAircrafts() {
        List<Aircraft> aircraftList = new ArrayList();
        Iterator var2 = this.terminals.iterator();

        while (var2.hasNext()) {
            Terminal terminal = (Terminal) var2.next();
            Iterator var4 = terminal.getFlights().iterator();

            while (var4.hasNext()) {
                Flight flight = (Flight) var4.next();
                aircraftList.add(flight.getAircraft());
            }

            aircraftList.addAll(terminal.getParkedAircrafts());
        }

        return aircraftList;
    }

    public List<Terminal> getTerminals() {
        return this.terminals;
    }

    private void initializeAirport() {
        String[] terminalNames = new String[]{"A", "B", "C", "D"};
        int aircraftsCount = 125 + (int) ((Math.random() - 0.5D) * 50.0D);
        String[] var3 = terminalNames;
        int var4 = terminalNames.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            String terminalName = var3[var5];
            Terminal terminal = new Terminal(terminalName);

            for (int i = 0; i < aircraftsCount; ++i) {
                double type = Math.random();
                if (type <= 0.33D) {
                    terminal.addFlight(this.generateFlight(Flight.Type.DEPARTURE));
                } else if (type <= 0.8D) {
                    terminal.addFlight(this.generateFlight(Flight.Type.ARRIVAL));
                } else {
                    terminal.addParkingAircraft(this.generateAircraft());
                }
            }

            this.terminals.add(terminal);
        }

    }

    private Flight generateFlight(Flight.Type type) {
        return new Flight(this.generateFlightName(), type, this.generateRandomDate(), this.generateAircraft());
    }

    private Date generateRandomDate() {
        long currentTime = System.currentTimeMillis();
        long randomTime = currentTime + (long) ((this.random.nextDouble() - 0.5D) * 2.0D * 8.64E7D);
        return new Date(randomTime);
    }

    private String generateFlightName() {
        String[] companyCodes = new String[]{"SU", "AA", "AR", "AF", "B2", "FV"};
        String companyPrefix = companyCodes[this.random.nextInt(companyCodes.length)];
        int routeNumber = this.random.nextInt(9999) + 1;
        return companyPrefix + " " + routeNumber;
    }

    private Aircraft generateAircraft() {
        String[] models = new String[]{"Boeing 737-200", "Boeing 737-800", "Boeing 777-200", "Airbus A-320", "Airbus A-319", "Airbus A-321"};
        String randomModel = models[this.random.nextInt(models.length)];
        return new Aircraft(randomModel);
    }
}


