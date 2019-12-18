package stack;

import array.ArrayList;

/**
 * @author yjx
 * @date 2019/12/18
 **/
public class ArrayStack<E> implements Stack<E> {

    private ArrayList<E> arrayList;

    public ArrayStack(int capacity) {
        arrayList = new ArrayList<>(capacity);
    }

    @Override
    public void push(E e) {
        arrayList.addLast(e);
    }

    @Override
    public E pop() {
        return arrayList.removeLast();
    }

    @Override
    public E peek() {
        return arrayList.getLast();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public int size() {
        return arrayList.size();
    }
}
