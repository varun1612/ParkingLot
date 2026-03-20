import ENUMS.*;
import FEESTRATEGY.*;
import MODELS.*;
import SPOTASSIGNMENTSTRATEGY.*;
import OBSERVER.ParkingObserver;
import java.util.*;


public class ParkingLot {
    private final String lotId;
    private String description;
    private List<ParkingFloor> floors;
    private FeeCalculator feeCalc;
    private SpotAssignmentStrategy assignStrategy;
    private Map<String,Ticket> activeTickets;
    private static ParkingLot instance;

    private ParkingLot(String description, List<ParkingFloor> floors,FeeCalculator feeCalc,SpotAssignmentStrategy assignStrategy){
        this.lotId = UUID.randomUUID().toString();
        this.description = description;
        this.floors = floors;
        this.feeCalc = feeCalc;
        this.assignStrategy = assignStrategy;
        this.activeTickets = new HashMap<>();
    }

    public void getDescription(){
        System.out.print(description);
    }

    public void lotId(){
        System.out.print(lotId);
    }

    public static synchronized void initialize(String description, List<ParkingFloor> floors, FeeCalculator feeCalc, SpotAssignmentStrategy assignStrategy){
        if(instance==null){
        instance = new ParkingLot(description, floors, feeCalc, assignStrategy);
        }
    }

    public static synchronized ParkingLot getInstance(){
        if(instance==null){
            throw new IllegalArgumentException("Parking Lot is not yet initialized");
        }
        return instance;
    }

    private List<ParkingObserver> observers = new ArrayList<>();

    public void addObserver(ParkingObserver observer){
        observers.add(observer);
    }
    private void notifyObservers(ParkingEvent event, Ticket ticket){
        for(ParkingObserver observer:observers){
            observer.onEvent(event, ticket);
        }
    }
    
    public boolean isFull(){
        for(ParkingFloor floor:floors){
            for(ParkingSpot spot:floor.getParkingSpots()){
                if(spot.getAvailability())
                    return false;
            }
        }
        return true;
    }
    public Ticket parkVehicle(Vehicle vehicle){
        ParkingSpot assignSpot = assignStrategy.assignSpot(floors, vehicle);
        if(assignSpot==null){
            throw new IllegalArgumentException("No available spot for Vehicle type "+vehicle.getVehicleType());
        }
        assignSpot.setVehicle(vehicle);
        Ticket ticket = new Ticket(assignSpot, vehicle);
        activeTickets.put(ticket.getTicketId(), ticket);
        notifyObservers(ParkingEvent.VEHICLE_PARKED,ticket);
        if(isFull()){
            notifyObservers(ParkingEvent.LOT_FULL,null);
        }
        return ticket;

    }

    public double unParkVehicle(Ticket ticket){
        if (!activeTickets.containsKey(ticket.getTicketId())) {
        throw new IllegalArgumentException("Invalid ticket: " + ticket.getTicketId());
    }
        double fee = feeCalc.feeCalculator(ticket, ticket.getEntryTime().plusHours(2));
        ticket.getAssignedSpot().setVehicle(null);
        activeTickets.remove(ticket.getTicketId());
        notifyObservers(ParkingEvent.VEHICLE_UNPARKED,ticket);
        return fee;
    }

}
