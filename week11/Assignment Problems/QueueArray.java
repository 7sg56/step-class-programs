class QueueArray {
    int front, rear, size;
    int[] queue;

    QueueArray(int capacity) {
        size = capacity;
        queue = new int[size];
        front = rear = -1;
    }

    void enqueue(int data) {
        if (rear == size - 1) System.out.println("Queue Overflow");
        else {
            if (front == -1) front = 0;
            queue[++rear] = data;
        }
    }

    void dequeue() {
        if (front == -1 || front > rear) System.out.println("Queue Underflow");
        else System.out.println("Dequeued: " + queue[front++]);
    }

    void display() {
        if (front == -1 || front > rear) System.out.println("Queue Empty");
        else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) System.out.print(queue[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.display();
    }
}
