import java.util.Arrays;
import java.util.Stack;

/*
Time Complexity: O(N), N is the number of elements in the given array
Space Complexity: O(N), we are using stack
Run on Leetcode: yes
Any Difficulties: no

Approach: Solved After discussed in the class, similar approach as the daily temperatures question
 */
public class NextGreaterElementII {
   public static int[] nextGreaterElementII(int[] nums){
       int[] result = new int[nums.length];
       Stack<Integer> stack = new Stack<>();

       for(int index = 0; index<2*(nums.length)-1; index++){
           int i = index%nums.length;

           while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
               int prevIndex = stack.pop();
               result[prevIndex] = nums[i];
           }

           if(index<nums.length){
               stack.push(index);
           }
       }
       while(!stack.isEmpty()){
           result[stack.pop()] = -1;
       }
       return result;
   }

   public static void main(String[] args){
       int nums[] = {1,2,3,4,3};
       System.out.println("Next Greater Number II: "+ Arrays.toString(nextGreaterElementII(nums)));
   }
}
