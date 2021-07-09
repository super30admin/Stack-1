import java.util.*;

public class NextGraterElement2 {


    //TC:O(N) - O(3N) - For filling up the array, traversing the entire array 2 times
    //SC:O(N) - For using stack. the int[] result will not be counted as it was required output.
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[] {};
        Stack<Integer> stack = new Stack();
        int m = nums.length;
        int[] result = new int[m];
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * m; i++) {
            while (!stack.isEmpty() && nums[i % m] > nums[stack.peek()]) {
                result[stack.peek()] = nums[i % m];
                stack.pop();
            }
            stack.push(i % m);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGraterElement2 next = new NextGraterElement2();
        next.nextGreaterElements(new int[] { 1, 2, 3, 4, 3 });
    }
}
