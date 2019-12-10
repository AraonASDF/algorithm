package sort.practice;

import utils.Utils;

/**
 * @author yjx
 * @date 2019/12/10
 **/
public class InversionNum {

    public static int inversionNum(int[] arr) {
        int[] temp = new int[arr.length];
        int count = 0;
        for (int i = 1; i < arr.length; i *= 2) {
            for (int j = 0; j + i < arr.length; j += 2 * i) {
                count += merge(arr, temp, j, j + i - 1, min(j + 2 * i - 1, arr.length - 1));
            }
        }
        return count;
    }

    private static int merge(int[] arr, int[] temp, int l, int mid, int r) {
        int count = 0;
        int i = 0;
        int j = l;
        int k = mid + 1;
        while (j <= mid && k <= r) {
            if (arr[j] > arr[k]) {
                count += (mid - j + 1);
                temp[i++] = arr[k++];
            } else {
                temp[i++] = arr[j++];
            }
        }
        while (j <= mid) {
            temp[i++] = arr[j++];
        }
        while (k <= r) {
            temp[i++] = arr[k++];
        }
        System.arraycopy(temp, 0, arr, l, r - l + 1);
        return count;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }

}
