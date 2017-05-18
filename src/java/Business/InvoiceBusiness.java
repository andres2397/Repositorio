package Business;

import Data.InvoiceData;
import Domain.Invoice;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;


public class InvoiceBusiness {
    InvoiceData invoiceData;
    public InvoiceBusiness() {
        invoiceData= new InvoiceData();
    }
     public void insertInvoice(Invoice invoice) throws IOException {
         invoiceData.insertInvoice(invoice);
     }
      public Invoice getInvoiceByVehicleType(String vehicleType) throws ParseException {
          return invoiceData.getInvoiceByVehicleType(vehicleType);
      }
      
      public void deleteFee(String vehicleDescription) throws ParseException {
          invoiceData.deleteFee(vehicleDescription);
      }
       
     public LinkedList<Invoice> getAllFees() throws ParseException{
         return invoiceData.getAllFees();
     }
     public void modifyInvoiceFromFile(String vehicleType, Invoice invoice) throws ParseException {
         invoiceData.modifyInvoiceFromFile(vehicleType, invoice);
                
     }
}