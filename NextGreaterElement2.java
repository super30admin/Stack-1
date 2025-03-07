//TC: O(n)
//SC: O(n)
//approach: monotonically increasing stack

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for(int i=0;i<2*nums.length;i++){
            int j = i%nums.length;
            while(!stack.isEmpty() && nums[j] > nums[stack.peek()]){
                result[stack.pop()] = nums[j];
            }
            if(i<nums.length){
                stack.push(i);
            }
        }
        return result;
    }
}
