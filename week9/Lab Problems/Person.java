/**
 * LAB PROBLEM 4: Cloning an Object
 * Topic: Object Cloning – Shallow Copy vs Deep Copy
 * 
 * Create a Person class with name and Address object as fields. Implement Cloneable and
 * demonstrate both shallow and deep cloning.
 */

public class Person implements Cloneable {
    private String name;
    private Address address;
    
    // Constructor
    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    // Shallow clone implementation
    public Person shallowClone() {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Deep clone implementation
    public Person deepClone() {
        try {
            Person cloned = (Person) super.clone();
            // Create a new Address object for deep copy
            cloned.address = new Address(
                this.address.getStreet(),
                this.address.getCity(),
                this.address.getZipCode()
            );
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Override toString()
    @Override
    public String toString() {
        return "Person{name='" + name + "', address=" + address + "}";
    }
    
    // Main method to demonstrate shallow vs deep cloning
    public static void main(String[] args) {
        System.out.println("=== LAB PROBLEM 4: Shallow Copy vs Deep Copy ===");
        
        // Create original person
        Address originalAddress = new Address("123 Main St", "New York", "10001");
        Person originalPerson = new Person("John Doe", originalAddress);
        
        System.out.println("Original Person: " + originalPerson);
        System.out.println();
        
        // Demonstrate shallow cloning
        System.out.println("=== SHALLOW CLONING ===");
        Person shallowClone = originalPerson.shallowClone();
        System.out.println("Shallow Clone: " + shallowClone);
        System.out.println("Same address reference? " + (originalPerson.getAddress() == shallowClone.getAddress()));
        System.out.println();
        
        // Demonstrate deep cloning
        System.out.println("=== DEEP CLONING ===");
        Person deepClone = originalPerson.deepClone();
        System.out.println("Deep Clone: " + deepClone);
        System.out.println("Same address reference? " + (originalPerson.getAddress() == deepClone.getAddress()));
        System.out.println();
        
        // Demonstrate the difference by modifying the address
        System.out.println("=== MODIFYING ADDRESS TO SHOW DIFFERENCE ===");
        System.out.println("Before modification:");
        System.out.println("Original: " + originalPerson);
        System.out.println("Shallow Clone: " + shallowClone);
        System.out.println("Deep Clone: " + deepClone);
        System.out.println();
        
        // Modify the original address
        originalPerson.getAddress().setStreet("456 Oak Ave");
        originalPerson.getAddress().setCity("Los Angeles");
        originalPerson.getAddress().setZipCode("90210");
        
        System.out.println("After modifying original address:");
        System.out.println("Original: " + originalPerson);
        System.out.println("Shallow Clone: " + shallowClone + " (affected by original change)");
        System.out.println("Deep Clone: " + deepClone + " (not affected by original change)");
        System.out.println();
        
        // Show reference equality
        System.out.println("=== REFERENCE COMPARISON ===");
        System.out.println("Original address == Shallow clone address: " + 
                         (originalPerson.getAddress() == shallowClone.getAddress()));
        System.out.println("Original address == Deep clone address: " + 
                         (originalPerson.getAddress() == deepClone.getAddress()));
        System.out.println("Shallow clone address == Deep clone address: " + 
                         (shallowClone.getAddress() == deepClone.getAddress()));
    }
}
