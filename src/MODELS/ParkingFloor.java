package MODELS;
import java.util.*;

public class ParkingFloor {
    private final int floorNum;
    private List<ParkingSpot> spots;

    public ParkingFloor(int floorNum, List<ParkingSpot> spots){
        this.floorNum=floorNum;
        this.spots=spots;
    }

    public int getFloorNum(){return floorNum;}
    public List<ParkingSpot> getParkingSpots(){return spots;}
}
