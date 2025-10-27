// File: Address.java (Needs Cloneable for deep copy)
class Address implements Cloneable {
    public String city;
    
    public Address(String city) { 
        this.city = city; 
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException { 
        return super.clone(); 
    }
}

// File: Person.java
class Person implements Cloneable {
    public String name;
    public Address address; // Mutable field
    
    public Person(String name, Address address) { 
        this.name = name; 
        this.address = address; 
    }
    
    // Shallow Copy (default behavior of super.clone())
    public Person shallowClone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
    
    // Deep Copy (manually clone the mutable field)
    public Person deepClone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = (Address) address.clone();
        return cloned;
    }
    
    @Override
    public String toString() {
        return "Person [Name=" + name + ", City=" + address.city + "]";
    }
}

public class CloningTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address originalAddress = new Address("Mumbai");
        Person original = new Person("Ravi", originalAddress);
        
        Person shallow = original.shallowClone();
        Person deep = original.deepClone();
        
        System.out.println("--- Initial State ---");
        System.out.println("Original: " + original);
        
        // Change the mutable object in the original
        original.address.city = "Bangalore";
        
        System.out.println("\n--- After Changing Original's Address ---");
        System.out.println("Original: " + original);
        // Shallow copy is affected
        System.out.println("Shallow: " + shallow);
        // Deep copy is NOT affected
        System.out.println("Deep: " + deep);
    }
}
