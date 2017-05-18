      package Data;

import Domain.Space;
import Domain.VehicleType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ValeriaLeivaQuirós
 */
public class SpaceData {

    ArrayList<Space> spaces;
    final String jsonFilePath = "C:\\Users\\ValeriaLeivaQuirós\\Desktop\\Lab4Web\\spaces.json";

    public SpaceData() {
        spaces = new ArrayList<>();
    }

    public void insertSpace(Space space) throws IOException {
//int id, boolean disabilityAdaptation, boolean spaceTaken, VehicleType vehicleType
        JSONObject spaceObject = new JSONObject();
        spaces.add(space);
        
        spaceObject.put("id", space.getId());
        spaceObject.put("disabilityAdaptation", space.isDisabilityAdaptation()); 
        spaceObject.put("spaceTaken", space.isSpaceTaken());
        spaceObject.put("VehicleType", space.getVehicleType().getDescription());
        spaceObject.put("VehicleType", space.getVehicleType().getFee());
    

        try (FileWriter fileWriter = new FileWriter(jsonFilePath, true)) {

            fileWriter.write(spaceObject.toJSONString() + "\r\n");

        }

    }

    public void deleteSpace(String username) throws ParseException {

        try {

            JSONObject customerObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("spacesTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;

                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {

                    customerObject = (JSONObject) new JSONParser().parse(line);

                    if (!customerObject.get("username").toString().equals(username)) {

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

    public void modifySpaceFromFile(String username, Space space) throws ParseException {

        try {

            JSONObject spaceObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("spacesTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                spaceObject = (JSONObject) new JSONParser().parse(line);

                if (!spaceObject.get("username").toString().equals(username)) {

                    printWriter.println(line);
                    printWriter.flush();
                } else {

                    spaceObject.put("id", space.getId());
                    spaceObject.put("disabilityAdaptation", space.isDisabilityAdaptation());
                    spaceObject.put("spaceTaken", space.isSpaceTaken());
                    spaceObject.put("VehicleType", space.getVehicleType().getDescription());
                    spaceObject.put("VehicleType", space.getVehicleType().getFee());
                   

                    printWriter.println(spaceObject.toJSONString());
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

    public LinkedList<Space> getAllSpaces() throws ParseException {
        LinkedList<Space> spaces = new LinkedList<>();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(jsonFilePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                Space space = new Space();
                space.setId(Integer.parseInt(jsonObject.get("id").toString()));
                space.setDisabilityAdaptation((boolean)(jsonObject.get("disabilityAdaptation")));
                space.setSpaceTaken((boolean) jsonObject.get("spaceTaken"));
                space.setVehicleType((VehicleType) jsonObject.get("vehicleType"));
               
                System.out.println(space.toString());
                spaces.add(space);
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + jsonFilePath + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + jsonFilePath + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return spaces;
    }
}