package pl.javastart.task;

// Uzupełnij klasę. Możesz ją dowolnie modyfikować.
// Celem jest, żeby przechodziły testy w src/test/java/[...]/CustomListTest
public class CustomList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int nodesAmount = 0;

    public T get(int index) {
        if (index >= nodesAmount || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> finalNode = getNodeAtIndex(index);
        return finalNode.getT();
    }

    public void add(T element) {
        if (nodesAmount == 0) {
            firstNode = new Node<>(element, null, null);
            lastNode = firstNode;
        } else if (nodesAmount == 1) {
            lastNode = new Node<>(element, firstNode, null);
            firstNode.setNextNode(lastNode);
        } else {
            Node<T> newNode = new Node<>(element, lastNode, null);
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
        nodesAmount++;
    }

    public void add(int index, T element) {
        if (index > nodesAmount || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0) {
            Node<T> node = firstNode;
            Node<T> newNode = new Node<>(element, null, node);
            node.setPreviousNode(newNode);
            firstNode = newNode;
            nodesAmount++;
        } else if (index == nodesAmount) {
            Node<T> node = lastNode;
            Node<T> newNode = new Node<>(element, node, null);
            node.setNextNode(newNode);
            lastNode = newNode;
            nodesAmount++;
        } else {
            Node<T> node = getNodeAtIndex(index);
            Node<T> previousNode = node.getPreviousNode();
            Node<T> newNode = new Node<>(element, previousNode, node);
            previousNode.setNextNode(newNode);
            node.setPreviousNode(newNode);
            nodesAmount++;
        }
    }

    public int size() {
        return nodesAmount;
    }

    public void remove(int index) {
        if (index >= nodesAmount || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (nodesAmount == 1) {
            firstNode = null;
            lastNode = null;
        } else if (index == 0) {
            Node<T> nextNode = firstNode.getNextNode();
            nextNode.setPreviousNode(null);
            firstNode = nextNode;
        } else if (index == nodesAmount - 1) {
            Node<T> previousNode = lastNode.getPreviousNode();
            previousNode.setNextNode(null);
            lastNode = previousNode;
        } else {
            Node<T> node = getNodeAtIndex(index);
            Node<T> previousNode = node.getPreviousNode();
            Node<T> nextNode = node.getNextNode();
            previousNode.setNextNode(nextNode);
            nextNode.setPreviousNode(previousNode);
        }
        nodesAmount--;
    }

    private Node<T> getNodeAtIndex(int index) {
        Node<T> node;
        if (nodesAmount / 2 > index) {
            node = firstNode;
            for (int i = 1; i <= index; i++) {
                node = node.getNextNode();
            }
        } else {
            node = lastNode;
            for (int i = nodesAmount - 1; i > index; i--) {
                node = node.getPreviousNode();
            }
        }
        return node;
    }

    @Override
    public String toString() {
        if (nodesAmount == 0) {
            return "[]";
        }
        Node<T> node = firstNode;
        StringBuilder builder = new StringBuilder("[");
        builder.append(node.getT()).append(", ");
        for (int i = 1; i < nodesAmount; i++) {
            node = node.getNextNode();
            builder.append(node.getT());
            if (i + 1 < nodesAmount) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

}
