import java.util.Arrays;
import java.util.Stack;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Brute force approach would lead to O(n^2), where we would have used a for-loop to find next greater.
 *
 *  Utilize the stack property of LIFO to find the next greater.
 * 2. Instead - utilizing the monotonic increasing stack to store the numbers
 *  in increasing order and get next greater number.
 * 3. Since it is a circular array, the traversal needs to happen twice on the array
 * 4. The stack is storing only the index, so if a number greater than peek is found,
 *  use it as a result and move to next index
 */

public class NextGreaterNum2 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            while (!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                result[s.pop()] = nums[i%n];
            }
            if (i < n) {
                s.push(i);
            }       
        }

        return result;
    }
    public static void main(String[] args) {
        // Your code here
    }
}