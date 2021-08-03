// Time Complexity : O(N) // 2N
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Stack;

class DailyTemparatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int[] result= new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            if(!stack.isEmpty()&&stack.peek()<=temperatures[i]){
                int temp=stack.pop();
                result[temp]=i-temp;
            }
            stack.push(i);
        }
        return result;
    }
}