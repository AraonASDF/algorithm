package utils;

import insertionsort_pro.InsertionSort;
import mergeSort_pro.MergeSort;
import quicksort_pro.QuickSort;
import quicksort_pro.QuickSort2Ways;
import quicksort_pro.QuickSort3Ways;

public class Test {

	public static void main(String[] args) {
		int n = 1000000;
		System.out.println("****test for ordinary array, size = " + n);
		Integer[] arr1 = Utils.generateRandomArray(n, 0, n);
		Integer[] arr2 = arr1.clone();
		Integer[] arr3 = arr1.clone();
		Integer[] arr4 = arr1.clone();
		Integer[] arr5 = arr1.clone();
//		Utils.testSort(InsertionSort.class, arr1);
		Utils.testSort(MergeSort.class, arr2);
		Utils.testSort(QuickSort.class, arr3);
		Utils.testSort(QuickSort2Ways.class, arr4);
		Utils.testSort(QuickSort3Ways.class, arr5);

		System.out.println("\n****test for nearly ordered array, size = " + n);
		arr1 = Utils.generateNearlyOrderedArray(n, 10);
		arr2 = arr1.clone();
		arr3 = arr1.clone();
		arr4 = arr1.clone();
		arr5 = arr1.clone();
		Utils.testSort(InsertionSort.class, arr1);
		Utils.testSort(MergeSort.class, arr2);
		Utils.testSort(QuickSort.class, arr3);
		Utils.testSort(QuickSort2Ways.class, arr4);
		Utils.testSort(QuickSort3Ways.class, arr5);

		System.out.println("\n****test for completely ordered array, size = " + n);
		arr1 = Utils.generateNearlyOrderedArray(n, 0);
		arr2 = arr1.clone();
		arr3 = arr1.clone();
		arr4 = arr1.clone();
		arr5 = arr1.clone();
		Utils.testSort(InsertionSort.class, arr1);
		Utils.testSort(MergeSort.class, arr2);
		Utils.testSort(QuickSort.class, arr3);
		Utils.testSort(QuickSort2Ways.class, arr4);
		Utils.testSort(QuickSort3Ways.class, arr5);

		System.out.println("\n****test for repeated array, size = " + n);
		arr1 = Utils.generateRandomArray(n, 0, 100);
		arr2 = arr1.clone();
		arr3 = arr1.clone();
		arr4 = arr1.clone();
		arr5 = arr1.clone();
//		Utils.testSort(InsertionSort.class, arr1);
		Utils.testSort(MergeSort.class, arr2);
		Utils.testSort(QuickSort.class, arr3);
		Utils.testSort(QuickSort2Ways.class, arr4);
		Utils.testSort(QuickSort3Ways.class, arr5);
	}
}
