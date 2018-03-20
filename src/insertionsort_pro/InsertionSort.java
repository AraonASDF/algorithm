package insertionsort_pro;

import utils.Utils;

public class InsertionSort {

	private InsertionSort() {
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			T e = arr[i];
			int j;
			for (j = i; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
				arr[j] = arr[j - 1];
				// Utils.swap(arr, j, j - 1);
			}
			arr[j] = e;
		}
	}

	public static void main(String[] args) {
		int n = 100000;
		Integer[] arr = Utils.generateRandomArray(n, 0, n);
		Utils.testSort(InsertionSort.class, arr);
	}

	public static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
		for (int i = l + 1; i <= r; i++) {
			T e = arr[i];
			int j;
			for (j = i; j > l && arr[j - 1].compareTo(e) > 0; j--) {
				arr[j] = arr[j - 1];
				// Utils.swap(arr, j, j - 1);
			}
			arr[j] = e;
		}
	}

}
