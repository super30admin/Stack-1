// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[temperatures.length];
        //Go through all the elements
        for(int i=0; i<temperatures.length; i++){
            //If stack is empty or the element in stack is greater or equal than the current elemnt, we put current in stack
            if(stk.isEmpty() || temperatures[stk.peek()] >= temperatures[i]){
                stk.push(i);
            }
            //If we find the elemnt greater than the element in stack, we calculate the number of days
            else{
                while(!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]){
                    int j = stk.pop();
                    result[j] = i-j;
                }
                stk.push(i);
            }
        }

        return result;
    }
}