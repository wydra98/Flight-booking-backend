package flight_booking.backend.service;

import flight_booking.backend.controllers.AirportController.AirportDto;
import flight_booking.backend.models.Airport.Airport;
import flight_booking.backend.models.Connection.Connection;
import flight_booking.backend.models.Connection.ConnectionRepository;
import flight_booking.backend.models.Times;
import org.springframework.stereotype.Service;
import flight_booking.backend.models.Airport.AirportRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Service
public class ConnectionService {

    private final ConnectionRepository connectionRepository;
    private final AirportRepository airportRepository;

    public ConnectionService(ConnectionRepository connectionRepository,
                             AirportRepository airportRepository) {

        this.connectionRepository = connectionRepository;
        this.airportRepository = airportRepository;
    }


    public Connection addNewConnection(Long srcAirportId,
                                       Long dstAirportId,
                                       String departureDate,
                                       String departureTime,
                                       String arrivalDate,
                                       String arrivalTime) {

        Optional<Airport> srcAirport1 = airportRepository.findById(srcAirportId);
        Optional<Airport> dstAirport1 = airportRepository.findById(dstAirportId);

        Connection connection = Connection.builder()
                .srcAirport(srcAirport1.get())
                .dstAirport(dstAirport1.get())
                .times(Times.builder()
                        .departureDate(LocalDate.parse(departureDate))
                        .arrivalDate(LocalDate.parse(arrivalDate))
                        .arrivalTime(LocalTime.parse(arrivalTime))
                        .departureTime(LocalTime.parse(departureTime))
                        .build())
                .build();
        connectionRepository.save(connection);
        return connection;
    }

    public void deleteConnectionWithAirlineId(Long id) {
        connectionRepository.deleteAllConnectionWithAirlineId(id);
    }

    public void deleteConnectionWithAirportId(Long id) {
        connectionRepository.deleteAllConnectionWithAirportId(id);
    }

    public List<Connection> findAll() {
        return connectionRepository.findAll();
    }

    public boolean existsById(Long id) {
        return connectionRepository.existsById(id);
    }

    public void deleteConnection(Long id) {
        connectionRepository.deleteById(id);
    }

    public Optional<Connection> findById(Long id) {
        return connectionRepository.findById(id);
    }

    public void save(Connection connection) {
        connectionRepository.save(connection);
    }

    public List<List<Connection>> findConnections(Long srcAirportId, Long dstAirportId, LocalDate departureDate, LocalTime departureTime) {

        List<Connection> connectionsWithTheSameSrcAirport = connectionRepository.findAllConnectionWithTheSameSrcAirport(srcAirportId);

        List<List<Connection>> connections = null;
        return connections;
    }

//    public class Algorytm {
//
//        Stack<Droga> JakasDroga = new Stack<>();
//        Vector<Droga> CaleDrogi = new Vector<>();
//        Vector<Droga> trasy = new Vector<>();
//
//        public void przypiszDrogi()
//        {
//            trasy.add(new Droga("wilno", "warszawa"));
//            trasy.add(new Droga("warszawa", "wilno"));
//            trasy.add(new Droga("wilno", "minsk"));
//            trasy.add(new Droga("minsk", "krakow"));
//            trasy.add(new Droga("krakow", "bratyslawa"));
//            trasy.add(new Droga("bratyslawa", "praga"));
//            trasy.add(new Droga("praga", "rzym"));
//            trasy.add(new Droga("praga", "madryt"));
//            trasy.add(new Droga("paryz", "madryt"));
//            trasy.add(new Droga("berlin", "paryz"));
//            trasy.add(new Droga("londyn", "paryz"));
//            trasy.add(new Droga("berlin", "londyn"));
//            trasy.add(new Droga("londyn", "warszawa"));
//            trasy.add(new Droga("warszawa", "berlin"));
//            trasy.add(new Droga("berlin", "krakow"));
//            trasy.add(new Droga("praga", "berlin"));
//        }
//
//        private void dodajCalaDroge()
//        {
//            CaleDrogi.addAll(JakasDroga);
//            CaleDrogi.add(new Droga("///", "///"));
//        }
//
//        public boolean algorytm(String aktualneMiasto, int iterator, String cel)
//        {
//            if(iterator == 3)
//            {
//                JakasDroga.pop();
//                return false;
//            }
//            int i;
//
//            for(i = 0; i < trasy.size(); i++)
//            {
//                if(trasy.get(i).miastoPoczatkowe.equals(aktualneMiasto))
//                {
//                    JakasDroga.push(trasy.get(i));
//                    if(trasy.get(i).miastoKoncowe.equals(cel))
//                    {
//                        dodajCalaDroge();
//                        JakasDroga.pop();
//                        //iterator --;
//                    }
//                    else if(trasy.get(i).miastoKoncowe.equals(JakasDroga.get(0).miastoPoczatkowe))
//                    {
//                        JakasDroga.pop();
//                    }
//                    else
//                    {
//                        iterator ++;
//                        algorytm(trasy.get(i).miastoKoncowe, iterator, cel);
//                    }
//                }
//            }
//            JakasDroga.pop();
//            return false;
//        }
//
//        public void wypiszCaleDrogi()
//        {
//            for(Droga x: CaleDrogi)
//            {
//                System.out.println(x.miastoPoczatkowe + "->" + x.miastoKoncowe);
//            }
//        }
//    }
//
//    public class Main {
//
//        public static void main(String [] args)
//        {
//            Algorytm alg = new Algorytm();
//            alg.przypiszDrogi();
//            alg.algorytm("warszawa",0,"krakow");
//            alg.wypiszCaleDrogi();
//        }
//    }
//
//    public class Droga {
//
//        public String miastoPoczatkowe;
//        public String miastoKoncowe;
//
//        public Droga(String poczatek, String koniec)
//        {
//            this.miastoPoczatkowe = poczatek;
//            this.miastoKoncowe = koniec;
//        }
//    }




}
