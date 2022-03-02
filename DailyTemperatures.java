package stacks1;

import java.util.Stack;

public class DailyTemperatures {
	//Time Complexity : O(n), where n is length of temperatures array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] res = new int[n];
		if(temperatures == null || temperatures.length == 0)
			return res;

		int max = temperatures[n - 1];
		for(int i=n-1; i>=0; i--) {
			if(temperatures[i] >= max) {
				max = temperatures[i];
				continue;
			}
			int j = i + 1;
			while(j < n && temperatures[j] <= temperatures[i])
				j += res[j];
			res[i] = j - i;
		}

		return res;
	}

	//Time Complexity : O(n), where n is length of temperatures array
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[] dailyTemperatures1(int[] temperatures) {
		int[] res = new int[temperatures.length];
		if(temperatures == null || temperatures.length == 0 || temperatures.length == 1)
			return res;

		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<temperatures.length; i++) {
			while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int popped = stack.pop();
				res[popped] = i - popped;
			}
			stack.push(i);
		}

		return res;
	}

	//Time Complexity : O(n^2), where n is length of temperatures array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[] dailyTemperatures2(int[] temperatures) {
		int n = temperatures.length;
		int[] res = new int[n];

		for(int i=0; i<n - 1; i++) {
			for(int j=i + 1; j<n; j++) {
				if(temperatures[j] > temperatures[i]) {
					res[i] = j - i;
					break;
				}
			}
		}

		return res;
	}
}
