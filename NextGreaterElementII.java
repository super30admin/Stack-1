import java.util.*;

/*
TC: O(2N)
SC: O(N)

1. Traverse the array for first time to find next bigger element.
2. Traverse second time to find next big element in circular  array.
3. The stack contains indices of values greater than current value.

Approach 2: Reverse order

*/

public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 2 * n - 1; i >= 0; i--){
            while(!stk.isEmpty() && nums[stk.peek()] <= nums[i % n]){
                stk.pop();
            }

            res[i % n] = stk.isEmpty() ? -1 : nums[stk.peek()];
            stk.push(i % n);
        }
        return res;
    }

    public int[] nextGreaterElements2(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for(int i = 0; i < 2 * n; i++){
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i % n]){
                res[stk.pop()] = nums[i % n];
            }
            stk.push(i % n);
        }
        return res;
    }

    public static void main(String[] args){
        int[] temp = new int[]{1,2,1};
        NextGreaterElementII ng = new NextGreaterElementII();

        int[] res = ng.nextGreaterElements(temp);
        for(int num : res){
            System.out.print(num + " ");
        }
        System.out.println();
        int[] res2 = ng.nextGreaterElements2(temp);
        for(int num : res2){
            System.out.print(num + " ");
        }
    }
}
