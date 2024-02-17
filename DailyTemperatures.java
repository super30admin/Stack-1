// Time complexity : O(n)
// Space complexity : O(n)

import java.util.*;

class DailyTemperatures {
    public static void main(String[] args) {
        int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = dailyTemperatures(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] dailyTemperatures(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int popped = stack.pop();
                result[popped] = i - popped;
            }
            stack.add(i);
        }
        return result;
    }

}