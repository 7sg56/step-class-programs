class CircularQueue {
    int front, rear, size;
    int[] queue;

    CircularQueue(int n) {
        size = n;
        queue = new int[size];
        front = rear = -1;
    }

    void enqueue(int val) {
        if ((rear + 1) % size == front) System.out.println("Queue Full");
        else {
            if (front == -1) front = 0;
            rear = (rear + 1) % size;
            queue[rear] = val;
        }
    }

    void dequeue() {
        if (front == -1) System.out.println("Queue Empty");
        else {
            System.out.println("Dequeued: " + queue[front]);
            if (front == rear) front = rear = -1;
            else front = (front + 1) % size;
        }
    }

    void display() {
        if (front == -1) System.out.println("Queue Empty");
        else {
            System.out.print("Queue: ");
            int i = front;
            while (true) {
                System.out.print(queue[i] + " ");
                if (i == rear) break;
                i = (i + 1) % size;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.display();
        cq.dequeue();
        cq.enqueue(40);
        cq.display();
    }
}
