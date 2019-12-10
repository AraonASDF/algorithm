package sort.advanced;

import utils.Utils;

import java.util.Random;

/**
 * @author yjx
 * @date 2019/12/10
 **/
public class QuickSort2 {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int[] p = partition(arr, l, r);
        sort(arr, l, p[0]);
        sort(arr, p[1], r);
    }

    private static int[] partition(int[] arr, int l, int r) {
        //随机算法 视情况使用
        int p = new Random().nextInt(r - l + 1) + l;
        Utils.swap(arr, l, p);

        int temp = arr[l];
        int i = l + 1;
        while (i <= r) {
            if (arr[i] < temp) {
                Utils.swap(arr, i++, l++);
            } else if (arr[i] > temp) {
                Utils.swap(arr, i, r--);
            } else {
                i++;
            }
        }
        return new int[]{l - 1, r + 1};
    }

}
