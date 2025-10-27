abstract class Vehicle {
    protected String type;
    
    public Vehicle(String type) { 
        this.type = type; 
    }
    
    public abstract void dispatch();
}

class Bus extends Vehicle {
    public Bus() { 
        super("Bus"); 
    }
    
    @Override
    public void dispatch() {
        System.out.println(type + ": Dispatched on FIXED ROUTE and tracking capacity.");
    }
}

class Taxi extends Vehicle {
    public Taxi() { 
        super("Taxi"); 
    }
    
    @Override
    public void dispatch() {
        System.out.println(type + ": Dispatched for DOOR-TO-DOOR service, calculating fare by distance.");
    }
}

public class W7_P3_Test {
    public static void main(String[] args) {
        // Array of Vehicle references pointing to different actual objects
        Vehicle[] fleet = new Vehicle[2];
        fleet[0] = new Bus();
        fleet[1] = new Taxi();
        
        System.out.println("--- Unified Dispatch System (Dynamic Method Dispatch) ---");
        for (Vehicle v : fleet) {
            // The method called is determined at runtime based on the object type
            v.dispatch();
        }
    }
}
