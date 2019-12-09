package sort.basic;

import utils.Utils;

/**
 * @author yjx
 * @date 2019/12/9
 **/
public class SelectionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i; j < arr.length && arr[j] < arr[index]; j++) {
                index = j;
            }
            if (i == index) {
                continue;
            }
            Utils.swap(arr, i, index);
        }
    }
}
