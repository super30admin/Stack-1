package Stack1;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    /* Created by palak on 8/2/2021 */

    /*
            Time Complexity: O(4n)
            Space Complexity: O(n)
    */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        if(nums == null)    return result;
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < 2 * n ; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]) {
                int top = stack.pop();
                result[top] = nums[i%n];
            }
            if(i < n)   stack.push(i);
        }
        return result;
    }
}
