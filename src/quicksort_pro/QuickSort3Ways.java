package quicksort_pro;

import insertionsort_pro.InsertionSort;
import utils.Utils;

public class QuickSort3Ways {

	private QuickSort3Ways() {
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		quickSort(arr, 0, arr.length - 1);

	}

	private static <T extends Comparable<T>> void quickSort(T[] arr, int l, int r) {

		if (r - l <= 15) {
			InsertionSort.sort(arr, l, r);
			return;
		}

		Utils.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
		T v = arr[l];
		int i = l; // arr[l+1,i] < v
		int j = r;// arr(j,r] > v
		int k = l + 1;// arr[i+1,k) == v
		while (k <= j) {
			if (arr[k].compareTo(v) > 0) {
				Utils.swap(arr, k, j);
				j--;
			} else if (arr[k].compareTo(v) < 0) {
				Utils.swap(arr, i + 1, k);
				i++;
				k++;
			} else {
				k++;
			}
		}
		Utils.swap(arr, l, i);
		i--;

		quickSort(arr, l, i);
		quickSort(arr, j + 1, r);

	}

	public static void main(String[] args) {
		int n = 1000000;
		Integer[] arr = Utils.generateRandomArray(n, 0, n);
		Utils.testSort(QuickSort3Ways.class, arr);
	}
}
