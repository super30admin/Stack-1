// approch 1
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 1 brute force
    public static int[] nextGreaterElements1(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return new int[] {};
        int n = nums.length;
        // result array
        int[] result = new int[n];
        // fill result array with -1
        Arrays.fill(result, -1);
        // I will select one element at a time and check it's next greater element
        // using second for loop here 2nd for loop will run two times as it is
        // circular array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < 2 * n; j++) {
                if (nums[j % n] > nums[i]) {
                    result[i] = nums[j % n];
                    break;
                }
            }
        }
        return result;
    }

    // approch 2 using stacks
    public static int[] nextGreaterElements2(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return new int[] {};
        int n = nums.length;
        // result array
        int[] result = new int[n];
        // fill result array with -1
        Arrays.fill(result, -1);
        // stack for getting next greater element
        Stack<Integer> st = new Stack<>();
        // here I will run for loop for two times as
        // array is circular so it may be possible that
        // next greater element is on left side of the
        // array I will here check if incoming element is
        // greater than the top element in the stack
        // then I will update the result
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int idx = st.pop();
                result[idx] = nums[i % n];
            }
            // add index in the stack if i is less than n
            if (i < n) {
                st.push(i);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 3 };
        System.out.println(Arrays.toString(nextGreaterElements1(nums)));
        System.out.println(Arrays.toString(nextGreaterElements2(nums)));
    }
}