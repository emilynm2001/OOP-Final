// Node class to store a key of type String and
// a value that is also of type String.
public class Node {
    // Attributes
    private String key;
    private String value;

    // Constructor for a node.
    // Call setter to assign next.
    public Node(String newKey, String newValue) {
        this.key = newKey;
        this.value = newValue;
    }

    // Getter for key within the node.
    public String getKey() {
        return this.key;
    }

    // Getter for value within the node.
    public String getValue() {
        return this.value;
    }
}