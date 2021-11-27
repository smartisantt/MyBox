package util;

public class Node {
    public Node prev;
    public int item;
    public Node next;

    public Node(Node pre, int item, Node next) {
        this.prev = pre;
        this.item = item;
        this.next = next;
    }
}
