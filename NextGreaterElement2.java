//time complexity  - O(n)
//space complexity - O(n)
import java.util.*;
public class NextGreaterElement2 {
    static  int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] sol = new int[n];
        Arrays.fill(sol, -1);

        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < 2*n; i++) {
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i%n]) {
                int pop = stk.pop();
                sol[pop] = nums[i%n];
            }
            if(i < n) stk.push(i);
        }

        return sol;
    }

    public static void main(String[] args) {
        int[] nums = {8,4,2,7,5,11,8,4,5,6};
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Greatest Element to the right: " + Arrays.toString(nextGreaterElements(nums)));
    }
}
