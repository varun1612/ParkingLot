package MODELS;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final LocalDateTime entryTime;
    //private final LocalDateTime exitTime;
    private ParkingSpot assignedSpot;
    private Vehicle assignedVehicle;

    public Ticket(ParkingSpot assignedSpot, Vehicle assignedVehicle){
        this.ticketId = UUID.randomUUID().toString();
        this.entryTime = LocalDateTime.now();
        this.assignedSpot = assignedSpot;
        this.assignedVehicle = assignedVehicle;
    }

    public String getTicketId(){return ticketId;}
    public LocalDateTime getEntryTime(){return entryTime;}
    public ParkingSpot getAssignedSpot(){return assignedSpot;}
    public Vehicle getAssignedVehicle(){return assignedVehicle;}

}
