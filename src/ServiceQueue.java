public class ServiceQueue {
    private static class Node {
        String request;
        Node next;
        Node(String request) { this.request = request; }
    }

    private Node front;
    private Node rear;

    public void enqueue(String request) {
        Node node = new Node(request);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    public String dequeue() {
        if (front == null) return null;
        String value = front.request;
        front = front.next;
        if (front == null) rear = null;
        return value;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }

        System.out.println("\n--- Service Queue (FIFO) ---");
        Node current = front;
        int number = 1;
        while (current != null) {
            System.out.println(number++ + ". " + current.request);
            current = current.next;
        }
    }
}
