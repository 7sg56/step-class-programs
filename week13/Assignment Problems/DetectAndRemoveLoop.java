class Node2 {
    int data;
    Node2 next;

    Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DetectAndRemoveLoop {
    Node2 head;

    public void detectAndRemoveLoop() {
        Node2 slow = head, fast = head;
        boolean loopExists = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        if (!loopExists) {
            System.out.println("No loop detected.");
            return;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        Node2 startOfLoop = slow;
        Node2 temp = startOfLoop;
        while (temp.next != startOfLoop) {
            temp = temp.next;
        }

        temp.next = null;
        System.out.println("Loop detected and removed.");
    }

    public void display() {
        Node2 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DetectAndRemoveLoop list = new DetectAndRemoveLoop();
        list.head = new Node2(10);
        list.head.next = new Node2(20);
        list.head.next.next = new Node2(30);
        list.head.next.next.next = new Node2(40);
        list.head.next.next.next.next = new Node2(50);

        // Creating a loop: 50 → 30
        list.head.next.next.next.next.next = list.head.next.next;

        list.detectAndRemoveLoop();
        list.display();
    }
}
