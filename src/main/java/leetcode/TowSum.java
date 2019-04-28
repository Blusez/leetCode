package leetcode;

import org.checkerframework.checker.units.qual.A;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TowSum {

	public static void main(String[] args) {
		//int[] ints = twoSum(new int[]{2, 7, 11, 15}, 14);
		//int[] ints = twoSumForce(new int[]{2, 7, 11, 15}, 18);
		//System.out.printf(lists.toString());
	}

	/**
	 * 一次hash
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (hashMap.containsKey(complement)) {
				return new int[]{hashMap.get(complement), i};
			}
			hashMap.put(nums[i], i);
		}
		throw new IllegalArgumentException(" No two sum solution");
	}

	public static int[] twoSumForce(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[]{i, j};
				}
			}
		}
		throw new IllegalArgumentException(" No two sum solution");
	}


}
