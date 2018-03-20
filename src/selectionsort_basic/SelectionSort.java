package selectionsort_basic;

public class SelectionSort {
	private SelectionSort() {
	}

	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(array, i, minIndex);
			}
		}
	}

	private static void swap(int[] array, int i, int minIndex) {
		int temp = array[i];
		array[i] = array[minIndex];
		array[minIndex] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		selectionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
