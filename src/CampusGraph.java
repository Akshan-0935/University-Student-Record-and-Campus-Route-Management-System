import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CampusGraph {
    private final Map<String, List<String>> adjacencyList = new HashMap<>();

    public boolean addLocation(String location) {
        String key = normalize(location);
        if (key.isEmpty() || adjacencyList.containsKey(key)) return false;
        adjacencyList.put(key, new ArrayList<>());
        return true;
    }

    public boolean removeLocation(String location) {
        String key = normalize(location);
        if (!adjacencyList.containsKey(key)) return false;

        adjacencyList.remove(key);
        for (List<String> neighbours : adjacencyList.values()) {
            neighbours.remove(key);
        }
        return true;
    }

    public boolean addConnection(String from, String to) {
        String a = normalize(from);
        String b = normalize(to);

        if (a.equals(b) || !adjacencyList.containsKey(a) || !adjacencyList.containsKey(b)) {
            return false;
        }

        if (adjacencyList.get(a).contains(b)) return false;

        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a); // undirected campus road
        return true;
    }

    public boolean removeConnection(String from, String to) {
        String a = normalize(from);
        String b = normalize(to);

        if (!adjacencyList.containsKey(a) || !adjacencyList.containsKey(b)) return false;

        boolean removedA = adjacencyList.get(a).remove(b);
        boolean removedB = adjacencyList.get(b).remove(a);
        return removedA || removedB;
    }

    public void displayConnections() {
        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations found.");
            return;
        }

        System.out.println("\n--- Campus Adjacency List ---");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " +
                    (entry.getValue().isEmpty() ? "No connections" : String.join(", ", entry.getValue())));
        }
    }

    public void bfs(String start) {
        String source = normalize(start);
        if (!adjacencyList.containsKey(source)) {
            System.out.println("Location not found.");
            return;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(source);
        visited.add(source);

        System.out.println("\nBFS Traversal:");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current);
            if (!queue.isEmpty()) System.out.print(" -> ");

            for (String neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }
        System.out.println();
    }

    private String normalize(String value) {
        return value == null ? "" : value.trim();
    }

    public boolean containsLocation(String location) {
        return adjacencyList.containsKey(normalize(location));
    }
}
