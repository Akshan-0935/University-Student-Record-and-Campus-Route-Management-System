# University Student Record and Campus Route Management System

**Course:** CIT300 - Graded Practical Assignment 1 (Week 10)

A menu-driven Java console application that manages student records and campus routes. It demonstrates the main data structures covered in the course.

## Data structures used

| Data structure | Purpose in the system |
|---|---|
| Linked List | Stores and manages student records |
| Stack | Keeps the history of recent actions |
| Queue | Manages student service requests |
| Binary Search Tree (BST) | Organizes and searches student IDs |
| Hash Table | Fast student ID lookup |
| Graph (adjacency list) | Represents campus locations (vertices) and roads (edges) |
| BFS | Traverses the campus graph from a chosen location |

## Features

1. Add, update, delete, search and display student records (Student ID, Name, Programme, Marks).
2. Student records stored in a linked list.
3. Recent actions stored in a stack.
4. Student service requests handled by a queue.
5. Student IDs organized in a BST.
6. Fast student search using a hash table.
7. Campus graph with locations as vertices and roads as edges (adjacency list).
8. Add and remove campus locations and connections.
9. Display campus connections.
10. BFS traversal of the campus graph.
11. Menu-driven console interface.
12. Input validation and error handling for:
    - empty input
    - invalid menu choices
    - invalid marks
    - duplicate student IDs and duplicate locations
    - missing records
    - unavailable connections

## Group members and contributions

| Member | Name | Student ID | GitHub | Responsibility | Files |
|---|---|---|---|---|---|
| Member 1 | A.M.AKSHAN | 23DA2-0935 | Akshan-0935 | Student records and Linked List | `Student.java`, `StudentLinkedList.java` |
| Member 2 | M.K.F.MUNSHIFA | 23DA2-0553 | munshifakamal07 | Stack and Queue | `ActionStack.java`, `ServiceQueue.java` |
| Member 3 | M.A.F.ASFA | 23DA2-0554 | Asfa Fashion | BST and Hashing | `BST.java`, `StudentHashTable.java` |
| Member 4 | W.M.NASHMAN | 23DA2-0649 | mohomednashman-prog | Graph, BFS and Main menu | `CampusGraph.java`, `Main.java` |

## Project structure

```text
.
├── README.md
├── .gitignore
└── src
    ├── Main.java
    ├── Student.java
    ├── StudentLinkedList.java
    ├── ActionStack.java
    ├── ServiceQueue.java
    ├── BST.java
    ├── StudentHashTable.java
    └── CampusGraph.java
```

## How to run

**Requirement:** Java JDK 17 or later.

From the project folder, compile:

```text
javac -d out src/*.java
```

Then run:

```text
java -cp out Main
```

On Windows Command Prompt, use `src\*.java` instead of `src/*.java`.

## Team collaboration (GitHub workflow)

Each member worked on their own branch and merged into `main` through a pull request:

| Branch | Member | Merged by pull request |
|---|---|---|
| `member-1-branch` | Member 1 | Yes |
| `member-2-branch` | Member 2 | Yes |
| `member-3-branch` | Member 3 | Yes |
| `member-4-branch` | Member 4 | Yes |

The commit history and pull requests in this repository show each member's individual contribution.

