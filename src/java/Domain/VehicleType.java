package Domain;


public class VehicleType{
    private String description;
    private float fee; //precio asignado

    public VehicleType(String description, float fee) {
        this.description = description;
        this.fee = fee;
    }

 

    public VehicleType() {
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
}