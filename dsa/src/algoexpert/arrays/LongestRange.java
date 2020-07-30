package algoexpert.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestRange {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6 };
		System.out.println(Arrays.toString(findLongestRange(arr)));

	}

	private static Integer[] findLongestRange(Integer[] arr) {
		Map<Integer, Boolean> map = new HashMap<>();
		Integer len = arr.length;
		if (len == 1) {
			return new Integer[] { arr[0], arr[1] };
		}
		Integer maxRange = Integer.MIN_VALUE;
		Integer[] range = new Integer[2];
		for (Integer i = 0; i < len; i++) {
			map.put(arr[i], Boolean.TRUE);
		}
		for (Integer i = 0; i < len; i++) {
			Integer num = arr[i];
			if (map.get(arr[i])) {
				while (map.containsKey(num)) {
					map.put(num, Boolean.FALSE);
					num--;
				}
				Integer lowerRange = num + 1;
				num = arr[i];
				while (map.containsKey(num)) {
					map.put(num, Boolean.FALSE);
					num++;
				}
				Integer higherRange = num - 1;
				Integer currRange = Math.abs(higherRange - lowerRange);
				if (maxRange < currRange) {
					range[0] = lowerRange;
					range[1] = higherRange;
					maxRange = currRange;
				}
			}
		}
		return range;
	}

}
