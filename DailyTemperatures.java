// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// push elements to stack, as iterating the Temp[] if Temp[i]>stack top update result[] values for all elements who's temp is less than Temp[i]

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Arrays.fill(result, 0);
        
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<T.length; i++){
            while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                int j = stack.pop();
                result[j] = i-j;
            }
            
            stack.push(i);
        }
        
        return result;
    }
}