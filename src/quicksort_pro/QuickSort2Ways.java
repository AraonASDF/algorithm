package quicksort_pro;

import insertionsort_pro.InsertionSort;
import utils.Utils;

public class QuickSort2Ways {

	private QuickSort2Ways() {
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static <T extends Comparable<T>> void quickSort(T[] arr, int l, int r) {

		if (r - l <= 15) {
			InsertionSort.sort(arr, l, r);
			return;
		}
		int p = partition(arr, l, r);
		quickSort(arr, l, p - 1);
		quickSort(arr, p + 1, r);
	}

	private static <T extends Comparable<T>> int partition(T[] arr, int l, int r) {
		Utils.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
		T v = arr[l];
		int i = l + 1;// arr[l+1,i) <=v
		int j = r; // arr(j,r]>=v
		while (true) {
			while (i <= r && arr[i].compareTo(v) < 0) {
				i++;
			}
			while (j >= l + 1 && arr[j].compareTo(v) > 0) {
				j--;
			}
			if (i > j) {
				break;
			}
			Utils.swap(arr, i, j);
			i++;
			j--;
		}
		Utils.swap(arr, l, j);
		return j;
	}

	public static void main(String[] args) {
		int n = 1000000;
		Integer[] arr = Utils.generateRandomArray(n, 0, n);
		Utils.testSort(QuickSort2Ways.class, arr);
	}

}
