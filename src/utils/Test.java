package utils;

import bubblesort_pro.BubbleSort;
import insertionsort_pro.InsertionSort;
import selectionsort_pro.SelectionSort;

public class Test {

	public static void main(String[] args) {
		int n = 50000;
		System.out.println("test for ordinary array, size = " + n);
		Integer[] arr1 = Utils.generateRandomArray(n, 0, n);
		Integer[] arr2 = arr1.clone();
		Integer[] arr3 = arr1.clone();
		Utils.testSort(SelectionSort.class, arr1);
		Utils.testSort(InsertionSort.class, arr2);
		Utils.testSort(BubbleSort.class, arr3);

		System.out.println("test for nearly ordered array, size = " + n);
		arr1 = Utils.generateNearlyOrderedArray(n, 100);
		arr2 = arr1.clone();
		arr3 = arr1.clone();
		Utils.testSort(SelectionSort.class, arr1);
		Utils.testSort(InsertionSort.class, arr2);
		Utils.testSort(BubbleSort.class, arr3);

		System.out.println("test for completely ordered array, size = " + n);
		arr1 = Utils.generateNearlyOrderedArray(n, 0);
		arr2 = arr1.clone();
		arr3 = arr1.clone();
		Utils.testSort(SelectionSort.class, arr1);
		Utils.testSort(InsertionSort.class, arr2);
		Utils.testSort(BubbleSort.class, arr3);
	}
}
