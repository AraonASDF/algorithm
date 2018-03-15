package selectionsort_pro;

public class SelectionSort {
	private SelectionSort() {
	}

	public static <T extends Comparable<T>> void selectionSort(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[minIndex]) < 0) {
					minIndex = j;
				}
			}
			swap(array, i, minIndex);
		}
	}

	private static void swap(Object[] array, int i, int minIndex) {
		Object temp = array[i];
		array[i] = array[minIndex];
		array[minIndex] = temp;
	}

	public static void main(String[] args) {
		Integer[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		selectionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		Double[] b = { 9.1, 8.1, 7.1, 6.1, 5.1, 4.1, 3.1, 2.1, 1.1 };
		selectionSort(b);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();

		String[] c = { "e", "c", "d", "b", "a" };
		selectionSort(c);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();

		Student[] d = { 
				new Student("A", 90), 
				new Student("B", 85), 
				new Student("C", 97), 
				new Student("D", 60) 
				};
		selectionSort(d);
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
		System.out.println();
	}
}
