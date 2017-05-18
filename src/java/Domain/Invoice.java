package Domain;

public class Invoice {

    private int hourlyRate;
    private int numberOfHours;
    private VehicleType vehicleType;

    public Invoice() {
    }

    public Invoice(int hourlyRate, int numberOfHours, VehicleType vehicleType) {
        this.hourlyRate = hourlyRate;
        this.numberOfHours = numberOfHours;
        this.vehicleType = vehicleType;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
