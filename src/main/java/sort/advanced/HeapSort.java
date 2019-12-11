package sort.advanced;

import utils.Utils;

/**
 * @author yjx
 * @date 2019/12/11
 **/
public class HeapSort {

    public static void sort(int[] arr) {
        int n = arr.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        for (int i = n; i > 0; ) {
            Utils.swap(arr, 0, i--);
            shiftDown(arr, i, 0);
        }
    }

    private static void shiftDown(int[] arr, int n, int pos) {
        int temp = arr[pos];
        int i = pos;
        while (i * 2 + 1 <= n) {
            int j = 2 * i + 1;
            if (j + 1 <= n && arr[j + 1] > arr[j]) {
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

}
