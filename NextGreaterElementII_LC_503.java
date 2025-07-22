/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity- O(N)
Space Complexity- O(N)
*/
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII_LC_503 {
    public int[] nextGreaterElements(int[] nums) {
        int result[] = new int[nums.length];
        Arrays.fill(result, -1);  // default to -1
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i< 2*n; i++) {
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]) {
                int poppedIndex = st.pop();

                result[poppedIndex] = nums[i % n];

            }
            if(i < n){
                st.push(i);
            }
        }
        return result;
    }
}