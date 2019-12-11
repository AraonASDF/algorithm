package sort.basic;

/**
 * @author yjx
 * @date 2019/12/10
 **/
public class ShellSort {

    public static void sort(int[] arr) {
        int gap = 1;
        while (gap < arr.length / 3) {
            gap = gap * 3 + 1;
        }

        while (gap >= 1) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                for (; j - gap >= 0 && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }

            gap /= 3;
        }
    }

}
