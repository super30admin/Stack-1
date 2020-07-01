// Time Complexity : O(length of array)
// Space Complexity : O(length of array)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length,i=2*n-1;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        
        while(i>=0){
            int index=i%n;
            while(!st.isEmpty() && st.peek()<=nums[index])
                st.pop();
            
            res[index]=st.isEmpty()?-1:st.peek();
            st.push(nums[index]);
            i--;
        }
        
        return res;
    }
}
