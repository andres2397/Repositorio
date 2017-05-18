package Domain;


public class Space {
    
    private int id;
    private boolean disabilityAdaptation;
    private boolean spaceTaken;
    private VehicleType vehicleType;

    public Space() {
    }

    public Space(int id, boolean disabilityAdaptation, boolean spaceTaken, VehicleType vehicleType) {
        this.id = id;
        this.disabilityAdaptation = disabilityAdaptation;
        this.spaceTaken = spaceTaken;
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisabilityAdaptation() {
        return disabilityAdaptation;
    }

    public void setDisabilityAdaptation(boolean disabilityAdaptation) {
        this.disabilityAdaptation = disabilityAdaptation;
    }

    public boolean isSpaceTaken() {
        return spaceTaken;
    }

    public void setSpaceTaken(boolean spaceTaken) {
        this.spaceTaken = spaceTaken;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

