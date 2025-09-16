// File: MultilevelInheritanceDemo.java

// Base class Animal
class Animal {
    // Protected fields accessible to subclasses
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;
    
    // Constructor
    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }
    
    // Basic animal methods
    public void eat() {
        System.out.println("Animal is eating");
    }
    
    public void sleep() {
        System.out.println("Animal is sleeping");
    }
    
    public void move() {
        System.out.println("Animal is moving");
    }
    
    public String getAnimalInfo() {
        return String.format("Animal Info:\n" +
                           "Species: %s\n" +
                           "Habitat: %s\n" +
                           "Lifespan: %d years\n" +
                           "Wildlife: %s",
                           species, habitat, lifespan, 
                           isWildlife ? "Yes" : "No");
    }
}

// Intermediate class Mammal extends Animal
class Mammal extends Animal {
    // Mammal-specific fields
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod;
    
    // Constructor
    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.hasWarmBlood = true; // Always true for mammals
        this.gestationPeriod = gestationPeriod;
        System.out.println("Mammal constructor: Adding mammal traits");
    }
    
    // Override move() method from Animal
    @Override
    public void move() {
        super.move(); // Call parent method first
        System.out.println("Mammal is walking/running");
    }
    
    // Mammal-specific methods
    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }
    
    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
    
    // Override getAnimalInfo to include mammal details
    @Override
    public String getAnimalInfo() {
        return super.getAnimalInfo() + String.format("\n" +
                           "Fur Color: %s\n" +
                           "Warm Blooded: %s\n" +
                           "Gestation Period: %d days",
                           furColor, hasWarmBlood ? "Yes" : "No", gestationPeriod);
    }
}

// Specific class Dog extends Mammal
class Dog extends Mammal {
    // Dog-specific fields
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;
    
    // Constructor 1: Basic dog with minimal parameters
    public Dog(String breed) {
        super("Canis lupus familiaris", "Domestic", 13, false, "Various", 63);
        this.breed = breed;
        this.isDomesticated = true;
        this.loyaltyLevel = 8;
        this.favoriteActivity = "Playing fetch";
        System.out.println("Dog constructor: Creating " + breed + " dog (basic)");
    }
    
    // Constructor 2: Detailed dog with all parameters
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod, String breed, 
               boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog (detailed)");
    }
    
    // Constructor 3: Copy constructor
    public Dog(Dog otherDog) {
        this(otherDog.species, otherDog.habitat, otherDog.lifespan, otherDog.isWildlife,
             otherDog.furColor, otherDog.gestationPeriod, otherDog.breed,
             otherDog.isDomesticated, otherDog.loyaltyLevel, otherDog.favoriteActivity);
        System.out.println("Dog constructor: Creating copy of " + breed + " dog");
    }
    
    // Override eat() method from Animal
    @Override
    public void eat() {
        super.eat(); // Call parent method first
        System.out.println("Wagging tail while eating");
    }
    
    // Override move() method from Mammal
    @Override
    public void move() {
        super.move(); // Call parent method first
        System.out.println("Dog is running and playing");
    }
    
    // Override sleep() method from Animal
    @Override
    public void sleep() {
        super.sleep(); // Call parent method first
        System.out.println("Dog is sleeping in doghouse");
    }
    
    // Dog-specific methods
    public void bark() {
        System.out.println("Woof! Woof!");
    }
    
    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }
    
    public void showLoyalty() {
        System.out.println("Loyalty level: " + loyaltyLevel + "/10 - " + 
                       (loyaltyLevel >= 8 ? "Extremely loyal" : 
                        loyaltyLevel >= 6 ? "Very loyal" : "Moderately loyal"));
    }
    
    // Method that demonstrates calling up the inheritance chain
    public void demonstrateInheritance() {
        System.out.println("\n=== Demonstrating Inheritance Chain ===");
        System.out.println("Calling methods from all three levels:");
        
        System.out.println("\n1. Animal level methods:");
        super.sleep(); // Call Animal's sleep directly
        
        System.out.println("\n2. Mammal level methods:");
        super.move(); // Call Mammal's move (which calls Animal's move)
        nurse();
        regulateTemperature();
        
        System.out.println("\n3. Dog level methods:");
        eat(); // This will call the full chain
        bark();
        fetch();
        showLoyalty();
        
        System.out.println("=== End Inheritance Chain Demo ===\n");
    }
    
    // Override getAnimalInfo to include dog details
    @Override
    public String getAnimalInfo() {
        return super.getAnimalInfo() + String.format("\n" +
                           "Breed: %s\n" +
                           "Domesticated: %s\n" +
                           "Loyalty Level: %d/10\n" +
                           "Favorite Activity: %s",
                           breed, isDomesticated ? "Yes" : "No", 
                           loyaltyLevel, favoriteActivity);
    }
    
    // Getter methods
    public String getBreed() { return breed; }
    public boolean isDomesticated() { return isDomesticated; }
    public int getLoyaltyLevel() { return loyaltyLevel; }
    public String getFavoriteActivity() { return favoriteActivity; }
    
    // Setter methods
    public void setBreed(String breed) { this.breed = breed; }
    public void setDomesticated(boolean domesticated) { this.isDomesticated = domesticated; }
    public void setLoyaltyLevel(int loyaltyLevel) { this.loyaltyLevel = loyaltyLevel; }
    public void setFavoriteActivity(String favoriteActivity) { this.favoriteActivity = favoriteActivity; }
}

public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Multilevel Inheritance Demonstration ===\n");
        
        // Test multilevel constructor chaining
        System.out.println("1. Testing Constructor Chaining:");
        System.out.println("Creating Dog with basic constructor:");
        Dog dog1 = new Dog("Golden Retriever");
        
        System.out.println("\nCreating Dog with detailed constructor:");
        Dog dog2 = new Dog("Canis lupus familiaris", "Domestic", 15, false, 
                          "Golden", 63, "Labrador", true, 9, "Swimming");
        
        System.out.println("\nCreating Dog with copy constructor:");
        Dog dog3 = new Dog(dog2);
        
        // Test method overriding across levels
        System.out.println("\n2. Testing Method Overriding Across Levels:");
        System.out.println("\nDog1 eating (shows inheritance chain):");
        dog1.eat();
        
        System.out.println("\nDog1 moving (shows inheritance chain):");
        dog1.move();
        
        System.out.println("\nDog1 sleeping (shows inheritance chain):");
        dog1.sleep();
        
        // Test access to inherited members
        System.out.println("\n3. Testing Access to Inherited Members:");
        System.out.println("\nAccessing fields from all levels:");
        System.out.println("Animal level - Species: " + dog1.species);
        System.out.println("Animal level - Habitat: " + dog1.habitat);
        System.out.println("Mammal level - Fur Color: " + dog1.furColor);
        System.out.println("Mammal level - Warm Blooded: " + dog1.hasWarmBlood);
        System.out.println("Dog level - Breed: " + dog1.getBreed());
        System.out.println("Dog level - Loyalty: " + dog1.getLoyaltyLevel());
        
        System.out.println("\nCalling methods from all levels:");
        dog1.nurse(); // Mammal method
        dog1.regulateTemperature(); // Mammal method
        dog1.bark(); // Dog method
        dog1.fetch(); // Dog method
        
        // Demonstrate the chain of inheritance
        System.out.println("\n4. Demonstrating Inheritance Chain:");
        System.out.println("\nDog IS-A Mammal IS-A Animal relationships:");
        System.out.println("dog1 instanceof Dog: " + (dog1 instanceof Dog));
        System.out.println("dog1 instanceof Mammal: " + (dog1 instanceof Mammal));
        System.out.println("dog1 instanceof Animal: " + (dog1 instanceof Animal));
        
        // Test with different object types
        Animal animal = new Animal("Tiger", "Jungle", 15, true);
        Mammal mammal = new Mammal("Elephant", "Savanna", 60, true, "Gray", 660);
        
        System.out.println("\nTesting instanceof with different objects:");
        System.out.println("animal instanceof Animal: " + (animal instanceof Animal));
        System.out.println("animal instanceof Mammal: " + (animal instanceof Mammal));
        System.out.println("mammal instanceof Animal: " + (mammal instanceof Animal));
        System.out.println("mammal instanceof Mammal: " + (mammal instanceof Mammal));
        
        // Demonstrate inheritance chain method calls
        System.out.println("\n5. Demonstrating Inheritance Chain Method Calls:");
        dog1.demonstrateInheritance();
        
        // Test different constructor patterns
        System.out.println("\n6. Testing Different Constructor Patterns:");
        System.out.println("\nBasic constructor result:");
        System.out.println(dog1.getAnimalInfo());
        
        System.out.println("\nDetailed constructor result:");
        System.out.println(dog2.getAnimalInfo());
        
        System.out.println("\nCopy constructor result:");
        System.out.println(dog3.getAnimalInfo());
        
        // Polymorphic behavior demonstration
        System.out.println("\n7. Polymorphic Behavior Demonstration:");
        Animal[] animals = {animal, mammal, dog1, dog2};
        
        System.out.println("\nPolymorphic method calls:");
        for (int i = 0; i < animals.length; i++) {
            System.out.println("\nAnimal " + (i + 1) + " moving:");
            animals[i].move();
        }
        
        System.out.println("\n=== Multilevel Inheritance Demo Complete ===");
    }
}
