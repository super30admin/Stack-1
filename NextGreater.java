/*
Time Complexity: nextGreaterElements() O(n^2)
Space: O(1) no auxilary space used in brute force

Next Greater optimal

Time Complexity: nextGreaterElementsOptimal() O(n)
Space: O(n) auxilary space of stack is used

*/
import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,3};
        // Brute force
        //arr = nextGreaterElements(arr);
        
        //Optimal using stacks
        arr = nextGreaterElementsOptimal(arr);
        for(int i: arr) System.out.print(" "+i);
    }
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int len = nums.length;
        for(int i = 0 ; i < nums.length; i++){
            for(int j = 1; j < nums.length; j++){
                int index = (i + j)% len;
                if(nums[index] > nums[i]){
                    res[i] = nums[index];
                    break;
                }
            }
        }
        return res;
    }

    public static int[] nextGreaterElementsOptimal(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;

        for(int i = 0; i < len * 2; i++) {
            int idx = i >= len ? i - len : i;
            while(!stack.empty() && nums[idx] > nums[stack.peek()]) {
                res[stack.peek()] = nums[idx];
                stack.pop();
            }            
            if(res[idx] == -1) { stack.push(idx); 
        }
    }
        return res;
    }
}
