package algoexpert.arrays;

import java.util.Arrays;

/**
 * Traversal: O(n); time: O(n); space: constant
 *
 */
public class MoveElementToEnd {

	public static void main(String[] args) {
		int[] array = new int[] { 2, 1, 2, 2, 2, 3, 4, 2 };
		int elementToMove = 2;
		System.out.println(Arrays.toString(moveElementToEnd(array, elementToMove)));

	}

	private static int[] moveElementToEnd(int[] array, int elementToMove) {
		int i = 0;
		int j = array.length - 1;
		if (array.length <= 1)
			return new int[0];
		while (i < j) {
			if (array[i] == elementToMove && array[i] == array[j]) {
				j--;
			}
			if (array[i] == elementToMove) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			} else {
				i++;
			}
		}
		return array;
	}

}
