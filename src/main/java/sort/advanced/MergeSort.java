package sort.advanced;

/**
 * @author yjx
 * @date 2019/12/9
 **/
public class MergeSort {

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, temp, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] temp, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, temp, l, mid);
        sort(arr, temp, mid + 1, r);
        merge(arr, temp, l, mid, r);
    }

    static void merge(int[] arr, int[] temp, int l, int mid, int r) {
        int i = 0;
        int j = l;
        int k = mid + 1;
        while (j <= mid && k <= r) {
            temp[i++] = arr[j] <= arr[k] ? arr[j++] : arr[k++];
        }
        while (j <= mid) {
            temp[i++] = arr[j++];
        }
        while (k <= r) {
            temp[i++] = arr[k++];
        }
        System.arraycopy(temp, 0, arr, l, r - l + 1);
    }

}
