// Time Complexity : O(3n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//503. Next Greater Element II
//https://leetcode.com/problems/next-greater-element-ii/

class Solution {
    //Monotonic Stack
    //time: O(3n) - 2 passes on the array and n for the stack that's checking elements before to resolve
    //space: O(n)
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for(int i=0; i<2*n; i++){
            
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()]){
                   
                int idx = st.pop(); 
                result[idx] = nums[i%n];
            }
            
            if(i<n){
                st.push(i);
            }
        
        }
       return result; 
    }
    
}