//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;
import java.util.Stack;
import java.util.Arrays;
class Next_Greater_Element_2_503 {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[0];
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for(int i = 0; i < nums.length; i++)
        {
            while(!st.isEmpty() && nums[i] > nums[st.peek()])
                result[st.pop()] = nums[i];
            st.push(i);
        }
        for(int i = 0; i < nums.length; i++)
        {
            while(!st.isEmpty() && nums[i] > nums[st.peek()])
            {
                result[st.pop()] = nums[i];
            }
            st.push(i);
        }
        return result;
    }
    public static void main(String[] args)
    {
    	int[] arr = {1,3,5,8,9,3,5,2,6};
    	int n = arr.length;
    	Next_Greater_Element_2_503 nge = new Next_Greater_Element_2_503();
    	int[] result = new int[n];
    	result = nge.nextGreaterElements(arr);
    	for(int i : result)
    		System.out.print(i + " ");
    }
}
