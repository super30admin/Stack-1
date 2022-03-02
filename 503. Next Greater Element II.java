// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We resort to monotonic stack to solve this problem. brute force would be n^2 solution where inner loop of j is dependent on  outer loop of i, so stack is a data structrure
//that can be used

//we push the first element in the stck first, then styart comparing elements from 1st element onwards, when we find element greater than peek element we pop it and keep on checking.
//one checking is done we add that element to stack. we do this till we reach end of array

//we use the concept of onotonic stack here
//we build the stack if we dnt find next element greater, once we find it we check with the peek till peek isnt smaller and add this new element to stack afterwards

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<temperatures.length; i++){
            while((!stack.empty()) && (temperatures[i] > temperatures[stack.peek()])){
                int popped = stack.pop();
                result[popped] = i - popped;
            }
            stack.push(i);
        }
        return result;
    }
}
