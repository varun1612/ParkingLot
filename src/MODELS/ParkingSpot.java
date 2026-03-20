package MODELS;
import java.util.UUID;

import ENUMS.*;

public class ParkingSpot {
    private final String spotId;
    private final SpotType type;
    private boolean isAvailable;
    private Vehicle assignedVehicle;

    public ParkingSpot(SpotType type){
        spotId = UUID.randomUUID().toString();
        this.type = type;
        isAvailable = true;
        assignedVehicle = null;
    }

    public String getSpotId(){return spotId;}
    public SpotType getSpotType(){return type;}
    public boolean getAvailability(){return isAvailable;}
    public Vehicle getAssignedVehicle(){return assignedVehicle;}

    public void setVehicle(Vehicle vehicle){
        this.assignedVehicle = vehicle;
        this.isAvailable = (vehicle == null);
    }

    public void setAvailability(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
}
