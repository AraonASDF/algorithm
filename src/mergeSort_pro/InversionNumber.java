package mergeSort_pro;

import java.util.Arrays;

public class InversionNumber {
	private InversionNumber() {
	}

	// count the sum of inversion numbers in the array using mergeSort
	public static <T extends Comparable<T>> int CountInversionNumber(T[] arr) {

		return mergeSort(arr, 0, arr.length - 1);

	}

	private static <T extends Comparable<T>> int mergeSort(T[] arr, int l, int r) {
		if (l >= r) {
			return 0;
		}
		int count = 0;
		int mid = l + (r - l) / 2;
		count += mergeSort(arr, l, mid);
		count += mergeSort(arr, mid + 1, r);
		if (arr[mid].compareTo(arr[mid + 1]) > 0) {
			count += merge(arr, l, mid, r);
		}
		return count;
	}

	private static int merge(Comparable[] arr, int l, int mid, int r) {
		int count = 0;
		Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
		int j = 0;// aux[0,mid-l]
		int k = mid + 1 - l;// aux[mid+1-l,r-l]
		for (int i = l; i <= r; i++) {

			if (j > mid - l) {
				arr[i] = aux[k];
				k++;
			} else if (k > r - l) {
				arr[i] = aux[j];
				j++;
			} else if (aux[j].compareTo(aux[k]) < 0) {
				arr[i] = aux[j];
				j++;
			} else {
				arr[i] = aux[k];
				count += mid - l - j + 1;
				k++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Integer[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.println(CountInversionNumber(arr));
	}
}
