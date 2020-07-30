package algoexpert.arrays;

/**
 * Time: O(n); space: O(1)
 *
 */
public class MonotonicArray {

	public static void main(String[] args) {
		int[] array = new int[] { -1, -5, -10, -1100, -1100, -1101, -1102, -1103 };
		System.out.println(isMonotonicArray(array));

	}

	private static boolean isMonotonicArray(int[] array) {
		int i = 0;
		int incr = 0;
		int decr = 0;
		while (i < array.length - 1) {
			if (array[i] > array[i + 1]) {
				decr++;
				i++;
			} else if (array[i] < array[i + 1]) {
				i++;
				incr++;
			} else {
				i++;
				incr++;
				decr++;
			}
		}

		return Math.abs(decr - incr) != array.length - 1;
	}

}
