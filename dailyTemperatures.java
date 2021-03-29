// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> s = new Stack();
        
        for(int i = 0;i<T.length;i++) {
            
            while(!s.isEmpty() && T[s.peek()]<T[i]) {
                int j = s.pop();
                T[j] = i-j;
            }
            s.push(i);
            
        }
        
        while(!s.isEmpty()) {
                T[s.pop()] = 0;
        }
        
        return T;
        
    }
}
