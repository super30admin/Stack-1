//Time complexity : O(n)
//Space Complexity :   O(1)
//Did it run on leetcode : yes

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 2*n ; i++){
            if(!st.isEmpty() && i%n == st.peek()) break;
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i < n){
                st.push(i);
            }
        }
        return result;
    }

}
