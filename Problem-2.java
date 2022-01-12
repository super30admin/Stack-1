// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        
        for(int i=0;i<n*2;i++) {
            
            while(!s.isEmpty() && temperatures[s.peek()]<temperatures[i%n]) {
                
                result[s.peek()] = temperatures[i%n];
                s.pop();
            }
            
            if(i<n) {
                s.push(i);
            }
            
        }
        
        while(!s.isEmpty()) {
            
            result[s.pop()] = -1;
        }
        
        return result;
    }
}