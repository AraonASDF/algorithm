package utils;

import java.lang.reflect.Method;

public class Utils {

	public static <T> void swap(T[] array, int i, int minIndex) {
		T temp = array[i];
		array[i] = array[minIndex];
		array[minIndex] = temp;
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static Integer[] generateRandomArray(int n, int l, int r) {
		Integer[] array = new Integer[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (r - l + 1) + l);
		}
		return array;
	}

	public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
		Integer[] arr = new Integer[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < swapTimes; i++) {
			int m = (int) (Math.random() * n);
			int l = (int) (Math.random() * n);
			Utils.swap(arr, m, l);
		}
		return arr;
	}

	public static <T extends Comparable<T>> void testSort(Class className, T[] arr) {
		try {
			Method selectionSort = className.getDeclaredMethod("sort", Comparable[].class);
			Object[] params = new Object[] { arr };
			long start = System.currentTimeMillis();
			selectionSort.invoke(null, params);
			long end = System.currentTimeMillis();
			assert isSorted(arr);
			System.out.println(className.getSimpleName() + ":" + (end - start) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printArray(Object[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].compareTo(arr[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}
}
