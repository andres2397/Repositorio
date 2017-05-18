package Business;

import Data.VehicleData;
import Domain.Vehicle;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;


public class VehicleBusiness {
    VehicleData vehicleData;
    
    public VehicleBusiness() {
        vehicleData=new VehicleData();
    }
    public LinkedList<Vehicle> getAllVehicles() throws org.json.simple.parser.ParseException {
        return vehicleData.getAllVehicles();
    }
    public void insertVehicleToFile(Vehicle vehicleInsert) throws IOException {
        vehicleData.insertVehicleToFile(vehicleInsert);
    }
    public Vehicle getVehiclePlate(String plate) throws ParseException{
        return vehicleData.getVehiclePlate(plate);
    }
     public void modifyVehicleFromFile(String plate, Vehicle vehicle) throws java.text.ParseException, ParseException{
         vehicleData.modifyVehicleFromFile(plate, vehicle);
     }
     public void deleteVehicle(String plate) throws java.text.ParseException, org.json.simple.parser.ParseException {
        vehicleData.deleteVehicle(plate);
     }
}