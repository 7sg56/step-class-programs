// File: Registration.java
// clone(), Shallow vs Deep Copy Problem: "Course Registration System"

class ContactInfo implements Cloneable {
    private String email;
    private String phone;
    
    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
    
    // Override clone() for ContactInfo
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    // Getters and setters
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return "ContactInfo{email='" + email + "', phone='" + phone + "'}";
    }
}

class Student implements Cloneable {
    private String id;
    private String name;
    private ContactInfo contact;
    
    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
    
    // Shallow copy implementation
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // This creates a shallow copy
    }
    
    // Deep copy implementation
    public Student deepClone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) this.contact.clone();
        return cloned;
    }
    
    // Getters and setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ContactInfo getContact() {
        return contact;
    }
    
    public void setContact(ContactInfo contact) {
        this.contact = contact;
    }
    
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', contact=" + contact + "}";
    }
}

class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 1. Register student, clone (shallow and deep), change contact, observe results
        ContactInfo originalContact = new ContactInfo("john@email.com", "123-456-7890");
        Student originalStudent = new Student("ST001", "John Doe", originalContact);
        
        System.out.println("Original Student: " + originalStudent);
        System.out.println("Original Contact: " + originalContact);
        System.out.println();
        
        // Shallow copy
        Student shallowCopy = (Student) originalStudent.clone();
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Same contact object? " + (originalStudent.getContact() == shallowCopy.getContact()));
        System.out.println();
        
        // Deep copy
        Student deepCopy = originalStudent.deepClone();
        System.out.println("Deep Copy: " + deepCopy);
        System.out.println("Same contact object? " + (originalStudent.getContact() == deepCopy.getContact()));
        System.out.println();
        
        // Modify original contact
        System.out.println("=== Modifying original contact ===");
        originalContact.setEmail("john.updated@email.com");
        originalContact.setPhone("987-654-3210");
        
        System.out.println("After modifying original contact:");
        System.out.println("Original Student: " + originalStudent);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Deep Copy: " + deepCopy);
        System.out.println();
        
        // Demonstrate the difference
        System.out.println("=== Analysis ===");
        System.out.println("Shallow copy contact affected: " + 
            (originalStudent.getContact().getEmail().equals(shallowCopy.getContact().getEmail())));
        System.out.println("Deep copy contact unaffected: " + 
            (!originalStudent.getContact().getEmail().equals(deepCopy.getContact().getEmail())));
        
        // Modify deep copy contact independently
        System.out.println("\n=== Modifying deep copy contact independently ===");
        deepCopy.getContact().setEmail("deepcopy@email.com");
        System.out.println("Original Student: " + originalStudent);
        System.out.println("Deep Copy: " + deepCopy);
    }
}
