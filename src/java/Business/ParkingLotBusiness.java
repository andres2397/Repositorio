package Business;

import Data.ParkingLotData;
import Domain.ParkingLot;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Esteban
 */
public class ParkingLotBusiness {

    ParkingLotData parkingLotData;


    public ParkingLotBusiness() {//String NameParkingLot
     
        parkingLotData = new ParkingLotData();
    }

    @SuppressWarnings("IncompatibleEquals")
    public void insertParkinLot(ParkingLot parkingLot) throws IOException {
            String idString= String.valueOf(parkingLot.getId());
            String numberString= String.valueOf(parkingLot.getNumberOfSpaces());
            
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.
      
        if (! parkingLot.getName().equals("") &&!numberString.equals("")){

            parkingLotData.insertParkingLot(parkingLot);
           
        }
    }

    public LinkedList<ParkingLot> getAllParkingLots() throws ParseException {

        return parkingLotData.getAllParkingLots();
    }

    public ParkingLot getParkingLot(int id) throws ParseException {

        ParkingLot parkingLot = new ParkingLot();
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.

            parkingLot = parkingLotData.getParkingLotById(id);
        

        return parkingLot;

    }

    public void modifyParkingLot(int id, ParkingLot parkingLot) throws IOException, ParseException {

        parkingLotData.modifyParkinLotFromFile(id, parkingLot);

    }

    public void deleteParking(int id) throws IOException, ParseException {

        parkingLotData.deleteParkingLot(id);

    }
    

  

    
}