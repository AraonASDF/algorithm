package heap;

/**
 * @author yjx
 * @date 2019/12/11
 **/
public class MaxHeap {

    private int[] arr;
    private int capacity;
    private int count;

    public MaxHeap(int capacity) {
        assert capacity > 0;
        this.arr = new int[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    public MaxHeap(int[] arr) {
        this.count = arr.length;
        this.capacity = arr.length;
        this.arr = new int[arr.length + 1];
        System.arraycopy(arr, 0, this.arr, 1, arr.length);
        for (int i = count / 2; i > 0; i--) {
            shiftDown(i);
        }
    }

    public void insert(int v) {
        if (++count == capacity) {
            capacity *= 2;
            int[] temp = new int[capacity];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
        }
        arr[count] = v;
        shiftUp(count);
    }

    public int extractMax() {
        assert count > 0;
        int max = arr[1];
        arr[1] = arr[count--];
        shiftDown(1);
        return max;
    }

    private void shiftDown(int pos) {
        int temp = arr[pos];
        while (2 * pos <= count) {
            int j = 2 * pos;
            if (j + 1 <= count && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[pos] = arr[j];
                pos = j;
            } else {
                break;
            }
        }
        arr[pos] = temp;
    }

    private void shiftUp(int pos) {
        int temp = arr[pos];
        for (; pos / 2 >= 1 && arr[pos / 2] < temp; pos /= 2) {
            arr[pos] = arr[pos / 2];
        }
        arr[pos] = temp;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

}
