package Domain;



public class Clerk extends User implements Employee{
    
    

    public Clerk() {
    }
    
    public Clerk(String phone, String id, String name, String username, String password, String email) {
        super(id, name, username, password,email,phone);
        
    }

            
    @Override
    public boolean verifyUserLogin(String[ ] loginDetails) {
        int dataControl=0;
        boolean correctClerkData=false;
        if(loginDetails[dataControl]!=null&&loginDetails[dataControl=+1]!=null){
            correctClerkData=true;
        }
        return  correctClerkData;
        
    }
    
    @Override
    public float calculateSalary(float dailySalary) {
        return dailySalary;
    }
    


    @Override
    public ParkingLot assignWorkplace(int parkingLotId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}    
