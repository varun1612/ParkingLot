package OBSERVER;
import ENUMS.ParkingEvent;
import MODELS.Ticket;


public class AdminAlert implements ParkingObserver {
    @Override
    public void onEvent(ParkingEvent event, Ticket ticket){
        if(event.equals(ParkingEvent.LOT_FULL)){
            System.out.println("PARKING LOT IS FULL");
        }
    }
}
