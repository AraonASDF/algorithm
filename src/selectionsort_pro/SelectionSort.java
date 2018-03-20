package selectionsort_pro;

import utils.Utils;

public class SelectionSort {
	private SelectionSort() {
	}

	public static <T extends Comparable<T>> void sort(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[minIndex]) < 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				Utils.swap(array, i, minIndex);
			}
		}
	}

	public static void main(String[] args) {
		int n = 100000;
		Integer[] arr = Utils.generateRandomArray(n, 0, n);
		Utils.testSort(SelectionSort.class, arr);
	}
}
