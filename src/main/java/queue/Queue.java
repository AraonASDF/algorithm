package queue;

/**
 * @author yjx
 * @date 2019/12/18
 **/
public interface Queue<E> {

    void add(E e);

    E poll();

    E peek();

    boolean isEmpty();

    int size();

}
