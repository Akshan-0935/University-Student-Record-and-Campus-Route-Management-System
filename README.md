# CIT300 - University Student Record and Campus Route Management System

## Graded Practical Assignment 1 - Week 10

### Project description
A Java console application demonstrating:
- Linked List
- Stack
- Queue
- Binary Search Tree (BST)
- Hashing
- Graph using an adjacency list
- BFS traversal
- Input validation and error handling

## Requirements implemented

1. Student records: Student ID, Name, Programme, Marks.
2. Linked list for student record storage and management.
3. Stack for recent actions/history.
4. Queue for student service requests.
5. BST for student ID organization and searching.
6. Hash table for efficient student ID searching.
7. Campus graph with locations as vertices and roads as edges.
8. Graph represented using an adjacency list.
9. Add/remove campus locations and connections.
10. Display campus connections.
11. BFS graph traversal.
12. Add, update, delete, search, and display student records.
13. Menu-driven console interface.
14. Validation for empty input, invalid menu values, invalid marks, duplicate IDs/locations, missing records, and unavailable connections.

## Group Member Information

Replace the following placeholders with the actual group details before submission.

| Member | Student ID | Responsibility | Individual Contribution |
|---|---|---|---|
| Member 1 | ENTER_ID | Linked List / Student Records | Implemented student record storage and linked-list operations |
| Member 2 | ENTER_ID | Stack / Queue | Implemented action history and student service request management |
| Member 3 | ENTER_ID | BST / Hashing | Implemented student ID organization and efficient search structures |
| Member 4 | ENTER_ID | Graph / BFS | Implemented campus connections, graph operations, and BFS traversal |

If the group has fewer members, combine the responsibilities while keeping every required component.

## How to run

### Option 1 - VS Code
1. Install Java JDK 17 or later.
2. Open this project folder in VS Code.
3. Open a terminal in the project folder.
4. Compile:
   `javac -d out src/*.java`
5. Run:
   `java -cp out Main`

### Option 2 - Command Prompt
From the project folder:

```text
javac -d out src\*.java
java -cp out Main
```

## Recommended demonstration order

1. Add 3-5 student records.
2. Display all students using the linked list.
3. Update one student.
4. Search a student using hashing.
5. Display students using BST.
6. Delete one student.
7. Add two or three service requests.
8. Display/process the queue.
9. Display recent actions using the stack.
10. Display campus connections.
11. Add a campus location.
12. Add a connection.
13. Remove a connection/location.
14. Run BFS from Main Gate.
15. Demonstrate invalid input and duplicate handling.
16. Exit.

## Important submission items

The assignment requires the complete project, README, group-member details, a merged demonstration video under 15 minutes, and evidence of collaboration where applicable.

Before submission:
- Replace all group-member placeholders.
- Test every menu option.
- Capture GitHub commits/branches/pull requests as required by your group workflow.
- Record the demonstration video according to the assignment instructions.
- Do not submit generated `out` files if your lecturer expects source-only code; compile locally to test.
