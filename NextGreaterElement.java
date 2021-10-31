package Stack1;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n*2; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()] ){
                int top = st.pop();
                result[top] = nums[i%n];
            }
            if(i < n)
                st.push(i);
        }
        return result;
    }
}
