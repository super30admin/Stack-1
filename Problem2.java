import java.util.Stack;
/*
Next Greater Element ii
approach: run on nums twice and keep track of numbers for which we didn't find greater element
time: O(3n) run twice on nums, popping
space: O(n)
 */
public class Problem2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int res[] = new int[n];
        for(int i=0;i<2*n;i++) {
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()%n]) {
                int pop = st.pop()%n;
                res[pop] = nums[i%n];
            }
            if(i<n) {
                st.push(i);
            }
        }

        while(!st.isEmpty()) {
            res[st.pop()%n] = -1;
        }

        return res;
    }
}
