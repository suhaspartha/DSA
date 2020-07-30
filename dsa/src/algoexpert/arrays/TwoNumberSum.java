package algoexpert.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

	public static void main(String[] args) {
		int[] array = new int[] { 3, 5, -4, 8, 11, 1, -1, 6 };
		int targetSum = 10;
		System.out.println(Arrays.toString(twoNumSum(array, targetSum)));

	}

	private static int[] twoNumSum(int[] array, int targetSum) {
		int[] res = new int[0];
		Map<Integer, Boolean> map = new HashMap<>();
		for (int num : array) {
			if (map.containsKey(targetSum - num)) {
				return res = new int[] { num, targetSum - num };
			}
			map.put(num, true);
		}
		return res;
	}

}
