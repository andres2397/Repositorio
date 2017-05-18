package Data;

import Domain.Administrator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class AdministratorData {
    
    ArrayList<Administrator> administrators;
    final String pathAdministrator="C:\\Users\\Andres JM\\Desktop\\lab5\\MatamorosJoseline-JimenezAndres-leivaValeria-progra2-Iteracion1\\administrators.json";
    
    public AdministratorData() {
        administrators= new ArrayList<>();
    }
    
    
    public void insertAdministrator(Administrator administrator) throws IOException{
        JSONObject administratorObject = new JSONObject();
        
        administratorObject.put("id", administrator.getId());
        administratorObject.put("name", administrator.getName());
        administratorObject.put("username",administrator.getUsername());
        administratorObject.put("password",administrator.getPassword());        
        administratorObject.put("email",administrator.getEmail());
        administratorObject.put("phone",administrator.getPhone());

        administrators.add(administrator);
        try (FileWriter fileWriter = new FileWriter(pathAdministrator, true)) {
            
            fileWriter.write(administratorObject.toJSONString() + "\r\n");
            
            System.out.println("entro");
        }
        
    }
    public LinkedList<Administrator> getAllAdministrators() throws ParseException  {
        LinkedList<Administrator> administrators = new LinkedList<>();
        ArrayList<JSONObject> jsonArray = new ArrayList<>();
        JSONObject jsonObject;
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathAdministrator);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                jsonObject = (JSONObject) new JSONParser().parse(line);
                jsonArray.add(jsonObject);
                Administrator administrator= new Administrator();
                
                administrator.setId(jsonObject.get("id").toString());                
                administrator.setName(jsonObject.get("name").toString());
                administrator.setUsername(jsonObject.get("username").toString()); 
                administrator.setPassword(jsonObject.get("password").toString());
                administrator.setEmail(jsonObject.get("email").toString());
                administrator.setPhone(jsonObject.get("phone").toString());

                System.out.println(administrator.toString());
                administrators.add(administrator);

            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathAdministrator + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathAdministrator + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return administrators;
    }
    
public void deleteAdministrator(String username) throws ParseException {

        try {

            JSONObject administratorObject;

            File file = new File(pathAdministrator);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("administratorTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathAdministrator));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;

                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {

                    administratorObject = (JSONObject) new JSONParser().parse(line);

                    if (!administratorObject.get("username").toString().equals(username)) {

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
    }// metodo borrar

    public void modifyAdministratorFromFile(String username, Administrator administrator) throws ParseException {

        try {

            JSONObject administratorObject;

            File file = new File(pathAdministrator);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("administratorTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathAdministrator));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                administratorObject = (JSONObject) new JSONParser().parse(line);

                if (!administratorObject.get("username").toString().equals(username)) {

                    printWriter.println(line);
                    printWriter.flush();
                } else {

                    administratorObject.put("name", administrator.getName());
                    administratorObject.put("id", administrator.getId());
                    administratorObject.put("email", administrator.getEmail());
                    administratorObject.put("phone", administrator.getPhone());
                    administratorObject.put("username", administrator.getUsername());
                    administratorObject.put("password", administrator.getPassword());

                    printWriter.println(administratorObject.toJSONString());
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
    }//metodo modificar

    public Administrator getAdministratorByUsernameAndPassword(String username, String password) throws ParseException {

        Administrator administrator = new Administrator();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathAdministrator);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                if (jsonObject.get("username").toString().equals(username) && jsonObject.get("password").toString().equals(password)) {

                    administrator.setName(jsonObject.get("name").toString());
                    administrator.setEmail(jsonObject.get("email").toString());
                    administrator.setUsername(jsonObject.get("username").toString());
                    administrator.setPassword(jsonObject.get("password").toString());
                    System.out.println(administrator.toString());
                }

            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathAdministrator + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathAdministrator + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return administrator;

    }//encotrar administrador por contraseña y username 

    public Administrator getAdministratorByUsername(String username) throws ParseException {

        Administrator administrator = new Administrator();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathAdministrator);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                if (jsonObject.get("username").toString().equals(username)) {

                    administrator.setName(jsonObject.get("name").toString());
                    administrator.setEmail(jsonObject.get("email").toString());
                    administrator.setUsername(jsonObject.get("username").toString());
                    administrator.setPassword(jsonObject.get("password").toString());
                    System.out.println(administrator.toString());
                }
                
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathAdministrator + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathAdministrator + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return administrator;
    }    


}