// Time Complexity : O(3n)= O(n) for iterating over temp
// Space Complexity : O(n) for the stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class NextGreaterEle {
    public int[] nextGreaterElements(int[] nums) {
        int [] result = new int[nums.length];
        if(nums==null || nums.length==0) return result;
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result, -1);
        for(int i=0;i<nums.length*2;i++){
            while(!stack.isEmpty() && nums[i%nums.length] > nums[stack.peek()]){
                int idx = stack.pop();
                result[idx] = nums[i%nums.length];
            }
            if(i<nums.length){
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String [] args){
        NextGreaterEle nge = new NextGreaterEle();
        System.out.println(Arrays.toString(nge.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
}