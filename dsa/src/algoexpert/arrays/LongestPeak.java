package algoexpert.arrays;

public class LongestPeak {

	public static void main(String[] args) {

		System.out.println(findLongestPeak(
				new int[] { 1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1 }));

	}

	private static int findLongestPeak(int[] a) {
		int i = 1;
		int len = a.length - 1;
		int max = 0;
		while (i < len) {
			if (a[i - 1] < a[i] && a[i + 1] < a[i]) {
				int l = i - 1;
				int r = i + 1;
				while (l > 0 && a[l - 1] < a[l]) {
					l--;
				}
				while (r < len && a[r + 1] < a[r]) {
					r++;
				}
				if ((r - l + 1) > max) {
					max = r - l + 1;
				}
				i = r + 1;
			} else {
				i++;
			}
		}
		return max;
	}

}
