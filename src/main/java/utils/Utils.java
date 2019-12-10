package utils;

import java.lang.reflect.Method;
import java.util.Random;

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
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(r - l + 1) + l;
        }
        return array;
    }

    public static int[] generateRandomIntArray(int n, int l, int r) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(r - l + 1) + l;
        }
        return array;
    }

    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            Utils.swap(arr, random.nextInt(n), random.nextInt(n));
        }
        return arr;
    }

    public static int[] generateNearlyOrderedIntArray(int n, int swapTimes) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            Utils.swap(arr, random.nextInt(n), random.nextInt(n));
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void testSort(Class className, int[] arr) {
        try {
            Method selectionSort = className.getDeclaredMethod("sort", int[].class);
            Object[] params = new Object[]{arr};
            long start = System.currentTimeMillis();
            selectionSort.invoke(null, params);
            long end = System.currentTimeMillis();
            assert isSorted(arr);
            System.out.println(className.getSimpleName() + ":" + (end - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T extends Comparable<T>> void testSort(Class className, T[] arr) {
        try {
            Method selectionSort = className.getDeclaredMethod("sort", Comparable[].class);
            Object[] params = new Object[]{arr};
            long start = System.currentTimeMillis();
            selectionSort.invoke(null, params);
            long end = System.currentTimeMillis();
            assert isSorted(arr);
            System.out.println(className.getSimpleName() + ":" + (end - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
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
