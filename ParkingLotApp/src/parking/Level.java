package parking;

import java.util.ArrayList;

public class Level {


    ArrayList<ParkingSpot> parkingSpots;
    int availableSpots;
    Level(int numSpots){
        availableSpots=numSpots;
        int compactSpots = numSpots/3;
        int largeSpots = compactSpots;
        int bikeSpots = numSpots-compactSpots-largeSpots;


    }
}
