package OBSERVER;
import ENUMS.ParkingEvent;
import MODELS.Ticket;

public class DisplayBoard implements ParkingObserver {
    @Override
    public void onEvent(ParkingEvent event, Ticket ticket){
        if(event.equals(ParkingEvent.VEHICLE_PARKED)){
            System.out.println("Vehicle "+ticket.getAssignedVehicle().getLicensePlate()+" Parked at Spot "+ticket.getAssignedSpot().getSpotId());
        }
        if(event.equals(ParkingEvent.VEHICLE_UNPARKED)){
            System.out.println("Vehicle "+ticket.getAssignedVehicle().getLicensePlate()+" Un-Parked from Spot "+ticket.getAssignedSpot().getSpotId());
        }
    }
}
