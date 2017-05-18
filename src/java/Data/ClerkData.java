package Data;

import Domain.Clerk;
import Domain.Customer;
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

public class ClerkData {
    
    ArrayList<Clerk> clerks;
    final String pathFile="C:\\Users\\Andres JM\\Desktop\\lab5\\clerks.json";
    
    public ClerkData() {
        clerks= new ArrayList<>();
    }
    
    public void insertClerkInFile(Clerk clerk) throws IOException{
        
        JSONObject clerkObject = new JSONObject();
        clerkObject.put("Nombre", clerk.getName());
        clerkObject.put("Identificacion", clerk.getId());
        clerkObject.put("Email",clerk.getEmail());
        clerkObject.put("Telefono",clerk.getPhone());
        clerkObject.put("Username",clerk.getUsername());
        clerkObject.put("Password",clerk.getPassword());
       
        
        clerks.add(clerk);
        try (FileWriter fileWriter = new FileWriter(pathFile, true)) {
            
            fileWriter.write(clerkObject.toJSONString() + "\r\n");
            
            System.out.println("entro");
        }
        
    }
    
     public LinkedList<Clerk> getAllClerks() throws ParseException {
        LinkedList<Clerk> clerks = new LinkedList<>();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                Clerk clerk = new Clerk();
                clerk.setName(jsonObject.get("name").toString());
                clerk.setEmail(jsonObject.get("email").toString());
                clerk.setPhone(jsonObject.get("phone").toString());
                clerk.setId(jsonObject.get("id").toString());
                clerk.setUsername(jsonObject.get("username").toString());
                clerk.setPassword(jsonObject.get("password").toString());
               
                
                System.out.println(clerk.toString());
                clerks.add(clerk);
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathFile + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathFile + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return clerks;
    }
    public void modifyClerkFromFile(String username, Clerk clerk) throws ParseException {

        try {

            JSONObject clerkObject;

            File file = new File(pathFile);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("clerksTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                clerkObject = (JSONObject) new JSONParser().parse(line);

                if (!clerkObject.get("username").toString().equals(username)) {

                    printWriter.println(line);
                    printWriter.flush();
                } else {

                    clerkObject.put("name", clerk.getName());
                    clerkObject.put("id", clerk.getId());
                    clerkObject.put("email", clerk.getEmail());
                    clerkObject.put("phone", clerk.getPhone());
                    clerkObject.put("username", clerk.getUsername());
                    clerkObject.put("password", clerk.getPassword());

                    printWriter.println(clerkObject.toJSONString());
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
    
    public Clerk getClerk(String identification, ArrayList<Clerk> clerks){
        Clerk clerk=null;
        for (int i = 0; i < clerks.size(); i++) {
            if(clerks.get(i).getId().equals(identification))
                clerk=clerks.get(i);
        }
        return clerk;
    }
    
    public boolean existsClerk(ArrayList<Clerk> clerks, Clerk clerk){
        boolean existsClerk=false;
        for (int i = 0; i < clerks.size(); i++) {
            if(clerks.get(i).equals(clerk)){
                existsClerk=true;
            }
        }
        return existsClerk;
    }
     
    
    public void deleteClerk(String username) throws ParseException {

        try {

            JSONObject clerkObject;

            File file = new File(pathFile);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("clerksTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;

                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {

                    clerkObject = (JSONObject) new JSONParser().parse(line);

                    if (!clerkObject.get("username").toString().equals(username)) {

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
public Clerk getClerkByUsername(String Username) throws ParseException {

        Clerk clerk = new Clerk();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                if (jsonObject.get("username").toString().equals(Username)) {
                    clerk.setName(jsonObject.get("name").toString());
                    clerk.setId(jsonObject.get("id").toString());
                    clerk.setEmail(jsonObject.get("email").toString());
                    clerk.setPhone(jsonObject.get("phone").toString());
                    clerk.setUsername(jsonObject.get("username").toString());
                    clerk.setPassword(jsonObject.get("password").toString());
                    System.out.println(clerk.toString());
                }
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathFile + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathFile + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        return clerk;
        
    }
public Clerk getClerkByUsernameAndPassword(String username, String password) throws ParseException {

        Clerk clerk = new Clerk();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                if (jsonObject.get("username").toString().equals(username) && jsonObject.get("password").toString().equals(password)) {
                    clerk.setName(jsonObject.get("name").toString());
                    clerk.setId(jsonObject.get("id").toString());
                    clerk.setEmail(jsonObject.get("email").toString());
                    clerk.setPhone(jsonObject.get("phone").toString());
                    clerk.setUsername(jsonObject.get("username").toString());
                    clerk.setPassword(jsonObject.get("password").toString());
                    System.out.println(clerk.toString());
                }

            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathFile + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathFile + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return clerk;
    }    
}
