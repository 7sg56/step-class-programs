/**
 * Topic 2: equals() vs ==
 * Product class demonstrating the difference between reference and content comparison
 */
public class Product {
    private int productId;
    private String productName;
    
    // Constructor
    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
    
    // Getters
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    
    // Override equals() method to compare objects by productId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Product product = (Product) obj;
        return productId == product.productId;
    }
    
    // Override toString() for better output
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                '}';
    }
    
    public static void main(String[] args) {
        // Create Product objects
        Product product1 = new Product(101, "Laptop");
        Product product2 = new Product(101, "Laptop");  // Same productId, different object
        Product product3 = product1;  // Same reference
        
        System.out.println("Product Objects:");
        System.out.println("product1: " + product1);
        System.out.println("product2: " + product2);
        System.out.println("product3: " + product3);
        
        System.out.println("\n=== Reference Comparison (==) ===");
        System.out.println("product1 == product2: " + (product1 == product2));
        System.out.println("product1 == product3: " + (product1 == product3));
        System.out.println("product2 == product3: " + (product2 == product3));
        
        System.out.println("\n=== Content Comparison (.equals()) ===");
        System.out.println("product1.equals(product2): " + product1.equals(product2));
        System.out.println("product1.equals(product3): " + product1.equals(product3));
        System.out.println("product2.equals(product3): " + product2.equals(product3));
        
        System.out.println("\n=== Explanation ===");
        System.out.println("== checks if two references point to the same object in memory");
        System.out.println(".equals() checks if two objects have the same content (based on our override)");
        System.out.println("product1 and product2 have same productId but are different objects");
        System.out.println("product1 and product3 are the same object (same reference)");
        
        // Demonstrate with different productId
        Product product4 = new Product(102, "Mouse");
        System.out.println("\n=== Different Product ===");
        System.out.println("product1: " + product1);
        System.out.println("product4: " + product4);
        System.out.println("product1 == product4: " + (product1 == product4));
        System.out.println("product1.equals(product4): " + product1.equals(product4));
    }
}
