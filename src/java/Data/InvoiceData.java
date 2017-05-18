package Data;

import Domain.Invoice;
import Domain.VehicleType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InvoiceData {
    final String pathFile="C:\\Users\\Matamoros Cordero\\Documents\\MatamorosJoseline-JimenezAndres-leivaValeria-progra2-Iteracion1\\fees.json";
    public void insertInvoice(Invoice invoice) throws IOException {
        
        JSONObject feeObject = new JSONObject();
        feeObject.put("precio por hora", invoice.getHourlyRate());
        feeObject.put("cantidad de horas", invoice.getNumberOfHours());
        feeObject.put("tipo de vehiculo", invoice.getVehicleType().getDescription());
        
        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(pathFile, true)) {
            file.write(feeObject.toJSONString() + "\r\n");
            
        }
        
    }//Fin del método insertar
    public void deleteFee(String vehicleDescription) throws ParseException {
        
        try {
            
            JSONObject feeObject;
            
            File file = new File(pathFile);
            
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("invoiceTemp.json");
            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;
                
                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {
                    
                    feeObject = (JSONObject) new JSONParser().parse(line);
                    
                    if (!feeObject.get("VehicleType").toString().equals(vehicleDescription)) {
                        
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
    public Invoice getInvoiceByVehicleType(String vehicleType) throws ParseException {
        
        Invoice invoice = new Invoice();
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
                
                if (jsonObject.get("tipo de vehiculo").toString().equals(vehicleType)) {
                    invoice.setVehicleType((VehicleType) jsonObject.get("tipo de vehiculo"));
                    invoice.setHourlyRate((int) jsonObject.get("precio por hora"));
                    invoice.setNumberOfHours((int) jsonObject.get("cantidad de horas"));
                    System.out.println(invoice.toString());
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
        return invoice;
    }
    public LinkedList<Invoice> getAllFees() throws ParseException {
        LinkedList<Invoice> fees = new LinkedList<>();
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
                
                Invoice fee = new Invoice();
                fee.setVehicleType((VehicleType) jsonObject.get("tipo de vehiculo"));
                fee.setHourlyRate((int) jsonObject.get("precio por hora"));
                fee.setNumberOfHours((int) jsonObject.get("cantidad de horas"));
                System.out.println(fee.toString());
                fees.add(fee);
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
        return fees;
    }
    public void modifyInvoiceFromFile(String vehicleType, Invoice invoice) throws ParseException {

        try {

            JSONObject feeObject;

            File file = new File(pathFile);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("feesTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                feeObject = (JSONObject) new JSONParser().parse(line);

                if (!feeObject.get("tipo de vehiculo").toString().equals(vehicleType)) {

                    printWriter.println(line);
                    printWriter.flush();
                } else {
                    feeObject.put("tipo de vehiculo", invoice.getVehicleType());
                    feeObject.put("precio por hora",invoice.getHourlyRate());
                  feeObject.put("cantidad de horas",invoice.getNumberOfHours());

                    printWriter.println(feeObject.toJSONString());
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
}

