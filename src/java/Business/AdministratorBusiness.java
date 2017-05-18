package Business;

import Data.AdministratorData;
import Domain.Administrator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Andres JM
 */
public class AdministratorBusiness {

    AdministratorData administratorData;
    
    public AdministratorBusiness() {
        administratorData = new AdministratorData();
    }

    public void insertAdministrator(Administrator administrator) throws IOException {
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.
        if (!administrator.getName().equals("") && !administrator.getEmail().equals("")
                && !administrator.getUsername().equals("") && !administrator.getPassword().equals("")) {
            administratorData.insertAdministrator(administrator);
        }
    }
    public LinkedList<Administrator> getAllAdministrators() throws ParseException, java.text.ParseException, org.json.simple.parser.ParseException {
 return administratorData.getAllAdministrators();
 }
    
   public Administrator authenticatePassword(String Username,String Password) throws java.text.ParseException, ParseException, org.json.simple.parser.ParseException{
    Administrator administratorAuthenticate = null;
    LinkedList<Administrator> administrators = new LinkedList<>();

    administrators =administratorData.getAllAdministrators();
    
    for (Administrator administrator : administrators) {
        if (administrator.getUsername().equals(Username) && administrator.getPassword().equals(Password)) {
            
            administratorAuthenticate=administrator;
            break;
        }
        
        
    }

    return administratorAuthenticate;
    } 
    
    public Administrator getAdministratorByUsernameAndPassword(String username, String password) throws ParseException, org.json.simple.parser.ParseException {

        return administratorData.getAdministratorByUsernameAndPassword(username, password);

    }//encotrar administrador por contraseña y username 
 
    
    
    public void deleteAdministrator(String username) throws org.json.simple.parser.ParseException {

        administratorData.deleteAdministrator(username);
    }// metodo borrar

 public Administrator getAdministratorByUsername(String username) throws org.json.simple.parser.ParseException {
        return administratorData.getAdministratorByUsername(username);
    }    

 
 public void modifyAdministratorFromFile(String username, Administrator administrator) throws org.json.simple.parser.ParseException {
     
     administratorData.modifyAdministratorFromFile(username, administrator);
    }
 
}
