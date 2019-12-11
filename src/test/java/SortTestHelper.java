import org.junit.Test;
import sort.advanced.MergeSort;
import sort.advanced.MergeSortBU;
import sort.advanced.QuickSort;
import sort.advanced.QuickSort2;
import sort.basic.BubbleSort;
import sort.basic.InsertionSort;
import sort.basic.SelectionSort;
import sort.basic.ShellSort;
import utils.Utils;

import java.util.Arrays;

/**
 * @author yjx
 * @date 2019/12/10
 **/

public class SortTestHelper {

    @Test
    public void testRandomArray() {
        int n = 1000000;
        int[] arr = Utils.generateRandomIntArray(n, 0, n);
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        int[] arr4 = Arrays.copyOf(arr, arr.length);

        Utils.testSort(QuickSort.class, arr);
        Utils.testSort(QuickSort2.class, arr1);
        Utils.testSort(MergeSort.class, arr2);
        Utils.testSort(MergeSortBU.class, arr3);
        Utils.testSort(ShellSort.class, arr4);
    }

    @Test
    public void testNearlyOrderArray() {
        int n = 10000;
        int[] arr = Utils.generateNearlyOrderedIntArray(n, 100);
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);

        Utils.testSort(QuickSort.class, arr);
        Utils.testSort(QuickSort2.class, arr);
        Utils.testSort(MergeSort.class, arr1);
        Utils.testSort(MergeSortBU.class, arr2);

    }


}
