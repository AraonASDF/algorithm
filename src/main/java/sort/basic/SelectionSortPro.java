package sort.basic;

import utils.Utils;

/**
 * @author yjx
 * @date 2019/12/10
 **/
public class SelectionSortPro {

    public static void sort(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int min = i;
            int max = j;
            if (arr[min] > arr[max]) {
                Utils.swap(arr, min, max);
            }
            for (int k = i + 1; k < j; k++) {
                if (arr[k] < arr[min]) {
                    min = k;
                } else if (arr[k] > arr[max]) {
                    max = k;
                }
            }
            Utils.swap(arr, i++, min);
            Utils.swap(arr, j--, max);
        }
    }

}
