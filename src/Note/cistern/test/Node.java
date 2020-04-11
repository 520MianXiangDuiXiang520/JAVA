package Note.cistern.test;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node parent;

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
