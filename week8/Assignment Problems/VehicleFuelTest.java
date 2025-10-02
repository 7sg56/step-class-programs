abstract class Vehicle {
    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped.");
    }
}

interface Fuel {
    void refuel();
}

class Car extends Vehicle implements Fuel {
    @Override
    void start() {
        System.out.println("Car started.");
    }

    @Override
    public void refuel() {
        System.out.println("Car refueled with petrol.");
    }
}

public class VehicleFuelTest {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();
        car.refuel();
    }
}
