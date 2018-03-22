package mergesort_basic;

import java.util.Arrays;

public class MergeSort {
	private MergeSort() {
	}

	public static void sort(int[] arr) {
		mergesort(arr, 0, arr.length - 1);
	}

	private static void mergesort(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = (l + r) / 2;
		mergesort(arr, l, mid);
		mergesort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int[] aux = Arrays.copyOfRange(arr, l, r + 1);
		int m = 0;// aux[0,mid-l]
		int n = mid - l + 1;// aux[mid-l+1,r-l]
		for (int i = l; i <= r; i++) {
			if (m > mid - l) {
				arr[i] = aux[n];
				n++;
			} else if (n > r - l) {
				arr[i] = aux[m];
				m++;
			} else if (aux[m] < aux[n]) {
				arr[i] = aux[m];
				m++;
			} else {
				arr[i] = aux[n];
				n++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
