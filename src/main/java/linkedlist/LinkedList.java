package linkedlist;

/**
 * @author yjx
 * @date 2019/12/19
 **/
public class LinkedList<E> {

    private Node head;
    private int size;

    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if (index == 0) {
            addFirst(e);
            return;
        }

        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public E removeFirst() {
        Node ret = head;
        head = head.next;
        ret.next = null;
        size--;
        return ret.value;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E remove(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node ret = prev.next;
        prev.next = ret.next;
        ret.next = null;
        size--;
        return ret.value;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("operate failed. Illegal index.");
        }
    }

    public E get(int index) {
        checkIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public void set(int index, E e) {
        checkIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.value = e;
    }

    public boolean contains(E e) {
        Node node = head;
        while (node != null) {
            if (node.value.equals(e)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList [");
        Node node = head;
        while (node != null) {
            sb.append(node.value);
            if (node.next != null) {
                sb.append(" -> ");
            }
            node = node.next;
        }
        sb.append("] size:").append(size);
        return sb.toString();
    }

    private class Node {
        private E value;
        private Node next;

        Node(E value) {
            this.value = value;
        }

        Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = 20;
        for (int i = 0; i < n; i++) {
            list.addLast(i);
            System.out.println(list);
        }

        list.addFirst(-1);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        for (int i = 0; i < n; i++) {
            list.removeLast();
            System.out.println(list);
        }
    }

}
