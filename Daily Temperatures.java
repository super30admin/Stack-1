//Time Complexity : O(n)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T==null||T.length==0){
            return new int[]{};
        }
        //use stack to keep track of indices of smaller temperatures
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        //iterate through the array
        for(int i=0;i<T.length;i++){
            //if any temp is less than the current temp add its index into the stack
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                //pop the index as we can determine the index of its next increaing temp
                int idx = stack.pop();
                result[idx] = i-idx;
            }
            //otherwise push into stack
            stack.push(i);
        }
        return result;
   }
 }