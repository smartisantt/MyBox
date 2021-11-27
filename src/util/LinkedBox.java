package util;

public class LinkedBox implements Box {

    private Node first;
    private Node last;
    private int size = 0;

    private void linkLast(int element) {
        Node l = last;
        Node newNode = new Node(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new BoxIndexOutOfBoundsException("Index:" + index + "Size:" + size);
        }
    }

    private Node node(int index) {
        Node targetNode;
        if (index < (size >> 1)) {
            // 从前往后找
            targetNode = first;
            for (int i = 0; i < index; i++) {
                targetNode = targetNode.next;
            }
        } else {
            targetNode = last;
            for (int i = size - 1; i > index; i--) {
                targetNode = targetNode.prev;
            }
        }
        return targetNode;
    }

    private int unlink(Node targetNode) {
        int oldValue = targetNode.item;
        Node pre = targetNode.prev;
        Node next = targetNode.next;
        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
            targetNode.prev = null;
        }
        if (next == null) {
            last = pre;
        } else {
            next.prev = pre;
            targetNode.next = null;
        }
        size--;
        return oldValue;
    }

    public boolean add(int element) {
        this.linkLast(element);
        return true;
    }

    public int get(int index) {
        this.checkIndex(index);
        Node targetNode = this.node(index);
        return targetNode.item;
    }

    public int remove(int index) {
        this.checkIndex(index);
        Node targetNode = this.node(index);
        int oldValue = this.unlink(targetNode);
        return oldValue;
    }

    public int size() {
        return size;
    }
}
