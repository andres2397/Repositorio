package Data;

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

public class CustomerData {

    static ArrayList<Customer> customers;
    final String pathFileCustomer = "C:\\Users\\Andres JM\\Desktop\\lab5\\MatamorosJoseline-JimenezAndres-leivaValeria-progra2-Iteracion1\\customers.json";

    public CustomerData() {

        customers = new ArrayList<>();
    }

    public void insertCustomer(Customer customer) throws IOException {
        JSONObject customerObject = new JSONObject();
        customers.add(customer);

        customerObject.put("name", customer.getName());
        customerObject.put("id", customer.getId());
        customerObject.put("email", customer.getEmail());
        customerObject.put("phone", customer.getPhone());
        customerObject.put("username", customer.getUsername());
        customerObject.put("password", customer.getPassword());

        
        try (FileWriter fileWriter = new FileWriter(pathFileCustomer, true)) {

            fileWriter.write(customerObject.toJSONString()+"\n");
        }
    }

    public ArrayList modifyCustomer(Customer currentCustomer, ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(currentCustomer.getId())) {
                customers.get(i).setName(currentCustomer.getName());
                customers.get(i).setId(currentCustomer.getId());
                customers.get(i).setEmail(currentCustomer.getEmail());
                customers.get(i).setPhone(currentCustomer.getPhone());
                customers.get(i).setUsername(currentCustomer.getUsername());
                customers.get(i).setPassword(currentCustomer.getPassword());

            }

        }
        return customers;
    }

    public void deleteFileCustomer(ArrayList<Customer> customers) throws IOException {
        File file = new File(pathFileCustomer);
        file.delete();

        for (int i = 1; i < customers.size(); i++) {
            insertCustomer(customers.get(i));
        }
    }

    public ArrayList getUserFromFile() throws ParseException {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<JSONObject> jsonArray = new ArrayList<>();
        JSONObject jsonObject;
        String line = null;
        Customer customer = new Customer();
        try {

            FileReader fileReader = new FileReader(pathFileCustomer);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                jsonObject = (JSONObject) new JSONParser().parse(line);
                jsonArray.add(jsonObject);
                customer.setName(jsonObject.get("name").toString());
                customer.setId(jsonObject.get("id").toString());
                customer.setEmail(jsonObject.get("email").toString());
                customer.setPhone((jsonObject.get("phone").toString()));
                customer.setUsername((jsonObject.get("username").toString()));
                customer.setPassword(jsonObject.get("password").toString());
            }
            customers.add(customer);
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathFileCustomer + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathFileCustomer + "'");

        }
        return customers;

    }
    public boolean findCustomer(String password, String username, ArrayList<Customer> customers) {
        boolean foundCustomer = false;

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUsername().equals(username) && customers.get(i).getPassword().equals(password)) {
                foundCustomer = true;
            }
        }
        return foundCustomer;

    }

    
public void deleteCustomer(String username) throws ParseException {

        try {

            JSONObject customerObject;

            File file = new File(pathFileCustomer);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("customersTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFileCustomer));
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

    public void modifyCustomerFromFile(String username, Customer customer) throws ParseException {

        try {

            JSONObject customerObject;

            File file = new File(pathFileCustomer);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("customersTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFileCustomer));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                customerObject = (JSONObject) new JSONParser().parse(line);

                if (!customerObject.get("username").toString().equals(username)) {

                    printWriter.println(line);
                    printWriter.flush();
                } else {

                    customerObject.put("name", customer.getName());
                    customerObject.put("id", customer.getId());
                    customerObject.put("email", customer.getEmail());
                    customerObject.put("phone", customer.getPhone());
                    customerObject.put("username", customer.getUsername());
                    customerObject.put("password", customer.getPassword());

                    printWriter.println(customerObject.toJSONString());
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

public LinkedList<Customer> getAllCustomers() throws ParseException {
        LinkedList<Customer> customers = new LinkedList<>();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathFileCustomer);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                Customer customer = new Customer();
                customer.setPhone(jsonObject.get("phone").toString());                
                customer.setId(jsonObject.get("id").toString());
                customer.setName(jsonObject.get("name").toString());
                customer.setUsername(jsonObject.get("username").toString());
                customer.setPassword(jsonObject.get("password").toString());                
                customer.setEmail(jsonObject.get("email").toString());
                System.out.println(customer.toString());
                customers.add(customer);
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathFileCustomer + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathFileCustomer + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return customers;
    }

    public Customer getCustomerByUsernameAndPassword(String username, String password) throws ParseException {

        Customer customer = new Customer();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathFileCustomer);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                if (jsonObject.get("username").toString().equals(username) && jsonObject.get("password").toString().equals(password)) {
                    customer.setName(jsonObject.get("name").toString());
                    customer.setId(jsonObject.get("id").toString());
                    customer.setEmail(jsonObject.get("email").toString());
                    customer.setPhone(jsonObject.get("phone").toString());
                    customer.setUsername(jsonObject.get("username").toString());
                    customer.setPassword(jsonObject.get("password").toString());
                    System.out.println(customer.toString());
                }

            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathFileCustomer + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathFileCustomer + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return customer;
    }    
    public Customer getCustomerByUsername(String Username) throws ParseException {

        Customer customer = new Customer();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathFileCustomer);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                if (jsonObject.get("username").toString().equals(Username)) {
                    customer.setName(jsonObject.get("name").toString());
                    customer.setId(jsonObject.get("id").toString());
                    customer.setEmail(jsonObject.get("email").toString());
                    customer.setPhone(jsonObject.get("phone").toString());
                    customer.setUsername(jsonObject.get("username").toString());
                    customer.setPassword(jsonObject.get("password").toString());
                    System.out.println(customer.toString());
                }
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathFileCustomer + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathFileCustomer + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        return customer;
        
    }

    
}
