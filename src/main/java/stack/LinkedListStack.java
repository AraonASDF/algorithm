package stack;

import linkedlist.LinkedList;

/**
 * @author yjx
 * @date 2019/12/20
 **/
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list = new LinkedList<>();

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
