// Time Complexity :O(n) where n is length of the nums array
// Space Complexity :O(n) where n is length of the nums array
// Did this code successfully run on Leetcode :yes

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length < 1){
            return null;
        }

        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<Integer>();

        for(int i=0; i< 2*len; i++){
            while(!st.empty() && nums[i%len] > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[i%len];
            }
            if(i > len && st.peek() == i%len){
                break;
            }
            if(i < len){
                st.push(i);
            }
        }
        return result;
    }
}

