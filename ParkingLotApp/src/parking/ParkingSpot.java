package parking;

import enums.ParkingSpotType;
import vehicle.Vehicle;

public class ParkingSpot {

    ParkingSpotType type;
    int id;
    Level level;
    boolean isTaken;
    Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot(ParkingSpotType type, int id, Level level) {
        this.type = type;
        this.id = id;
        this.level = level;
        isTaken= false;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public void setType(ParkingSpotType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
