package bubblesort_pro;

import utils.Utils;

public class BubbleSort {
	private BubbleSort() {
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		int length = arr.length;
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 0; i < length - 1; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					Utils.swap(arr, i, i + 1);
					swapped = true;
				}
			}
			length--;
		} while (swapped);
	}

	public static void main(String[] args) {
		int n = 100000;
		Integer[] arr = Utils.generateRandomArray(n, 0, n);
		Utils.testSort(BubbleSort.class, arr);

	}

}
