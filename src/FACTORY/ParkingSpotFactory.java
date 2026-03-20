package FACTORY;

import MODELS.ParkingSpot;
import ENUMS.SpotType;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotFactory {
   public static ParkingSpot createSpot(String type){
    try{
        return new ParkingSpot(SpotType.valueOf(type.toUpperCase()));
    }
    catch(IllegalArgumentException e){
        throw new IllegalArgumentException("Invalid Spot Type "+type);
    }
   } 

   public static List<ParkingSpot> createSpots(int small, int medium, int large){
    List<ParkingSpot> spots = new ArrayList<>();
        for(int i=1;i<=small;i++){
            spots.add(createSpot("SMALL"));
        }
        for(int i=1;i<=medium;i++){
            spots.add(createSpot("MEDIUM"));
        }for(int i=1;i<=large;i++){
            spots.add(createSpot("LARGE"));
        }

        return spots;
   }
}
