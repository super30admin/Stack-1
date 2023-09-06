// Time Complexity : O(n)  ->  O(4n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result,-1);  // O(n)
        for(int i=0; i<2*n; i++){  //O(3n)
            if(i > n){
                if(st.peek() == i%n) break;
            }
            int currNum = nums[i%n];
            while(!st.isEmpty() && currNum > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = currNum;
            }
            if(i < n)   st.push(i%n);
        }
        return result;
    }
}
