package insertionsort_basic;

public class InsertionSort {

	private InsertionSort() {
	}

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j;
			int current = arr[i];
			for (j = i; j > 0 && arr[j - 1] > current; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = current;
		}
	}

	public static void main(String[] args) {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		insertionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void sort(int[] arr, int l, int r) {
		for (int i = l + 1; i <= r; i++) {
			int j;
			int current = arr[i];
			for (j = i; j > l && arr[j - 1] > current; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = current;
		}

	}
}
