package Domain;

import java.util.Date;
import java.util.HashMap;


public class Administrator extends User implements Employee{
    


    public Administrator() {
    }
     
    public Administrator( String id, String name,String username, String password,String email,String phone) {
        
        super(id, name, username, password, email,phone);
        
        
    }
      
    @Override
    public boolean verifyUserLogin(String[ ] loginDetails) {
        int dataControl=0;
        boolean correctAdministratorData=false;
        if(loginDetails[dataControl]!=null&&loginDetails[dataControl=+1]!=null){
            correctAdministratorData=true;
        }
        return  correctAdministratorData;
        
    }

    @Override
    public float calculateSalary(float dailySalary) {
        return dailySalary;
    }

    @Override
    public ParkingLot assignWorkplace(int parkingLotId) {
       ParkingLot parkingLot =new ParkingLot();
        if(parkingLotId==parkingLot.getId()){
           parkingLot=parkingLot;
        }
          return  parkingLot;
    }
    
       
}