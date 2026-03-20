package SPOTASSIGNMENTSTRATEGY;
import MODELS.*;
import java.util.*;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
