package Data;

import Domain.Customer;
import Domain.ParkingLot;
import Domain.Space;
import Domain.Vehicle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ValeriaLeivaQuirós
 */
public class ParkingLotData {

    static ArrayList<ParkingLot> parkingLots;
//    final String pathFileParkingLot;
    final String pathFileParkingList;


    public ParkingLotData() {//String nameParking

//        pathFileParkingLot = "C:\\Users\\ValeriaLeivaQuirós\\Documents\\MatamorosJoseline-JimenezAndres-leivaValeria-progra2-Iteracion1" + nameParking + ".json";
        pathFileParkingList = "C:\\Users\\ValeriaLeivaQuirós\\Documents\\MatamorosJoseline-JimenezAndres-leivaValeria-progra2-Iteracion1\\parkingList.json";

        parkingLots = new ArrayList<>();
    }

 

//    public void insertParkingList(ParkingLot parkingLot) throws IOException {
//
//        JSONObject parkingLotObject = new JSONObject();
//        parkingLotObject.put("Id", parkingLot.getId());
//        parkingLotObject.put("Name", parkingLot.getName());
//        parkingLotObject.put("Number Of Spaces", parkingLot.getNumberOfSpaces());
//
//        try (FileWriter file = new FileWriter(pathFileParkingLot, true)) {
//            file.write(parkingLotObject.toJSONString() + "\r\n");
//
//        }
//        
//        
//    }

    public void insertParkingLot(ParkingLot parkingLot) throws IOException {
        

    
        
//int id, String name, int numberOfSpaces, ArrayList<Vehicle> vehicles, Space[] spaces
        JSONObject parkingLotObject = new JSONObject();
        parkingLotObject.put("id", parkingLot.getId());
        parkingLotObject.put("nameParking", parkingLot.getName());
        parkingLotObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());


        ArrayList<Vehicle> vehicles = parkingLot.getVehicles();
        JSONArray vehicleList = new JSONArray();
        for (Vehicle vehicle : vehicles) {
            vehicleList.add("plate" + vehicle.getPlate());
            vehicleList.add("brand" + vehicle.getBrand());
            vehicleList.add("model" + vehicle.getModel());
            //para los clientes dueños del vehiculo

            Customer[] customers = vehicle.getCustomer();
            JSONArray customerList = new JSONArray();
            for (Customer customer : customers) {
                customerList.add("name" + customer.getName());
                customerList.add("identification" + customer.getId());
                customerList.add("email" + customer.getEmail());
                customerList.add("phone" + customer.getPhone());
                customerList.add("username" + customer.getUsername());
                customerList.add("password" + customer.getPassword());

            }
            vehicleList.add(customerList);

            vehicleList.add("description" + vehicle.getVehicleType().getDescription());
           
            vehicleList.add("fee" + vehicle.getVehicleType().getFee());

        }
        parkingLotObject.put("listOfVehicles", vehicleList);

        Space[] spaces = parkingLot.getSpaces();
        JSONArray spacesList = new JSONArray();
        for (Space space : spaces) {

            spacesList.add("id" + space.getId());
            spacesList.add("disabilityAdaptation" + space.isDisabilityAdaptation());

            spacesList.add("spaceTaken" + space.isSpaceTaken());
            spacesList.add("vehicleType" + space.getVehicleType().getDescription());
            spacesList.add("vehicleType" + space.getVehicleType().getFee());

        }

        parkingLotObject.put("listOfSpaces", spacesList);
        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(pathFileParkingList, true)) {
            file.write(parkingLotObject.toJSONString() + "\r\n");

        }

    }//Fin del método insertar

    public void deleteParkingLot(int id) throws ParseException, FileNotFoundException {

        try {

            JSONObject parkingLotObject;

            File file = new File(pathFileParkingList);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("parkingLotsTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFileParkingList));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;

                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {

                    parkingLotObject = (JSONObject) new JSONParser().parse(line);

                    if (!parkingLotObject.get("id").toString().equals(id)) {

                        printWriter.println(line);
                        printWriter.flush();
                    }
                }

                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(ParkingLotData.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Delete the original file
            if (!file.delete()) {

                //no se pudo eliminar el archivo
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(file)) {

            }

        } catch (FileNotFoundException ex) {

        }
    }

    public void modifyParkinLotFromFile(int id, ParkingLot parkingLot) throws ParseException {

        try {

            JSONObject parkingLotObject;

            File file = new File(pathFileParkingList);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("parkingLotsTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFileParkingList));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                parkingLotObject = (JSONObject) new JSONParser().parse(line);

                if (!parkingLotObject.get("id").toString().equals(id)) {

                    printWriter.println(line);
                    printWriter.flush();
                } else {

                    parkingLotObject.put("id", parkingLot.getId());
                    parkingLotObject.put("nameParking", parkingLot.getName());
                    parkingLotObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());

//        String plate, String color, String brand, String model, Customer [] customer, VehicleType vehicleType
                    ArrayList<Vehicle> vehicles = parkingLot.getVehicles();
                    JSONArray vehicleList = new JSONArray();
                    for (Vehicle vehicle : vehicles) {
                        vehicleList.add("plate" + vehicle.getPlate());
                        vehicleList.add("brand" + vehicle.getBrand());
                        vehicleList.add("model " + vehicle.getModel());
                        //para los clientes dueños del vehiculo

                        Customer[] customers = vehicle.getCustomer();
                        JSONArray customerList = new JSONArray();
                        for (Customer customer : customers) {
                            customerList.add("name" + customer.getName());
                            customerList.add("identificacion" + customer.getId());
                            customerList.add("email" + customer.getEmail());
                            customerList.add("phone" + customer.getPhone());
                            customerList.add("username" + customer.getUsername());
                            customerList.add("password" + customer.getPassword());

                        }
                        vehicleList.add(customerList);

                        vehicleList.add("description" + vehicle.getVehicleType().getDescription());
                       
                        vehicleList.add("fee" + vehicle.getVehicleType().getFee());

                    }
                    parkingLotObject.put("listOfVehicles", vehicleList);

                    Space[] spaces = parkingLot.getSpaces();
                    JSONArray spacesList = new JSONArray();
                    for (Space space : spaces) {

                        spacesList.add("id" + space.getId());
                        spacesList.add("disabilityAdaptation" + space.isDisabilityAdaptation());

                        spacesList.add("spaceTaken" + space.isSpaceTaken());
                        spacesList.add("vehicleType" + space.getVehicleType().getDescription());
                        spacesList.add("vehicleType" + space.getVehicleType().getFee());

                    }

                    parkingLotObject.put("listOfSpaces", spacesList);

                    printWriter.println(parkingLotObject.toJSONString());
                }
            }

            bufferedReader.close();
            printWriter.close();

            //Delete the original file
            if (!file.delete()) {
                //no se pudo eliminar el archivo
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(file)) {

                //no se pudo renombrar el archivo
            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public LinkedList<ParkingLot> getAllParkingLots() throws ParseException {
        LinkedList<ParkingLot> parkingLots = new LinkedList<>();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathFileParkingList);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);
                ParkingLot parkingLot = new ParkingLot();

                parkingLot.setId(Integer.parseInt(jsonObject.get("id").toString()));
                parkingLot.setName((jsonObject.get("name").toString()));
                parkingLot.setNumberOfSpaces(Integer.parseInt(jsonObject.get("numberOfSpaces").toString()));
                parkingLot.setVehicles((ArrayList<Vehicle>) jsonObject.get("vehicle"));
//        String plate, String color, String brand, String model, Customer [] customer, VehicleType vehicleType

            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathFileParkingList + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathFileParkingList + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return parkingLots;
    }

    public ParkingLot getParkingLotById(int id) throws ParseException {

        ParkingLot parkingLot = new ParkingLot();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathFileParkingList);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                if (jsonObject.get("Id").toString().equals(id)) {
                    parkingLot.setId(Integer.parseInt(jsonObject.get("id").toString()));
                    parkingLot.setName((jsonObject.get("name").toString()));
                    parkingLot.setNumberOfSpaces((int) (jsonObject.get("numberOfSpaces")));
                    parkingLot.setVehicles((ArrayList<Vehicle>) jsonObject.get("vehicle"));
                    System.out.println(parkingLot.toString());
                }

            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathFileParkingList + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathFileParkingList + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return parkingLot;

    }

}