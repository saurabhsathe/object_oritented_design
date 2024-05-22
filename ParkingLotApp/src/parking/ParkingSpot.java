package parking;

public class ParkingSpot {

    ParkingSpotType type;
    int id;
    Level level;
    Boolean isTaken;
    public ParkingSpot(ParkingSpotType type, int id, Level level) {
        this.type = type;
        this.id = id;
        this.level = level;
        isTaken= false;
    }



}
