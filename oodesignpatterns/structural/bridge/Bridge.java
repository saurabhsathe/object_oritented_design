//used for separately implementing abstraction

public class Bridge{
    public static void main(String[] args) {

    }
}
abstract class Vehicle{



    public abstract void start();
    public void accelerate(){
        System.out.println("Vehicle moving forward");
    }
    public void applyBrakes(){
        System.out.println("Vehicle speed decreasing");
    }
    public abstract void stop();


}

class EVehicle extends   Vehicle{
    public void start(){
        System.out.println("Starting the battery");
    }
    public void stop(){
        System.out.println("Turning battery off");
    }

}

class GasVehicle extends Vehicle{

    private  int milesLeft = 0;


    public void start(){
        System.out.println("Starting the engine");
    }
    public void stop(){
        System.out.println("Turning engine off");
    }

}



abstract class VehicleBrand{

    private Vehicle vehicle;
    String name;

    public abstract void addEngine();
    public abstract void addTyres();

    public void assembleVehicle(){

    }


}
