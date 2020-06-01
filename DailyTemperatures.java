// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class DailyTemperatures {
    // Brute Force
    // Time Complexity : O(n^2)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public int[] dailyTemperaturesBF(int[] T) {
        int[] output = new int[T.length];
        for(int i = 0; i < T.length; i++){
            int j = i + 1;
            int count = 0;
            while(j < T.length){
                count++;
                if(T[i] < T[j]){
                    break;
                } else if(T[i] >= T[j] && j == T.length - 1){
                    count = 0;
                    break;
                } else {
                    j++;
                }
            }

            output[i] = count;
        }

        return output;
    }

    // O(n) Solution
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public int[] dailyTemperatures(int[] T) {

        if(T == null || T.length == 0){
            return T;
        }

        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < T.length; i++){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int el = stack.pop();
                result[el] = i - el;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            result[stack.pop()] = 0;
        }

        return result;
    }
}
