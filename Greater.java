// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1 - We traverse the array.
 * 2 - Compare each incoming element with the one present in the stack. Remember, we need to traverse the array twice 
 * so that is why 2*n
 * 3 - If incoming element is greater than the one present in the top of the stack, add it to the result at that index 
 * else we keep adding to the stack.
 */

public class Greater {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        
        int[] result = new int[n];
        if(nums == null || nums.length == 0)
        {
            return result;
        }
        Arrays.fill(result,-1);
        
        for(int i = 0; i < 2*n; i++)
        {
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n])
            {
                int idx = st.pop();
                result[idx] = nums[i%n];
            }
            if(i < n)
            {
                st.push(i);
            }
        }
        
        return result;
    }
}
