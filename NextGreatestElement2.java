// TC: O(n)
// SC: O(n)

import java.util.*;

public class NextGreatestElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            stack.push(nums[i]);
        }
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i]>=stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }
}
