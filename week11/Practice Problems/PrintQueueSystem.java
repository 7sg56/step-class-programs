import java.util.*;

public class PrintQueueSystem {
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Command (ADD <doc>/PRINT/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("ADD")) {
                printQueue.add(sc.next());
            } else if (cmd.equalsIgnoreCase("PRINT")) {
                if (!printQueue.isEmpty())
                    System.out.println("Printing " + printQueue.poll());
                else
                    System.out.println("No jobs left!");
            } else if (cmd.equalsIgnoreCase("EXIT")) break;
            else System.out.println("Invalid command!");
        }
        sc.close();
    }
}
