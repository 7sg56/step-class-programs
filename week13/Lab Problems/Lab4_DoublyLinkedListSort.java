class DNode2 {
    int data;
    DNode2 prev, next;

    DNode2(int data) {
        this.data = data;
    }
}

public class Lab4_DoublyLinkedListSort {
    DNode2 head;

    public void bubbleSort() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            DNode2 temp = head;
            while (temp.next != null) {
                if (temp.data > temp.next.data) {
                    int t = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = t;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }

    public void display() {
        DNode2 temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " ⇄ " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Lab4_DoublyLinkedListSort list = new Lab4_DoublyLinkedListSort();
        list.head = new DNode2(40);
        list.head.next = new DNode2(10);
        list.head.next.prev = list.head;
        list.head.next.next = new DNode2(30);
        list.head.next.next.prev = list.head.next;
        list.head.next.next.next = new DNode2(20);
        list.head.next.next.next.prev = list.head.next.next;

        System.out.print("Before Sorting: ");
        list.display();

        list.bubbleSort();

        System.out.print("After Sorting: ");
        list.display();
    }
}
