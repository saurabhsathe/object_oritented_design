package vehicle;

import enums.VehicleType;

public class Car extends  Vehicle{


    public  Car(String plate){
        vehicleType = VehicleType.Car;
        vehicleNum = plate;
        isParked=false;

    }
}
