public class BST {
    private static class Node {
        Student student;
        Node left, right;

        Node(Student student) {
            this.student = student;
        }
    }

    private Node root;

    public boolean insert(Student student) {
        if (root == null) {
            root = new Node(student);
            return true;
        }

        Node current = root;
        while (true) {
            int comparison = student.getStudentId().compareToIgnoreCase(
                    current.student.getStudentId());

            if (comparison == 0) return false;

            if (comparison < 0) {
                if (current.left == null) {
                    current.left = new Node(student);
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(student);
                    return true;
                }
                current = current.right;
            }
        }
    }

    public Student search(String id) {
        Node current = root;
        while (current != null) {
            int comparison = id.compareToIgnoreCase(current.student.getStudentId());
            if (comparison == 0) return current.student;
            current = comparison < 0 ? current.left : current.right;
        }
        return null;
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }
        System.out.println("\n--- Students using BST (In-Order) ---");
        displayInOrder(root);
    }

    private void displayInOrder(Node node) {
        if (node == null) return;
        displayInOrder(node.left);
        System.out.println(node.student);
        displayInOrder(node.right);
    }

    public void clear() {
        root = null;
    }
}
