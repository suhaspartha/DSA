package algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateSubSequence {

	public static void main(String[] args) {
		List<Integer> array = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer> subSeq = new ArrayList<Integer>(Arrays.asList(1,3,5));
		System.out.println(isSubSequence(array, subSeq));
	}

	private static boolean isSubSequence(List<Integer> array, List<Integer> subSeq) {
		if(subSeq.size()>array.size() || subSeq.size()<0) {
			return false;
		}
		int j=0;
		for(int i=0; i<array.size(); i++) {
			if(j<subSeq.size() && subSeq.get(j) == array.get(i)) {
				j++;
			}
		}
		return j == subSeq.size();
	}

}
