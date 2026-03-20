package FEESTRATEGY;
import MODELS.Ticket;
import ENUMS.VehicleType;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class VehicleBasedRate implements FeeCalculator {
    private double bikeRate;
    private double carRate;
    private double truckRate;

    public VehicleBasedRate(double bikeRate, double carRate, double truckRate){
        this.bikeRate=bikeRate;
        this.carRate=carRate;
        this.truckRate=truckRate;
    }
    public void setBikeRate(double bikeRate){
        this.bikeRate=bikeRate;
    }
    public void setCarRate(double carRate){
        this.carRate=carRate;
    }
    public void setTruckRate(double truckRate){
        this.truckRate=truckRate;
    }

    private Map<VehicleType,Double> vehicleBaseRate = Map.of(
        VehicleType.BIKE,bikeRate,
        VehicleType.CAR,carRate,
        VehicleType.TRUCK,truckRate);

    @Override
    public double feeCalculator(Ticket ticket, LocalDateTime exitTime){
        long minutes = ChronoUnit.MINUTES.between(ticket.getEntryTime(), exitTime);
        double hours = Math.ceil(minutes/60.0);

        return (vehicleBaseRate.get(ticket.getAssignedVehicle().getVehicleType())*hours);
    }
    
}
