package linkedlist;

/**
 * @author yjx
 * @date 2019/12/19
 **/
public class LinkedList2<E> {

    private Node dummyHead;
    private int size;

    public LinkedList2() {
        dummyHead = new Node(null);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("invalid index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        checkIndex(index);
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node ret = prev.next;
        prev.next = ret.next;
        ret.next = null;
        size--;
        return ret.value;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void set(int index, E e) {
        checkIndex(index);
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.value = e;
    }

    public E get(int index) {
        checkIndex(index);
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.value.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.value.equals(e)) {
                Node cur = prev.next;
                prev.next = cur.next;
                size--;
                cur.next = null;
            } else {
                prev = prev.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList [");
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.value);
            cur = cur.next;
            if (cur != null) {
                sb.append(" -> ");
            }
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

}
