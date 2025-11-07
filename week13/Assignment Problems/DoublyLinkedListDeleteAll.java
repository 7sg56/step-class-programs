class DNode {
    int data;
    DNode prev, next;

    DNode(int data) {
        this.data = data;
    }
}

public class DoublyLinkedListDeleteAll {
    DNode head;

    public void deleteAll(int value) {
        DNode temp = head;

        while (temp != null) {
            if (temp.data == value) {
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
    }

    public void display() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" ⇄ ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedListDeleteAll list = new DoublyLinkedListDeleteAll();
        list.head = new DNode(10);
        list.head.next = new DNode(20);
        list.head.next.prev = list.head;
        list.head.next.next = new DNode(30);
        list.head.next.next.prev = list.head.next;
        list.head.next.next.next = new DNode(20);
        list.head.next.next.next.prev = list.head.next.next;
        list.head.next.next.next.next = new DNode(40);
        list.head.next.next.next.next.prev = list.head.next.next.next;

        System.out.print("Before Deletion: ");
        list.display();

        list.deleteAll(20);

        System.out.print("After Deletion: ");
        list.display();
    }
}
