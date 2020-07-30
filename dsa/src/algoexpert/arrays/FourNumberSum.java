package algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum {
	public static void main(String[] args) {
		int[] arr = new int[] { -10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5 };
		int target = 20;
		List<Integer[]> quadruplets = arr.length < 4 ? new ArrayList<>() : findFourNumSum(arr, target);
		quadruplets.forEach(array -> System.out.println(Arrays.toString(array)));
	}

	private static List<Integer[]> findFourNumSum(int[] arr, int target) {
		Map<Integer, List<Integer[]>> map = new HashMap<>();
		List<Integer[]> quadruplets = new ArrayList<>();
		int len = arr.length;
		/*
		 * Start from pos 1 because in the first iteration we won't get any target-sum
		 * in the map as no values will be present
		 */
		for (int i = 1; i < len - 1; i++) {
			/*
			 * Go ahead and check if we find any key as target-sum, if not keep moving and
			 * do not add difference/sum as key
			 */
			for (int j = i + 1; j < len; j++) {
				int sum = arr[i] + arr[j];
				int val = target - sum;
				if (map.containsKey(val)) {
					for (Integer[] a : map.get(val)) {
						Integer[] fourNumber = new Integer[] { a[0], a[1], arr[i], arr[j] };
						quadruplets.add(fourNumber);
					}
				}
			}
			/*
			 * Go in backward direction and add sum of current element and all that behind
			 * this as key. If already exists add this pair to list.
			 */
			for (int k = i - 1; k >= 0; k--) {
				int sum = arr[i] + arr[k];
				if (map.containsKey(sum)) {
					map.get(sum).add(new Integer[] { arr[k], arr[i] });
				} else {
					List<Integer[]> tuplet = new ArrayList<>();
					tuplet.add(new Integer[] { arr[k], arr[i] });
					map.put(sum, tuplet);
				}
			}
		}
		return quadruplets;
	}
}
