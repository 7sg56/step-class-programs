// Interface
interface Maintainable {
    void serviceInfo();
}

// Abstract class
abstract class Vehicle {
    protected int speed;
    protected String fuelType;

    Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    abstract void startEngine();
}

// Concrete class
class Car extends Vehicle implements Maintainable {
    private String model;

    Car(int speed, String fuelType, String model) {
        super(speed, fuelType);
        this.model = model;
    }

    @Override
    void startEngine() {
        System.out.println(model + " engine started with " + fuelType + " fuel.");
    }

    @Override
    public void serviceInfo() {
        System.out.println(model + " requires service every 10,000 km.");
    }

    public static void main(String[] args) {
        Car car = new Car(180, "Petrol", "Honda Civic");
        car.startEngine();
        car.serviceInfo();
    }
}
