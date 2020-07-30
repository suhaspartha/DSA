package algoexpert.arrays;

import java.util.Arrays;

/**
 * Sort: O(nlog(n)); iteration: n; time : O(nlog(n)); space:O(log(n))-stack
 * trace
 */
public class SmallestDifferennce {
	public static void main(String[] args) {
		int[] array1 = new int[] { -1, 5, 10, 20, 28, 3 };
		int[] array2 = new int[] { 26, 134, 135, 15, 17 };
		Arrays.stream(array2).map(Integer::valueOf).sum();
		System.out.println(Arrays.toString(smallestDifference(array1, array2)));
	}

	private static int[] smallestDifference(int[] array1, int[] array2) {
		Arrays.sort(array1);// -1,3,5,10,20, 28
		Arrays.sort(array2);// 15,17,26,134,135
		int p1 = 0, p2 = 0;
		int diff = 0;
		int min = Integer.MAX_VALUE;
		int[] arr = new int[0];
		while (p1 < array1.length && p2 < array2.length) {
			int tp1 = p1;
			int tp2 = p2;
			if (array1[p1] == array2[p2])
				return new int[] { array1[p1], array2[p2] };
			if (array1[p1] > array2[p2]) {
				diff = array1[p1] - array2[p2];
				p2++;
			} else {
				diff = array2[p2] - array1[p1];
				p1++;
			}
			if (diff < min) {
				min = diff;
				arr = new int[] { array1[tp1], array2[tp2] };
			}
		}
		return arr;
	}
}
