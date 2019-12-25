package queue;

/**
 * @author yjx
 * @date 2019/12/20
 **/
public class LinkedListQueue<E> implements Queue<E> {

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E poll() {
        if (head == null) {
            return null;
        }
        Node ret = head;
        head = head.next;
        ret.next = null;
        size--;
        if (head == null) {
            tail = null;
        }
        return ret.value;
    }

    @Override
    public E peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
