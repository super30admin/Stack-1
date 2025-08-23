/**
 * Solves the next greater element problem in a circular array.
 * Uses a monotonic stack to track indices and find the next greater number.
 * Returns an array where each index holds the next greater element or -1 if none exists.
 */
// Time Complexity: O(N), where N is the length of the array
// Space Complexity: O(N), for the stack used to store indices
public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            while (!stk.isEmpty() && nums[i % n] > nums[stk.peek()]) {
                int popped = stk.pop();
                result[popped] = nums[i % n];
            }
            if(i < n)
                stk.push(i % n);
            else if(stk.peek() == i % n) {
                break;
            }
        }
        return result;
    }
    
}
