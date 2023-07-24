package pl.javastart.task;

public class Node<T> {
    private T t;
    private Node<T> previousNode;
    private Node<T> nextNode;

    public Node(T t, Node<T> previousNode, Node<T> nextNode) {
        this.t = t;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    public Node<T> getPreviousNode() {
        return previousNode;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public T getT() {
        return t;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }
}
