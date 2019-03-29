package report_03;

import java.util.Arrays;

public class Main {

	static int[] randomArray1000 = new int[1000];
	static int[] randomArray10000 = new int[10000];
	static int[] randomArray100000 = new int[100000];
	static int[] reverseArray1000 = new int[1000];
	static int[] reverseArray10000 = new int[10000];
	static int[] reverseArray100000 = new int[100000];

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\t\t Random1000\t Reverse1000\t Random10000\t Reverse10000\t Random100000\t Reverse100000");

		arrayClear();
		System.out.printf("Bubble\t\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t\n", bubbleSort(randomArray1000),
				bubbleSort(reverseArray1000), bubbleSort(randomArray10000), bubbleSort(reverseArray10000),
				bubbleSort(randomArray100000), bubbleSort(reverseArray100000));

		arrayClear();
		System.out.printf("Selection\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t\n", selectionSort(randomArray1000),
				selectionSort(reverseArray1000), selectionSort(randomArray10000), selectionSort(reverseArray10000),
				selectionSort(randomArray100000), selectionSort(reverseArray100000));

		arrayClear();
		System.out.printf("Insertion\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t\n", selectionSort(randomArray1000),
				selectionSort(reverseArray1000), insertionSort(randomArray10000), insertionSort(reverseArray10000),
				insertionSort(randomArray100000), insertionSort(reverseArray100000));

		arrayClear();
		System.out.printf("Merge\t\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t\n",
				mergesort(randomArray1000, 0, randomArray1000.length - 1),
				mergesort(reverseArray1000, 0, reverseArray1000.length - 1),
				mergesort(randomArray10000, 0, randomArray10000.length - 1),
				mergesort(reverseArray10000, 0, reverseArray10000.length - 1),
				mergesort(randomArray100000, 0, randomArray100000.length - 1),
				mergesort(reverseArray100000, 0, reverseArray100000.length - 1));

		arrayClear();
		System.out.printf("Quick1\t\t .8f\t\t %.8f\t %.8f\t %.8f\t\n",
				quickSort1(randomArray1000, 0, randomArray1000.length - 1),
				quickSort1(reverseArray1000, 0, reverseArray1000.length - 1),
				quickSort1(randomArray10000, 0, randomArray10000.length - 1),
				quickSort1(reverseArray10000, 0, reverseArray10000.length - 1));

		arrayClear();
		System.out.printf("Quick2\t\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t\n",
				quickSort2(randomArray1000, 0, randomArray1000.length - 1),
				quickSort2(reverseArray1000, 0, reverseArray1000.length - 1),
				quickSort2(randomArray10000, 0, randomArray10000.length - 1),
				quickSort2(reverseArray10000, 0, reverseArray10000.length - 1),
				quickSort2(randomArray100000, 0, randomArray100000.length - 1),
				quickSort2(reverseArray100000, 0, reverseArray100000.length - 1));

		arrayClear();
		System.out.printf("Quick3\t\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t %.8f\t\n",
				quickSort3(randomArray1000, 0, randomArray1000.length - 1),
				quickSort3(reverseArray1000, 0, reverseArray1000.length - 1),
				quickSort3(randomArray10000, 0, randomArray10000.length - 1),
				quickSort3(reverseArray10000, 0, reverseArray10000.length - 1),
				quickSort3(randomArray100000, 0, randomArray100000.length - 1),
				quickSort3(reverseArray100000, 0, reverseArray100000.length - 1));
	}

	
	public static void arrayClear() {

		for (int i = 0; i < 1000; i++) {
			reverseArray1000[1000 - i - 1] = i;
			randomArray1000[i] = (int) (Math.random() * i);
		}

		for (int i = 0; i < 10000; i++) {
			reverseArray10000[10000 - i - 1] = i;
			randomArray10000[i] = (int) (Math.random() * i);
		}

		for (int i = 0; i < 100000; i++) {
			reverseArray100000[100000 - i - 1] = i;
			randomArray100000[i] = (int) (Math.random() * i);
		}
	}

	public static double bubbleSort(int arr[]) {

		long start = System.currentTimeMillis();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}

		long finish = System.currentTimeMillis();

		return ((double) finish - start) / 1000;

	}

	public static double selectionSort(int[] arr) {

		long start = System.currentTimeMillis();

		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, min, i);
		}

		long finish = System.currentTimeMillis();

		return ((double) finish - start) / 1000;
	}

	public static double insertionSort(int[] arr) {

		long start = System.currentTimeMillis();

		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			while ((j > 0) && (arr[j - 1] > temp)) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}

		long finish = System.currentTimeMillis();

		return ((double) finish - start) / 1000;
	}

	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public static double mergesort(int[] arr, int left, int right) {

		long start = System.currentTimeMillis();

		int mid = 0;

		if (left < right) {

			mid = (left + right) / 2;

			mergesort(arr, left, mid);

			mergesort(arr, mid + 1, right);

			merge(arr, left, mid, right);

		}

		long finish = System.currentTimeMillis();

		return ((double) finish - start) / 1000;

	}

	public static void merge(int[] arr, int left, int mid, int right) {

		int i = left, j = mid + 1, k = left;

		int temp[] = new int[arr.length];

		while (i <= mid && j <= right) {

			if (arr[i] <= arr[j])

				temp[k++] = arr[i++];

			else

				temp[k++] = arr[j++];

		}

		while (i <= mid)

			temp[k++] = arr[i++];

		while (j <= right)

			temp[k++] = arr[j++];

		for (int a = left; a < k; a++)

			arr[a] = temp[a];

	}

	public static double quickSort1(int[] arr, int left, int right) {
		long start = System.currentTimeMillis();
		int pivot = 0;
		if (left < right) {
			pivot = partitionLast(arr, left, right);
			quickSort1(arr, left, pivot - 1);
			quickSort1(arr, pivot + 1, right);
		}
		long finish = System.currentTimeMillis();

		return ((double) finish - start) / 1000.0;
	}

	public static int partitionLast(int[] arr, int left, int right) {
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (arr[j] <= arr[right]) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, right);
		return i + 1;
	}

	
	public static double quickSort2(int[] arr, int left, int right) {

		long start = System.currentTimeMillis();

		int pivot = 0;
		if (left < right) {
			pivot = partitionMid(arr, left, right);
			quickSort2(arr, left, pivot - 1);
			quickSort2(arr, pivot + 1, right);
		}

		long finish = System.currentTimeMillis();

		return ((double) finish - start) / 1000.0;
	}

	
	public static int partitionMid(int[] arr, int left, int right)
	{
		int mid = 0;
		mid = (left + right) / 2;
		mid = getMid(arr, mid, left, right);
		swap(arr, mid, right);
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (arr[j] <= arr[mid]) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, right);
		return i + 1;
	}

	
	public static int getMid(int[] arr, int left, int mid, int right) {

		if (arr[left] > arr[mid]) {
			if (arr[mid] > arr[mid])
				return mid;
			else if (arr[left] > arr[right])
				return right;
			else
				return left;
		} else {
			if (arr[left] > arr[right])
				return left;
			else if (arr[mid] > arr[right])
				return right;
			else
				return mid;
		}
	}

	
	public static double quickSort3(int[] arr, int left, int right) {

		long start = System.currentTimeMillis();

		if (left < right) {

			int pivot = partitionRandom(arr, left, right);

			quickSort3(arr, left, pivot - 1);

			quickSort3(arr, pivot + 1, right);

		}

		long finish = System.currentTimeMillis();

		return ((double) finish - start) / 1000.0;

	}

	
	public static int creadteRandomInt(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}
	
	public static int partitionRandom(int[] arr, int left, int right) {

		int random = creadteRandomInt(left, right);
		swap(arr, right, random);
		return partition(arr, left, right);

	}

	
	public static int partition(int[] arr, int left, int right) {

		for (int j = left; j < right; j++) {

			if (arr[j] <= arr[right]) {

				swap(arr, left, j);

				left = left + 1;
			}
		}

		swap(arr, left, right);
		return left;
	}
}