package vehicle;

import enums.VehicleType;

public class Bus extends Vehicle{

    public  Bus(String plate){
        vehicleType = VehicleType.Bus;
        vehicleNum = plate;
        isParked=false;

    }


}
