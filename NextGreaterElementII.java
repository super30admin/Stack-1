//https://leetcode.com/problems/next-greater-element-ii/
// Time Complexity :O(n)  
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        Arrays.fill(result,-1);
        //Monotonic increasing stack method 
        //if you can not resolve the peek element you can not resolve elements under it
        //in this case we maintain the indexes
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<2*n;i++)
        {
            
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()])
            {
                int peek=st.pop();
                result[peek]=nums[i%n];
            }
            if(i<n) //we are pushing only till first cycle for the undiscovered elements
                st.push(i);
            //in the second round when we reach the index we are searching for it means it is not found
            if(i>=n && i%n==st.peek())
            {
                    break;
            }
        }
        return result;
    }
}