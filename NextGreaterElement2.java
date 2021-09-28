//https://leetcode.com/problems/next-greater-element-ii/
/*
Time: O(n) where n = A.length
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] A) {
        int n = A.length;
        int res[] = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n * 2; i++) {
            // If curr is greater than top of stack, update res[top] with curr
            int curr = A[i % n];

            while (!stack.isEmpty() && curr > A[stack.peek()]) {
                int top = stack.pop();
                res[top] = curr;
            }

            stack.push(i % n); // push index
        }

        return res;
    }

}
