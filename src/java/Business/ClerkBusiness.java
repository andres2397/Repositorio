package Business;

import Data.ClerkData;
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
import java.util.Objects;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Andres JM
 */
public class ClerkBusiness {

    ClerkData clerkData;

    public ClerkBusiness() {
        clerkData = new ClerkData();
    }

    public void insertClerkInFile(Clerk clerk) throws IOException {

        if (!clerk.getName().equals("") && !clerk.getId().equals("") && !clerk.getEmail().equals("")
                && !clerk.getPhone().equals("")
                && !clerk.getUsername().equals("") && !clerk.getPassword().equals("")) {
            clerkData.insertClerkInFile(clerk);
        }

    }

    public void modifyClerk(String username,Clerk currentClerk) throws ParseException {
       clerkData.modifyClerkFromFile(username, currentClerk);
    }

    public LinkedList<Clerk> getAllClerks() throws ParseException {
        
        return clerkData.getAllClerks();
    }

    public Clerk getClerkFromFile(ArrayList<Clerk> clerks, String id) throws ParseException {

        return clerkData.getClerk(id,clerks);
    }

    public Clerk getClerkById(String identification, ArrayList<Clerk> clerks) {
        Clerk clerk = null;
        for (int i = 0; i < clerks.size(); i++) {
            if (clerks.get(i).getId().equals(identification)) {
                clerk = clerks.get(i);
            }
        }
        return clerk;
    }

    public boolean existsClerk(ArrayList<Clerk> clerks, Clerk clerk) {
        boolean existsClerk = false;
        for (int i = 0; i < clerks.size(); i++) {
            if (clerks.get(i).equals(clerk)) {
                existsClerk = true;
            }
        }
        return existsClerk;
    }

public void deleteCustomer(String username) throws ParseException {
            clerkData.deleteClerk(username);
    }

    public Clerk getClerkByName(String clerkUsername) throws ParseException {
      
         Clerk clerk = new Clerk();
        clerk = clerkData.getClerkByUsername(clerkUsername);
        return clerk;
        
        
    }
public Clerk getClerkByUsernameAndPassword(String username, String password) throws ParseException {

       
        return clerkData.getClerkByUsernameAndPassword(username, password);
    }
}
