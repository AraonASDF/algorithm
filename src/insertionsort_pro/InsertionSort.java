package insertionsort_pro;

import utils.Utils;

public class InsertionSort {

	private InsertionSort() {
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			T current = arr[i];
			int j;
			for (j = i; j > 0 && arr[j - 1].compareTo(current) > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = current;
		}
	}

	public static void main(String[] args) {
		int n = 100;
		Integer[] arr = Utils.generateRandomArray(n, 0, n);
		Utils.testSort("insertionsort_pro.InsertionSort", arr);
		Utils.printArray(arr);
	}

}
