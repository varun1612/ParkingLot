package FACTORY;
import ENUMS.VehicleType;
import MODELS.Vehicle;


public class VehicleFactory {
    public static Vehicle createVehicle(String licensePlate, String type){
        try {
            return new Vehicle(licensePlate, VehicleType.valueOf(type.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Vehicle Type "+type);
        }
    }
}
