/*
*Approach 1: Bruteforce
- Iterate over all the temperature and at each temperature find next warmer day using nested iterations
TC: O(n^2)

* Approach 2:
    - Use stack to keep track of indices for which we have found the warmer day yet
    - Iterate over the temps and keep checking whether the curr temp is greater than the temp at the top of the stack and pop the ones for which we have already found the warmest day 
    - calculate the number of days based on both the indices and store it in the result
TC: O(n) -> its infact 2n -> n for adding the elements to the stack and n for removing elements from the stack
SC: O(n) -> additional stack space for storing the indices
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int popped = stack.pop();
                res[popped] = i - popped;
            }
            stack.push(i);
        }
        return res;
        
    }
}