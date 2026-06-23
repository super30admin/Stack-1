// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
I maintain a monotonic decreasing stack and create the result array and fill it with -1. I traverse through the nums array 2*n times where n is the size of the array. 
I get the index at each traversal as i%n and while the stack is not empty and element on top of stack is less than current number, 
I update the corresponding result for the element on top of the stack with the current element (this means that the
current element is the next greater element for the element on top of the stack). If i is less than n, I push index to stack(to ensure only
distinct values of index gets pushed into the stack). At the end I return the result array.
*/

public class Solution {
    public int[] NextGreaterElements(int[] nums) {
        int n = nums.Length;
        Stack<int> st = new();
        int[] result = new int[n];
        Array.Fill(result, -1);

        for(int i = 0; i < 2 * n; i++)
        {
            int index = i % n;
        
            while(st.Count != 0 && nums[st.Peek()] < nums[index])
            {
                result[st.Pop()] = nums[index];
            }

            if(i < n)
            {
                st.Push(index);
            }

        }

        return result;
    }
}