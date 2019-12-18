package queue;

/**
 * @author yjx
 * @date 2019/12/18
 **/
public class ArrayQueue<E> implements Queue<E> {

    private E[] data;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void add(E e) {
        if ((tail + 1) % data.length == head) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    private void resize(int capacity) {
        int sz = size();
        assert capacity >= sz;
        E[] temp = (E[]) new Object[capacity + 1];
        for (int i = 0; i < sz; i++) {
            temp[i] = data[(i + head) % data.length];
        }
        data = temp;
        head = 0;
        tail = sz;
    }

    @Override
    public E poll() {
        E ret = data[head];
        data[head] = null;
        head = (head + 1) % data.length;

        int sz = size();
        int capacity = getCapacity();
        if (sz == capacity / 4 && capacity / 2 >= 10) {
            resize(capacity / 2);
        }
        return ret;
    }

    @Override
    public E peek() {
        return data[head];
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public int size() {
        return tail >= head ? tail - head : data.length - head + tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayQueue [");
        for (int i = head; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if (i != (tail - 1) % data.length) {
                sb.append(",");
            }
        }
        sb.append("] ").append(String.format("size : %s, capacity : %s", size(), getCapacity()));
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 20;
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        for (int i = 0; i < n; i++) {
            queue.add(i);
            System.out.println(queue);
        }

        for (int i = 0; i < n; i++) {
            queue.poll();
            System.out.println(queue);
        }
    }
}
