class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    public void delete(Node node) {
        if (head == null) {
            return;
        }
        if (head == node) {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            head = head.next;
            current.next = head;
        } else {
            Node current = head;
            while (current.next != head && current.next != node) {
                current = current.next;
            }
            if (current.next == node) {
                current.next = node.next;
            }
        }
    }

    public void josephus(int m) {
        Node current = head;
        while (head.next != head) {
            for (int i = 1; i < m - 1; i++) {
                current = current.next;
            }
            System.out.println("Removed: " + current.next.data);
            delete(current.next);
            current = current.next;
        }
        System.out.println("Survivor: " + head.data);
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Circular Linked List: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

public class App {
    public static void main(String[] args) {
        int n = 7;
        int m = 3; 

        CircularLinkedList circle = new CircularLinkedList();

        for (int i = 1; i <= n; i++) {
            circle.insert(i);
        }

        circle.display();
        circle.josephus(m);
    }
}
