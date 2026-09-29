public class StudentLinkedList {
    private static class Node {
        Student data;
        Node next;
        Node(Student data) { this.data = data; }
    }

    private Node head;
    private int size;

    public void add(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public Student find(String id) {
        Node current = head;
        while (current != null) {
            if (current.data.getStudentId().equalsIgnoreCase(id)) return current.data;
            current = current.next;
        }
        return null;
    }

    public boolean update(String id, String name, String programme, double marks) {
        Student student = find(id);
        if (student == null) return false;
        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);
        return true;
    }

    public Student delete(String id) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.data.getStudentId().equalsIgnoreCase(id)) {
                if (previous == null) head = current.next;
                else previous.next = current.next;
                size--;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Node current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count++ + ". " + current.data);
            current = current.next;
        }
        System.out.println("Total records: " + size);
    }

    public Student[] toArray() {
        Student[] result = new Student[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        return result;
    }

    public int size() { return size; }
}
