package sort.advanced;

/**
 * @author yjx
 * @date 2019/12/9
 **/
public class MergeSortBU {

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 1; i < arr.length; i *= 2) {
            for (int j = 0; j + i < arr.length; j += 2 * i) {
                MergeSort.merge(arr, temp, j, j + i - 1, min(j + 2 * i - 1, arr.length - 1));
            }
        }
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }

}
