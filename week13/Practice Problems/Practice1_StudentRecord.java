import java.util.*;

class Practice1_StudentRecord {
    Node head;

    class Node {
        int rollNo;
        Node next;

        Node(int r) {
            rollNo = r;
            next = null;
        }
    }

    public void insert(int rollNo) {
        Node newNode = new Node(rollNo);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("No students added yet!");
            return;
        }
        Node temp = head;
        System.out.print("Students: ");
        while (temp != null) {
            System.out.print(temp.rollNo);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Practice1_StudentRecord list = new Practice1_StudentRecord();

        while (true) {
            System.out.print("Command (ADD <roll>/SHOW/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("ADD")) {
                int roll = sc.nextInt();
                list.insert(roll);
            } else if (cmd.equalsIgnoreCase("SHOW")) {
                list.display();
            } else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid command!");
            }
        }
    }
}
