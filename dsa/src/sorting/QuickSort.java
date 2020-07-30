package sorting;

import java.util.Arrays;

/**
 * time : O(nlog(n)); space: O(log(n)) - recursive call
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] array = new int[] { 89, 1134, 8993, 890 };
		quickSortHelper(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));

	}

	private static void quickSortHelper(int[] array, int start, int end) {
		// simply return if start has surpassed end - also avoids array index out of
		// bounds during swap
		if (start >= end)
			return;
		int pivot = start;
		int left = start + 1;
		int right = end;
		// While left pointer is smaller than the right
		while (right >= left) {
			// If left element is bigger and right element is smaller w.r.t pivot, swap them
			if (array[left] > array[pivot] && array[right] < array[pivot]) {
				swap(array, left, right);
			}
			// If left element is already smaller compared to pivot, move ahead
			if (array[left] < array[pivot]) {
				left++;
			}
			// If right element is already bigger compared to pivot, then decrement
			if (array[right] > array[pivot]) {
				right--;
			}
		}
		// One left pointer crosses right, blindly swap pivot and right element
		swap(array, pivot, right);
		// First solve array with smaller length - tail recursion - reduce number of
		// stack frames at given point of time
		boolean isLeftSubArraySmaller = (right - 1 + start) < (end - right + 1);
		if (isLeftSubArraySmaller) {
			quickSortHelper(array, 0, right - 1);
			quickSortHelper(array, right + 1, end);
		} else {
			quickSortHelper(array, right + 1, end);
			quickSortHelper(array, right - 1, 0);
		}

	}

	private static void swap(int[] array, int pivot, int right) {
		int temp = array[pivot];
		array[pivot] = array[right];
		array[right] = temp;

	}

}
