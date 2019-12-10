package sort.advanced;

import utils.Utils;

import java.util.Random;

/**
 * @author yjx
 * @date 2019/12/9
 **/
public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static int partition(int[] arr, int l, int r) {
        //随机算法 视情况使用
        int pos = new Random().nextInt(r - l + 1) + l;
        Utils.swap(arr, l, pos);

        int temp = arr[l];
        while (true) {
            while (l < r && arr[r] >= temp) {
                r--;
            }
            if (l == r) {
                break;
            }
            arr[l++] = arr[r];
            while (l < r && arr[l] <= temp) {
                l++;
            }
            if (l == r) {
                break;
            }
            arr[r--] = arr[l];
        }
        arr[l] = temp;
        return l;
    }

}
