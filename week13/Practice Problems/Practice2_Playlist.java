import java.util.*;

class Practice2_Playlist {
    Node head;

    class Node {
        String song;
        Node next;

        Node(String s) {
            song = s;
            next = null;
        }
    }

    public void addSong(String song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public void playNext() {
        if (head == null) {
            System.out.println("No songs to play!");
            return;
        }
        System.out.println("Playing: " + head.song);
        head = head.next;
    }

    public void showPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        Node temp = head;
        System.out.print("Playlist: ");
        while (temp != null) {
            System.out.print(temp.song);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Practice2_Playlist p = new Practice2_Playlist();

        while (true) {
            System.out.print("Command (ADD <song>/PLAYNEXT/SHOW/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("ADD")) {
                String song = sc.next();
                p.addSong(song);
            } else if (cmd.equalsIgnoreCase("PLAYNEXT")) {
                p.playNext();
            } else if (cmd.equalsIgnoreCase("SHOW")) {
                p.showPlaylist();
            } else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid command!");
            }
        }
    }
}
