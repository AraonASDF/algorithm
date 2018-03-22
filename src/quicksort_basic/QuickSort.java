package quicksort_basic;

public class QuickSort {

	private QuickSort() {
	}

	public static void sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}

		int p = partition(arr, l, r);
		quickSort(arr, l, p - 1);
		quickSort(arr, p + 1, r);
	}

	private static int partition(int[] arr, int l, int r) {
		int v = arr[l];
		int j = l;// arr[l+1,j]
		for (int i = l + 1; i <= r; i++) {
			if (arr[i] < v) {
				swap(arr, j + 1, i);
				j++;
			}
		}
		swap(arr, l, j);
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
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
