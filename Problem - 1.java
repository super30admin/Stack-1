// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
Intuition:

This is a monotonic increasing Stack problem.

We have to find the next big temprature/element, so we will keep on putting smaller elements on the stack until we find an element which is greater than the element on the top of the stack.
for all the smaller elements, we will record the diff of indices from the bigger element on the same indice of smaller element on the result array

Time: O(n) // dont be confused by two for loops
Space: O(n)
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<temperatures.length;i++){
            int element = temperatures[i];
            // we will check if the incoming element is bigger than top element in stack, if so we will keep popping all the smaller items 
            while(!stack.isEmpty() && temperatures[stack.peek()] < element){
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        // if there are still elements, then for those there are no bigger element

        while(!stack.isEmpty()){
            int idx = stack.pop();
            result[idx] = 0;
        }

        return result;
    }
}
