public class Solution
	{
        // Time Complexity : O(n)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int[] NextGreaterElements(int[] nums)
        {
            int n = nums.Length;
            int[] result = new int[n];
            Stack<int> st = new Stack<int>();
            for(int i = 0; i < n; i++)
            {
                result[i] = -1;
            }

            for(int i = 0; i < 2 * n; i++)
            {
                while(st.Count > 0 && nums[i % n] > nums[st.Peek()])
                {
                    int popped = st.Pop();
                    result[popped] = nums[i % n];
                }
                if(i < n)
                    st.Push(i);
            }
            return result;
        }
    }
