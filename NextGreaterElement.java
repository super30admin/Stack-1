// Time Complexity (TC): O(n), where n is the length of the nums array.
// Space Complexity (SC): O(n), where n is the length of the nums array.

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); //O(n)
        Stack<Integer> st = new Stack<>(); //indexes

        for(int i=0; i<2*n; i++)
        { //2n
            if(!st.isEmpty() && (i%n)== st.peek()) break;
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n])
            { //n
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i < n)
            {
                st.push(i);
            }
            
        }
        return result;
    }
}