import java.util.Stack;

//Time: O(n), 2n -> n, n once for the for loop and the second time while checking for the warmer day
//Space: O(n)

//Example: 
//temperatures = [73, 74, 69, 71, 74, 79, 86, 51, 50, 69]
//Stack = [73, -> [74, -> [74, 69 -> [74, 71 -> [74, 74 -> [79 -> [86 -> [86, 51 -> [86, 51, 50 -> [86, 69
//result = [1, 4, 1, 1, 1, 1, 0, 2, 1, 0]

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        
        //null case check
        if(n == 0 || temperatures == null) return new int[0];
        
        //creating a result array to store the number of days to wait until we encounter a warmer day
        int [] result = new int [n];
        
        //Stack to store the indexes of the days until we find a warmer day
        Stack<Integer> st = new Stack<>();
        
        //now looping through each temporature one at a time
        for(int i = 0; i < n; i++) {
            //we keep looping until we find a day with temp higher than that at index at the top of the stack
            //we check if the stack is empty because at first element we do not have anything in stack to compare with
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                //if we find it then we pop that index from the stack and store it in idx
                int idx = st.pop();
                //for that index we then store the difference of the index at the top of stack and store it at it's respective location in the results array
                result[idx] = i - idx;
            }
            //we push the new index to the top of the stack
            st.push(i);
        }
        return result;
    }
}