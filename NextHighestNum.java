// Time Complexity : O(N +k)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;
import java.util.Stack;

public class NextHighestNum {

    public int[] nextGreaterElements(int[] nums) {
      Stack<int[]> stack = new Stack<int[]>();
      stack.push( new int[]{ nums[0], 0});
      int[] resultant = new int[nums.length];
      Arrays.fill(resultant, -1);

      for(int i=1; i < nums.length; i++){
        while( !stack.isEmpty() && stack.peek()[0] < nums[i]){
          resultant[stack.peek()[1]] = nums[i];
          stack.pop();
        }
        stack.push(new int[]{ nums[i], i});
      }

      for(int i=0; i < nums.length; i++){
        while(!stack.isEmpty() && stack.peek()[0] < nums[i]){
          resultant[stack.peek()[1]] = nums[i];
          stack.pop();
        }
      }
      return resultant;
    }
  }
