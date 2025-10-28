import java.util.*;

class CustomerService {
    Queue<String> queue = new LinkedList<>();

    void arrive(String name) {
        queue.add(name);
        System.out.println(name + " joined the queue");
    }

    void serve() {
        if (queue.isEmpty()) System.out.println("No customers!");
        else System.out.println(queue.poll() + " is being served");
    }

    void display() {
        System.out.println("Current Queue: " + queue);
    }

    public static void main(String[] args) {
        CustomerService cs = new CustomerService();
        cs.arrive("Alice");
        cs.arrive("Bob");
        cs.arrive("Charlie");
        cs.display();
        cs.serve();
        cs.display();
    }
}
