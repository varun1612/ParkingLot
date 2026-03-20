package OBSERVER;
import MODELS.Ticket;
import ENUMS.ParkingEvent;

public interface ParkingObserver {
    public void onEvent(ParkingEvent event, Ticket ticket);
}
