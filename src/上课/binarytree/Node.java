package 上课.binarytree;

public class Node<T> {
    private Node<T> leftChild;
    private T value;
    private Node<T> rightChild;

    public Node(){}

    public Node (Node<T> leftChild, T value, Node<T> rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String toString() {
        return this.value.toString();
    }
}
