// Time Complexity : O(N +k)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;
import java.util.Stack;

public class Temperature {
    public int[] dailyTemperatures(int[] temperatures) {

      Stack<int[]> stack = new Stack<int[]>();
      int[] arr = new int[temperatures.length];
      Arrays.fill(arr,0);
      stack.push(new int[]{ temperatures[0], 0});

      for(int i=1; i< temperatures.length; i++){

        while(!stack.isEmpty() && stack.peek()[0] <  temperatures[i]){
          arr[stack.peek()[1]]= i-stack.peek()[1];
          stack.pop();
        }
        stack.push(new int[]{ temperatures[i], i});
      }

      return arr;
    }
  }
