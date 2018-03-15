package utils;

import java.lang.reflect.Method;

public class Utils {

	public static <T> void swap(T[] array, int i, int minIndex) {
		T temp = array[i];
		array[i] = array[minIndex];
		array[minIndex] = temp;
	}

	public static Integer[] generateRandomArray(int n, int l, int r) {
		Integer[] array = new Integer[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (r - l + 1) + l);
		}
		return array;
	}

	public static <T extends Comparable<T>> void testSort(String className, T[] arr) {
		try {
			Class<?> sortName = Class.forName(className);
			Method selectionSort = sortName.getDeclaredMethod("sort", Comparable[].class);
			long start = System.currentTimeMillis();
			Object[] params = new Object[] { arr };
			selectionSort.invoke(null, params);
			long end = System.currentTimeMillis();
			assert isSorted(arr);
			System.out.println(sortName.getSimpleName() + ":" + (end - start) + "ms");
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
