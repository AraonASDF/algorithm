package sort.practice;

import sort.advanced.QuickSort;

/**
 * @author yjx
 * @date 2019/12/10
 **/
public class Rank {

    /**
     * 从arr中查询第pos大的元素
     *
     * @param arr 查询数组
     * @param pos 排名
     * @return pos位置的元素
     */
    public static int rank(int[] arr, int pos) {
        assert pos < arr.length - 1 && pos >= 0;
        return rank(arr, 0, arr.length - 1, pos);
    }

    private static int rank(int[] arr, int l, int r, int pos) {
        if (l == r) {
            return arr[l];
        }
        int p = QuickSort.partition(arr, l, r);
        if (p == pos) {
            return arr[p];
        } else if (p > pos) {
            return rank(arr, l, p - 1, pos);
        } else {
            return rank(arr, p + 1, r, pos);
        }
    }

}
