// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
//We will create a result array with the length same as nums. Then iterate through the array twice, once to check the next greater element on the 
// right side of the array, and after we reach the end of the array, we start from the beginning once again to check if it exists on the left side 
// of the array. We will maintain a stack to push the elements which need to be processed 
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack <Integer> st=new Stack<>();
        int [] result=new int[n];
        Arrays.fill(result,-1);

        for(int i=0;i<2*n;i++)
        {
            while(!st.empty() && nums[st.peek()]<nums[i%n])
            {
                int popped=st.pop();
                result[popped]=nums[i%n];
            }

            if(i<n)
            st.push(i);
        }
        return result;
    }
}