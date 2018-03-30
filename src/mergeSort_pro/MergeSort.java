package mergeSort_pro;

import java.util.Arrays;

import insertionsort_pro.InsertionSort;
import utils.Utils;

public class MergeSort {
	private MergeSort() {
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private static <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {
		if (r - l <= 15) {
			InsertionSort.sort(arr, l, r);
			return;
		}
		int mid = (l + r) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		// 当arr[mid]<arr[mid+1]时，数组已经有序不需要merge
		if (arr[mid].compareTo(arr[mid + 1]) > 0) {
			merge(arr, l, mid, r);
		}
	}

	private static void merge(Comparable[] arr, int l, int mid, int r) {
		Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
		int m = 0;// aux[0,mid-l]
		int n = mid - l + 1;// aux[mid-l+1,r-l]
		for (int i = l; i <= r; i++) {
			if (m > mid - l) {
				arr[i] = aux[n];
				n++;
			} else if (n > r - l) {
				arr[i] = aux[m];
				m++;
			} else if (aux[m].compareTo(aux[n]) < 0) {
				arr[i] = aux[m];
				m++;
			} else {
				arr[i] = aux[n];
				n++;
			}
		}
	}

	public static void main(String[] args) {
		int n = 1000000;
		Integer[] arr = Utils.generateRandomArray(n, 0, n);
		Utils.testSort(MergeSort.class, arr);
		arr = Utils.generateNearlyOrderedArray(n, 10);
		Utils.testSort(MergeSort.class, arr);
	}

}
