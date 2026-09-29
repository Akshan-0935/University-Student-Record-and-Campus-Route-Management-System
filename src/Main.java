import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentLinkedList studentList = new StudentLinkedList();
    private static final ActionStack actionStack = new ActionStack();
    private static final ServiceQueue serviceQueue = new ServiceQueue();
    private static final BST bst = new BST();
    private static final StudentHashTable hashTable = new StudentHashTable(101);
    private static final CampusGraph campusGraph = new CampusGraph();

    public static void main(String[] args) {
        seedCampus();

        System.out.println("==================================================");
        System.out.println(" UNIVERSITY STUDENT RECORD & CAMPUS ROUTE SYSTEM ");
        System.out.println("==================================================");
        System.out.println("CIT300 - Data Structures and Algorithms");

        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ", 1, 16);

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> deleteStudent();
                case 4 -> studentList.display();
                case 5 -> addServiceRequest();
                case 6 -> processServiceRequest();
                case 7 -> actionStack.display();
                case 8 -> bst.displayInOrder();
                case 9 -> searchStudentHash();
                case 10 -> addCampusLocation();
                case 11 -> removeCampusLocation();
                case 12 -> addCampusConnection();
                case 13 -> removeCampusConnection();
                case 14 -> campusGraph.displayConnections();
                case 15 -> traverseCampus();
                case 16 -> {
                    running = false;
                    System.out.println("Thank you. Program closed successfully.");
                }
            }

            if (running) pause();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n---------------- MAIN MENU ----------------");
        System.out.println("1.  Add Student Record");
        System.out.println("2.  Update Student Record");
        System.out.println("3.  Delete Student Record");
        System.out.println("4.  Display All Records using Linked List");
        System.out.println("5.  Add Service Request to Queue");
        System.out.println("6.  Process Next Service Request");
        System.out.println("7.  Display Recent Actions using Stack");
        System.out.println("8.  Display Students using BST");
        System.out.println("9.  Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS");
        System.out.println("16. Exit");
        System.out.println("-------------------------------------------");
    }

    private static void addStudent() {
        System.out.println("\n--- Add Student Record ---");
        String id = readNonEmpty("Student ID: ");

        if (studentList.find(id) != null) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        String name = readNonEmpty("Name: ");
        String programme = readNonEmpty("Programme: ");
        double marks = readMarks();

        Student student = new Student(id, name, programme, marks);
        studentList.add(student);
        bst.insert(student);
        hashTable.put(student);

        actionStack.push("Added student " + id);
        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {
        System.out.println("\n--- Update Student Record ---");
        String id = readNonEmpty("Enter Student ID: ");
        Student existing = studentList.find(id);

        if (existing == null) {
            System.out.println("Student record not found.");
            return;
        }

        String name = readNonEmpty("New name: ");
        String programme = readNonEmpty("New programme: ");
        double marks = readMarks();

        studentList.update(id, name, programme, marks);

        // The BST and hash table store references to the same Student object,
        // so the updated values are automatically reflected.
        actionStack.push("Updated student " + id);
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        System.out.println("\n--- Delete Student Record ---");
        String id = readNonEmpty("Enter Student ID: ");

        Student deleted = studentList.delete(id);
        if (deleted == null) {
            System.out.println("Student record not found.");
            return;
        }

        // Rebuild the BST from remaining linked-list records.
        bst.clear();
        rebuildBSTFromKnownStudents();

        hashTable.remove(id);
        actionStack.push("Deleted student " + id);
        System.out.println("Student deleted successfully.");
    }

    private static void rebuildBSTFromKnownStudents() {
        // StudentLinkedList does not expose internal nodes.
        // This simple project rebuilds the BST by using the current
        // hash table's searchable entries through the helper method below.
        // No action is required here because the BST is rebuilt from
        // currently available students in the main data structure.
        //
        // To keep the linked list encapsulated, we rebuild from a temporary
        // list supplied by StudentLinkedList in display/search operations.
        // The practical delete operation is therefore completed in the
        // linked list and hash table; the BST can be refreshed by restarting.
        //
        // For immediate consistency, the BST class also supports deletion
        // in this submission.
        //
        // This method is intentionally replaced below by rebuildBST().
        rebuildBST();
    }

    private static void rebuildBST() {
        bst.clear();
        Student[] students = studentList.toArray();
        for (Student student : students) {
            bst.insert(student);
        }
    }

    private static void addServiceRequest() {
        System.out.println("\n--- Add Service Request ---");
        String id = readNonEmpty("Student ID: ");

        if (studentList.find(id) == null) {
            System.out.println("Student ID not found. Add the student first.");
            return;
        }

        String request = readNonEmpty("Request description: ");
        serviceQueue.enqueue("Student " + id + ": " + request);
        actionStack.push("Added service request for " + id);
        System.out.println("Request added to queue successfully.");
        serviceQueue.display();
    }

    private static void processServiceRequest() {
        System.out.println("\n--- Process Next Service Request ---");
        String request = serviceQueue.dequeue();

        if (request == null) {
            System.out.println("Queue is empty. No request to process.");
            return;
        }

        System.out.println("Processing: " + request);
        actionStack.push("Processed service request: " + request);
    }

    private static void searchStudentHash() {
        System.out.println("\n--- Search Student using Hashing ---");
        String id = readNonEmpty("Enter Student ID: ");
        Student student = hashTable.get(id);

        if (student == null) {
            System.out.println("Student not found in hash table.");
        } else {
            System.out.println("Student found:");
            System.out.println(student);
        }
    }

    private static void addCampusLocation() {
        System.out.println("\n--- Add Campus Location ---");
        String location = readNonEmpty("Location name: ");

        if (campusGraph.addLocation(location)) {
            actionStack.push("Added campus location " + location);
            System.out.println("Campus location added successfully.");
        } else {
            System.out.println("Invalid or duplicate location.");
        }
    }

    private static void removeCampusLocation() {
        System.out.println("\n--- Remove Campus Location ---");
        String location = readNonEmpty("Location name: ");

        if (campusGraph.removeLocation(location)) {
            actionStack.push("Removed campus location " + location);
            System.out.println("Campus location removed successfully.");
        } else {
            System.out.println("Location not found.");
        }
    }

    private static void addCampusConnection() {
        System.out.println("\n--- Add Campus Connection/Road ---");
        String from = readNonEmpty("From location: ");
        String to = readNonEmpty("To location: ");

        if (!campusGraph.containsLocation(from) || !campusGraph.containsLocation(to)) {
            System.out.println("Both locations must exist before creating a connection.");
            return;
        }

        if (campusGraph.addConnection(from, to)) {
            actionStack.push("Added connection: " + from + " <-> " + to);
            System.out.println("Campus connection added successfully.");
        } else {
            System.out.println("Connection is invalid, duplicate, or connects a location to itself.");
        }
    }

    private static void removeCampusConnection() {
        System.out.println("\n--- Remove Campus Connection/Road ---");
        String from = readNonEmpty("From location: ");
        String to = readNonEmpty("To location: ");

        if (campusGraph.removeConnection(from, to)) {
            actionStack.push("Removed connection: " + from + " <-> " + to);
            System.out.println("Campus connection removed successfully.");
        } else {
            System.out.println("Connection not found.");
        }
    }

    private static void traverseCampus() {
        System.out.println("\n--- BFS Campus Traversal ---");
        String start = readNonEmpty("Starting location: ");
        campusGraph.bfs(start);
    }

    private static void seedCampus() {
        campusGraph.addLocation("Main Gate");
        campusGraph.addLocation("Library");
        campusGraph.addLocation("Cafeteria");
        campusGraph.addLocation("IT Building");
        campusGraph.addLocation("Administration");

        campusGraph.addConnection("Main Gate", "Library");
        campusGraph.addConnection("Library", "Cafeteria");
        campusGraph.addConnection("Library", "IT Building");
        campusGraph.addConnection("IT Building", "Administration");
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) return value;
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) return value;
            } catch (NumberFormatException ignored) {
                // handled below
            }

            System.out.println("Invalid input. Enter a number from " + min + " to " + max + ".");
        }
    }

    private static double readMarks() {
        while (true) {
            System.out.print("Marks (0-100): ");
            String input = scanner.nextLine().trim();

            try {
                double marks = Double.parseDouble(input);
                if (marks >= 0 && marks <= 100) return marks;
            } catch (NumberFormatException ignored) {
                // handled below
            }

            System.out.println("Invalid marks. Enter a number between 0 and 100.");
        }
    }

    private static void pause() {
        System.out.println("\nPress ENTER to continue...");
        scanner.nextLine();
    }
}
