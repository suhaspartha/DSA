package algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sort: O(nlog(n)); traversal: n^2; time: n^2; space:O(log(n))-stack trace
 *
 */
public class ThreeNumberSum {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 4, -2, 7, 6 };
		int targetSum = 10;
		if (array.length < 3)
			System.out.println("No triplets");
		List<Integer[]> triplets = threeNumberSum(array, targetSum);
		triplets.forEach(s -> System.out.println(Arrays.toString(s)));

	}

	private static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		Arrays.sort(array);// -2,1,4,5,6,7
		int fixedPointer = 0;
		int secondaryPointer = fixedPointer + 1;
		int tertiaryPointer = array.length - 1;
		List<Integer[]> triplets = new ArrayList<>();
		while (fixedPointer <= array.length - 3) {
			while (secondaryPointer < tertiaryPointer) {
				int tempSum = array[fixedPointer] + array[secondaryPointer] + array[tertiaryPointer];
				if (tempSum > targetSum) {
					tertiaryPointer--;
				} else if (tempSum < targetSum) {
					secondaryPointer++;
				} else {
					Integer[] triplet = new Integer[] { array[fixedPointer], array[secondaryPointer],
							array[tertiaryPointer] };
					triplets.add(triplet);
					secondaryPointer++;
				}
			}
			fixedPointer++;
			secondaryPointer = fixedPointer + 1;
			tertiaryPointer = array.length - 1;
		}
		return triplets;
	}

}
