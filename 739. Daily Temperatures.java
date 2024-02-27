// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        Stack<Integer> q = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            int temp = temperatures[i];

            while(!q.isEmpty() && temperatures[q.peek()] < temp){
                int popped = q.pop();
                result[popped] = i - popped;
            }

            q.add(i);
        }

        return result;
        
    }
}
