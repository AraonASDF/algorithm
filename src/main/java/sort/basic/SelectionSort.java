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
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (i != index) {
                Utils.swap(arr, i, index);
            }
        }
    }

}
