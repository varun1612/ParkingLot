package SPOTASSIGNMENTSTRATEGY;
import java.util.*;

import ENUMS.SpotType;
import MODELS.ParkingFloor;
import MODELS.ParkingSpot;
import MODELS.Vehicle;

public class NearestFirstStrategy implements SpotAssignmentStrategy {
    @Override
    public ParkingSpot assignSpot(List<ParkingFloor> floors, Vehicle vehicle){
        SpotType required = 
        switch(vehicle.getVehicleType()){
            case BIKE->SpotType.SMALL;
            case CAR->SpotType.MEDIUM;
            case TRUCK->SpotType.LARGE;
            default->throw new IllegalArgumentException("No available type spot for this vehicle");
        };

        for (ParkingFloor floor : floors) {
        for (ParkingSpot spot : floor.getParkingSpots()) {
            if (spot.getAvailability() && spot.getSpotType().equals(required)) {
                return spot;
            }
        }
    }
    return null;
    }
}
