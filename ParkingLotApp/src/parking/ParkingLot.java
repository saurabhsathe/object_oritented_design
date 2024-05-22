package parking;

import enums.VehicleType;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {


    HashMap<Integer,Level> levels;
    public ParkingLot(int lvls, int spots) {
        for(int i=0;i<lvls;i++){
            levels.put(i,new Level(spots));
        }

    }

    public boolean parkVehicle(Vehicle vehicle){
        Level level;
        for(Integer lvl : levels.keySet()){
             level= levels.get(lvl);
            if(vehicle.getVehicleType()== VehicleType.Bus && (level.assignSpot(VehicleType.Bus,vehicle))){
                    return true;
            }
            if( (vehicle.getVehicleType()== VehicleType.Car) && (level.assignSpot(VehicleType.Car,vehicle) || level.assignSpot(VehicleType.Bus,vehicle))){
                    return true;
            }
            if(vehicle.getVehicleType()== VehicleType.Bike){
                if(level.assignSpot(VehicleType.Bike,vehicle) || level.assignSpot(VehicleType.Car,vehicle) || level.assignSpot(VehicleType.Bus,vehicle ))
                    return true;
            }
        }
        return false;
    }
    public void deAssignSpot(Vehicle vehicle){
        ParkingSpot pstop =  vehicle.getParkingSpot();
        Level level = pstop.getLevel();
        level.setAvailableSpots(level.getAvailableSpots()+1);
        vehicle.setParkingSpot(null);
        vehicle.setParked(false);
        pstop.setVehicle(null);
    }

}
