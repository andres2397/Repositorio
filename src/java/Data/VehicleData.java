package Data;

import Domain.Customer;
import Domain.Vehicle;
import Domain.VehicleType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class VehicleData {

    JSONObject vehicleObject;
    FileWriter file;
    final String path = "C:\\Users\\Matamoros Cordero\\Documents\\MatamorosJoseline-JimenezAndres-leivaValeria-progra2-Iteracion1\\vehicles.json";
    
    
    public VehicleData() {
        vehicleObject = new JSONObject();
        
    }
    
    public void insertVehicleToFile(Vehicle vehicleInsert) throws IOException {
        
    JSONObject vehicleObject = new JSONObject();
        vehicleObject.put("brand", vehicleInsert.getBrand());
        vehicleObject.put("model", vehicleInsert.getModel());
   
        vehicleObject.put("plate", vehicleInsert.getPlate());
     
        vehicleObject.put("hourlyRate", vehicleInsert.getVehicleType().getFee());
        vehicleObject.put("vehicleType", vehicleInsert.getVehicleType().getDescription());
        
        Customer[] customers = vehicleInsert.getCustomer();
        JSONArray customerList = new JSONArray();
        for (Customer customer : customers) {
            customerList.add(" name  " + customer.getName());
            customerList.add(" id " + customer.getId());
            customerList.add("  email  " + customer.getEmail());
            customerList.add(" phone " + customer.getPhone());
            customerList.add("  username  " + customer.getUsername());
            customerList.add("  password  " + customer.getPassword());
            
        }
        vehicleObject.put("clientList", customerList);
        
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            
            fileWriter.write(vehicleObject.toJSONString() + "\r\n");
            
            System.out.println("entro");
            
        }
    }
    
    public LinkedList<Vehicle> getAllVehicles() throws org.json.simple.parser.ParseException {
        LinkedList<Vehicle> vehicles = new LinkedList<>();
        ArrayList<JSONObject> jsonArray = new ArrayList<>();
        JSONObject jsonObject;
        String line = null;
        try {
            
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                jsonObject = (JSONObject) new JSONParser().parse(line);
                jsonArray.add(jsonObject);
                Vehicle vehicle = new Vehicle();
                vehicle.setBrand(jsonObject.get("brand").toString());
                vehicle.setModel(jsonObject.get("model").toString());
                
                vehicle.setPlate(jsonObject.get("plate").toString());
                vehicle.setVehicleType((VehicleType) jsonObject.get("description"));
                vehicle.setVehicleType((VehicleType) jsonObject.get("fee"));
                JSONArray customerListShown = (JSONArray) jsonObject.get("clientList");
                System.out.println("\n Lista de clientes:");
                Iterator<String> iterator = customerListShown.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
                vehicles.add(vehicle);
                
            }
            
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + path + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + path + "'");
            
        }
        return vehicles;
    }
    
    public void deleteVehicle(String plate) throws ParseException, org.json.simple.parser.ParseException {
        
        try {
            
            JSONObject vehicleObject;
            
            File file = new File(path);

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("vehiclesTemp.json");
            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;

                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {
                    
                    vehicleObject = (JSONObject) new JSONParser().parse(line);
                    
                    if (!vehicleObject.get("plate").toString().equals(plate)) {
                        
                        printWriter.println(line);
                        printWriter.flush();
                    }
                }
                
                bufferedReader.close();
            }

            //Delete the original file
            if (!file.delete()) {

                //no se pudo eliminar el archivo
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(file)) {
                
            }
            
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }
    
    public Vehicle getVehiclePlate(String plate) throws org.json.simple.parser.ParseException {
        Vehicle vehicle = new Vehicle();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(path);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while ((line = bufferedReader.readLine()) != null) {
                
                jsonObject = (JSONObject) new JSONParser().parse(line);
                
                if (jsonObject.get("plate").toString().equals(plate)) {
                    vehicle.setBrand(jsonObject.get("brand").toString());
            
                    vehicle.setVehicleType((VehicleType) jsonObject.get("vehicleType"));
                    vehicle.setCustomer((Customer[]) jsonObject.get("l"));
                    System.out.println(vehicle.toString());
                }
                
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + path + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + path + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        
        return vehicle;
    }
    
    public void modifyVehicleFromFile(String plate, Vehicle vehicle) throws ParseException, org.json.simple.parser.ParseException {
        
        try {
            
            JSONObject vehicleObject;
            
            File file = new File(path);

//Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("vehiclesTemp.json");
            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));
            
            String line = null;

//Read from the original file and write to the new
//unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {
                
                vehicleObject = (JSONObject) new JSONParser().parse(line);
                
                if (!vehicleObject.get("Plate").toString().equals(plate)) {
                    
                    printWriter.println(line);
                    printWriter.flush();
                } else {
                    
                    vehicleObject.put("plate", vehicle.getPlate());
                    vehicleObject.put("brand ", vehicle.getBrand());
                    
                    vehicleObject.put("model", vehicle.getModel());
                    vehicleObject.put("description", vehicle.getVehicleType().getDescription());
                    
                    vehicleObject.put("fee", vehicle.getVehicleType().getFee());
                    
                    JSONArray customerListShown = (JSONArray) vehicleObject.get("clientList");
                    System.out.println("\n Lista de clientes:");
                    Iterator<String> iterator = customerListShown.iterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    
                    
                }
                
                printWriter.println(vehicleObject.toJSONString());
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
        
    
    
}