class Practice5_PhotoViewer {
    class Node {
        String photo;
        Node next, prev;
        Node(String p) { photo = p; }
    }

    Node head, tail, current;

    public void addPhoto(String p) {
        Node newNode = new Node(p);
        if (head == null) {
            head = tail = current = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void nextPhoto() {
        if (current == null || current.next == null) {
            System.out.println("No next photo!");
            return;
        }
        current = current.next;
        System.out.println("Next → " + current.photo);
    }

    public void prevPhoto() {
        if (current == null || current.prev == null) {
            System.out.println("No previous photo!");
            return;
        }
        current = current.prev;
        System.out.println("Prev ← " + current.photo);
    }

    public void showCurrent() {
        if (current == null)
            System.out.println("No photos available!");
        else
            System.out.println("Current: " + current.photo);
    }

    public static void main(String[] args) {
        Practice5_PhotoViewer viewer = new Practice5_PhotoViewer();
        viewer.addPhoto("Pic1");
        viewer.addPhoto("Pic2");
        viewer.addPhoto("Pic3");

        viewer.showCurrent();
        viewer.nextPhoto();
        viewer.nextPhoto();
        viewer.prevPhoto();
    }
}
