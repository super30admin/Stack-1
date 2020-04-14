
// Time Complexity : O(n)
// Space Complexity : On1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


import java.util.*;
public class DailyTemperatires {

	public int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];

		Stack<Integer> stack = new Stack<>();
		
		for(int i =0; i <T.length; i++) {
			
			
			while(!stack.empty() && T[i] > T[stack.peek()]) {
				int priorIndex = stack.pop();
				res[priorIndex] = i - priorIndex;
			}
			
			stack.push(i);
		}
		
		
		return res;
	}

	public static void main(String[] args) {

		DailyTemperatires d = new DailyTemperatires();

		int[] res = d.dailyTemperatures(new int[] { 2, 3, 5, 6, 7, 9, 3, 5, 6, 8 });
		
		for(int i : res) {
			System.out.println(i);
		}

	}

}
