// Time Complexity : O(2n)= O(n) for iterating over temp
// Space Complexity : O(n) for the stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String [] args){
        DailyTemp dt = new DailyTemp();
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}