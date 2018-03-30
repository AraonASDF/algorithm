package binarysearch_basic;

public class BinarySearch {
	private BinarySearch() {
	}
	
	public static int search(int[] arr, int n) {
		return recursionSearch(arr, 0, arr.length - 1, n);
	}

	public static int recursionSearch(int[] arr, int l, int r, int n) {
		if (l > r) {
			return -1;
		}
		// 防止int溢出，改用减法
		int mid = l + (r - l) / 2;
		if (arr[mid] == n) {
			return mid;
		} else if (arr[mid] < n) {
			return recursionSearch(arr, mid + 1, r, n);
		} else {
			return recursionSearch(arr, l, mid - 1, n);
		}
	}

	public static int iterationSearch(int[] arr, int n) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			// 防止int溢出，改用减法
			int mid = l + (r - l) / 2;
			if (arr[mid] == n) {
				return mid;
			} else if (arr[mid] < n) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(search(arr, 9));
	}

}
