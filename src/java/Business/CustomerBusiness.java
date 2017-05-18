package Business;

import Data.CustomerData;
import Domain.Customer;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Andres JM
 */
public class CustomerBusiness {

    CustomerData customerData;

    public CustomerBusiness() {
        customerData = new CustomerData();
    }

    public void insertCustomer(Customer customer) throws IOException {
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.
        if (!customer.getName().equals("") && !customer.getId().equals("") && !customer.getEmail().equals("")
                && !customer.getPhone().equals("")
                && !customer.getUsername().equals("") && !customer.getPassword().equals("")) {
            customerData.insertCustomer(customer);
        }
    }

    public LinkedList<Customer> getAllCustomers() throws ParseException{
        return customerData.getAllCustomers();
    }

    public Customer authenticatePassword(String Username, String Password) throws java.text.ParseException, ParseException {
        Customer customerAuthenticate = null;
        LinkedList<Customer> customers = new LinkedList<>();

        customers = customerData.getAllCustomers();

        for (Customer customer : customers) {
            if (customer.getUsername().equals(Username) && customer.getPassword().equals(Password)) {

                customerAuthenticate = customer;
                break;
            }
        }
        return customerAuthenticate;
    }

    public Customer getCustomerByUsernameAndPassword(String username, String password) throws ParseException {

        Customer customer = new Customer();
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.
        if (!username.equals("") && !password.equals("")) {

            customer = customerData.getCustomerByUsernameAndPassword(username, password);
        }

        return customer;

    }

    public Customer getCustomerByName(String username) throws ParseException {

        Customer customer = new Customer();
        customer = customerData.getCustomerByUsername(username);
        return customer;
    }

    public void modifyCustomer(String customerName, Customer customer) throws IOException, ParseException {

        customerData.modifyCustomerFromFile(customerName, customer);

    }

    public void deleteCustomer(String customerUsername) throws IOException, ParseException {

        customerData.deleteCustomer(customerUsername);

    }

    
    
    
}
