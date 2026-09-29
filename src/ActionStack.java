public class ActionStack {
    private static class Node {
        String data;
        Node next;
        Node(String data, Node next) { this.data = data; this.next = next; }
    }

    private Node top;

    public void push(String action) {
        top = new Node(action, top);
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }

        System.out.println("\n--- Recent Actions (Stack: LIFO) ---");
        Node current = top;
        int number = 1;
        while (current != null) {
            System.out.println(number++ + ". " + current.data);
            current = current.next;
        }
    }
}
