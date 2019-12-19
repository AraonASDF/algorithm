package array;

/**
 * @author yjx
 * @date 2019/12/18
 **/
public class ArrayList<E> {

    private E[] data;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
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
        if (size == data.length) {
            resize(size * 2);
        }
//        for (int i = size - 1; i >= index; i--) {
//            data[i + 1] = data[i];
//        }
        //通过拷贝数组来实现更优的移位操作
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        checkIndex(index);
        E ret = data[index];
//        for (int i = index; i + 1 < size; i++) {
//            data[i] = data[i + 1];
//        }
        //通过拷贝数组来实现更优的移位操作
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 >= DEFAULT_CAPACITY) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void set(int index, E e) {
        checkIndex(index);
        data[index] = e;
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        System.arraycopy(data, 0, temp, 0, size);
        data = temp;
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
        sb.append("ArrayList [");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]").append(String.format(" size: %s, capacity: %s", size, data.length));
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 20;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.addLast(i);
            System.out.println(list);
        }

        for (int i = 0; i < n; i++) {
            list.remove((int) (Math.random() * (n - i - 1)));
            System.out.println(list);
        }
    }
}
