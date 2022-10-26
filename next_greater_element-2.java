// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res,-1);

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popedIndex = st.pop();
                res[popedIndex] = nums[i%n];
            }
            if(i<n)
             st.push(i);
        }
        return res;
    }
}