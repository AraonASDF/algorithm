package search;

/**
 * @author yjx
 * @date 2019/12/11
 **/
public class BinarySearch {

    public static int search(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
