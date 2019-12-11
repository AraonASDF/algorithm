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
        int i = pos;
        while (2 * i <= count) {
            int j = 2 * i;
            if (j + 1 <= count && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }

        arr[i] = temp;
    }

    private void shiftUp(int pos) {
        int temp = arr[pos];
        int i = pos;
        for (; i / 2 >= 1 && arr[i / 2] < temp; i /= 2) {
            arr[i] = arr[i / 2];
        }
        arr[i] = temp;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        // 堆中元素个数
        int n = 100;
        // 堆中元素取值范围[0, M)
        int m = 100;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * m);
        }
        MaxHeap maxHeap = new MaxHeap(arr);

        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.println(arr[i]);
        }
        // 确保arr数组是从大到小排列的
        for (int i = 1; i < n; i++) {
            assert arr[i - 1] >= arr[i];
        }
    }
}
