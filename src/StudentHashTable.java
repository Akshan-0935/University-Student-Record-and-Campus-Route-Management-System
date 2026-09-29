public class StudentHashTable {
    private static class Entry {
        String key;
        Student value;
        Entry next;

        Entry(String key, Student value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private final Entry[] table;
    private int size;

    public StudentHashTable(int capacity) {
        table = new Entry[capacity];
    }

    private int index(String key) {
        return (key.toUpperCase().hashCode() & 0x7fffffff) % table.length;
    }

    public boolean put(Student student) {
        String key = student.getStudentId();
        int index = index(key);

        Entry current = table[index];
        while (current != null) {
            if (current.key.equalsIgnoreCase(key)) return false;
            current = current.next;
        }

        table[index] = new Entry(key, student, table[index]);
        size++;
        return true;
    }

    public Student get(String key) {
        Entry current = table[index(key)];
        while (current != null) {
            if (current.key.equalsIgnoreCase(key)) return current.value;
            current = current.next;
        }
        return null;
    }

    public Student remove(String key) {
        int index = index(key);
        Entry current = table[index];
        Entry previous = null;

        while (current != null) {
            if (current.key.equalsIgnoreCase(key)) {
                if (previous == null) table[index] = current.next;
                else previous.next = current.next;
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public int size() { return size; }
}
