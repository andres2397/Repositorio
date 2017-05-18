package Domain;

public class Customer extends User {

    public Customer() {
      
    }

    public Customer(String phone,String id, String name, String username, String password,String email) {
      super(id, name, username, password, email, phone);
       
    }

  
    
    
//Este metodo verifica que se tenga el nombre de usuario y la contraseña
    @Override
    public boolean verifyUserLogin(String[ ] loginDetails) {
      int dataControl=0;
      boolean correctCustomerData=false;
            if(loginDetails[dataControl]!=null&&loginDetails[dataControl=+1]!=null){
                correctCustomerData=true;
            }
        return  correctCustomerData;
    }
}