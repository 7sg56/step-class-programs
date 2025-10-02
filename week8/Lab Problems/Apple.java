// Interface
interface Edible {
    void nutrientsInfo();
}

// Abstract class
abstract class Fruit {
    protected String color;
    protected String taste;

    Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    abstract void showDetails();
}

// Concrete class
class Apple extends Fruit implements Edible {
    private String variety;

    Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    @Override
    void showDetails() {
        System.out.println("Apple Variety: " + variety + ", Color: " + color + ", Taste: " + taste);
    }

    @Override
    public void nutrientsInfo() {
        System.out.println("Nutrients: Rich in Fiber, Vitamin C, and Antioxidants.");
    }

    public static void main(String[] args) {
        Apple apple = new Apple("Red", "Sweet", "Fuji");
        apple.showDetails();
        apple.nutrientsInfo();
    }
}
