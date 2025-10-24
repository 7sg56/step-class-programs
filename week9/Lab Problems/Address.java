/**
 * Address class for Person cloning demonstration
 */

public class Address implements Cloneable {
    private String street;
    private String city;
    private String zipCode;
    
    // Constructor
    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    // Getters and Setters
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    // Override clone() for Address
    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Override toString()
    @Override
    public String toString() {
        return "Address{street='" + street + "', city='" + city + "', zipCode='" + zipCode + "'}";
    }
}
