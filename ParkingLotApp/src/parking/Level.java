package parking;

import enums.ParkingSpotType;
import enums.VehicleType;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

public class Level {


    HashMap<ParkingSpotType,ArrayList<ParkingSpot>> parkingSpots = new HashMap<>();
    int availableSpots;
    ArrayList<ParkingSpot> temp;
    Level(int numSpots){
        availableSpots=numSpots;
        int compactSpots = numSpots/3;
        int largeSpots = compactSpots;
        int bikeSpots = numSpots-compactSpots-largeSpots;


        for(int i=0;i<numSpots;i++){
            ParkingSpot pstop;
            if(compactSpots>0) {
                 pstop= new ParkingSpot(ParkingSpotType.Compact,i, this);
                compactSpots--;
            }
            else if(largeSpots>0) {
                pstop = new ParkingSpot(ParkingSpotType.Large,i, this);
                largeSpots--;
            }
            else{
                pstop = new ParkingSpot(ParkingSpotType.BikeSpot,i, this);
                bikeSpots--;
            }

            temp = parkingSpots.getOrDefault(pstop.getType(), new ArrayList<>());
            temp.add(pstop);
            parkingSpots.put(pstop.getType(),temp);
        }

    }


    public int getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(int availableSpots) {
        this.availableSpots = availableSpots;
    }

    public boolean assignSpot(VehicleType vehicleType, Vehicle vehicle){
        if(availableSpots<=0){
            return false;
        }
        ParkingSpotType reqd ;
        if(vehicleType==VehicleType.Bike){
            reqd = ParkingSpotType.BikeSpot;
        }
        else if(vehicleType==VehicleType.Car){
            reqd = ParkingSpotType.Compact;
        }
        else {
            reqd = ParkingSpotType.BikeSpot;
        }


        for(ParkingSpot pstop:parkingSpots.get(reqd)){
            if(!pstop.isTaken()){
                pstop.setTaken(true);
                pstop.setVehicle(vehicle);
                vehicle.setParkingSpot(pstop);
                vehicle.setParked(true);
                availableSpots--;
                return true;


            }
        }
        return false;

    }



}
