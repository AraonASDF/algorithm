package mergeSort_pro;

public class MergeSortBU {

	private MergeSortBU() {
	}

	// 自底向上的归并
	public static <T extends Comparable<T>> void sort(T[] arr) {
		int len = arr.length;
		for (int size = 0; size < len; size *= 2) {
			for (int i = 0; i < len - size; i += size + size) {
				merge(arr, i, i + size - 1, i + 2 * size - 1);
			}
		}
	}

	private static <T extends Comparable<T>> void merge(T[] arr, int l, int mid, int r) {
		
	}
}
