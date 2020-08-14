/**
 * Time Complexity : O(3n) where n is the number of elements in the array
 * Space Complexity : O(n)
 */

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);                                                                            
        if(nums == null || nums.length == 0){return result;}
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < 2 * n; i++){                                                                     
            while(!stk.isEmpty() && nums[i % n] > nums[stk.peek()]){
                int index = stk.pop();                                                                  
                result[index] = nums[i % n];                                                            
            }
            if(i < n){stk.push(i % n);}                                                                         
        }
        return result;
    }
}