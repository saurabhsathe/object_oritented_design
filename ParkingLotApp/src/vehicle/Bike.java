package vehicle;

import enums.VehicleType;

public class Bike extends Vehicle{
    public  Bike(String plate){
        vehicleType = VehicleType.Bike;
        vehicleNum = plate;
        isParked=false;

    }
}
