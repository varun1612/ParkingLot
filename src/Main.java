import java.util.ArrayList;
import java.util.List;


import FACTORY.ParkingSpotFactory;
import FACTORY.VehicleFactory;
import MODELS.*;
import OBSERVER.AdminAlert;
import OBSERVER.DisplayBoard;
import SPOTASSIGNMENTSTRATEGY.*;
import FEESTRATEGY.*;

public class Main {
    public static void main(String[] args) {
        ParkingFloor floor1 = new ParkingFloor(1, ParkingSpotFactory.createSpots(1, 0, 0));
        ParkingFloor floor2 = new ParkingFloor(2, ParkingSpotFactory.createSpots(0, 1, 0));
        ParkingFloor floor3 = new ParkingFloor(3, ParkingSpotFactory.createSpots(0, 0, 1));

        Vehicle car1 = VehicleFactory.createVehicle("KA03MM6773", "CAR");
        Vehicle truck1 = VehicleFactory.createVehicle("TG0188888", "TRUCK");
        Vehicle bike1 = VehicleFactory.createVehicle("AP7890", "BIKE");

        FlatHourlyRate rate = new FlatHourlyRate();
        rate.setFlatRate(50.0); // ✅ set rate

        ParkingLot.initialize("Varun Parking Arena", new ArrayList<>(List.of(floor1,floor2,floor3)), rate, new NearestFirstStrategy());

        ParkingLot lot1 = ParkingLot.getInstance();


        lot1.addObserver(new AdminAlert());
        lot1.addObserver(new DisplayBoard());

        
        Ticket carTicket = lot1.parkVehicle(car1);   // ✅ store ticket
        Ticket bikeTicket = lot1.parkVehicle(bike1);
        Ticket truckTicket = lot1.parkVehicle(truck1);

        
        

       /*  System.out.println("Car parked. Ticket: " + carTicket.getTicketId());
        System.out.println("Bike parked. Ticket: " + bikeTicket.getTicketId());
        System.out.println("Truck parked. Ticket: " + truckTicket.getTicketId()); */

        double fee = lot1.unParkVehicle(carTicket);
        System.out.println("Car fee: Rs. " + fee+"/-");
    }
}