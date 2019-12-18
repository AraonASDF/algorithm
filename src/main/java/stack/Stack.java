package stack;

/**
 * @author yjx
 * @date 2019/12/18
 **/
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    boolean isEmpty();

    int size();
}
