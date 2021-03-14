import java.util.Arrays;
import java.util.Stack;
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class NextGreaterElementII {

    class Solution {
        public int[] nextGreaterElements(int[] nums) {

            //create array to store output
            int n = nums.length;
            int[] outputArray = new int[n];

            Arrays.fill(outputArray, -1);// auto fill arrays with -1 to inidicate no next greater number

            Stack<Integer> st = new Stack<>();//stack to keep track of index

            //double the length of the array to iterate over and add to the array when stack isn't empty and value in
            //stack is less than current value.
            for (int i = 0; i < n*2; i++) {
                while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                    outputArray[st.pop()] = nums[i%n];
                }
                if(i<n) st.push(i);//push i on to stack only when i is less than n
            }
            return outputArray;//return value
        }
    }
}
