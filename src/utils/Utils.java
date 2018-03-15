package utils;

public class Utils {

	public static <T> void swap(T[] array, int i, int minIndex) {
		T temp = array[i];
		array[i] = array[minIndex];
		array[minIndex] = temp;
	}
}
