class Solution {

    // Time Complexity : 0(n) where n is the length of the temperatures
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0){
            return new int []{};
        }
        int n = temperatures.length;    //we find the length of the array for our traversal
        int [] result = new int [n];    //we declare an integer array to store the difference in days to return the result
        Stack<Integer> s = new Stack<>();   //we use stack to keep a track of temperatures for which we haven't found a greater temperature in the upcoming days
        for(int i = 0; i < n ; i++){    //for loop to traverse the temperatures
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){    //we check if the stack is empty or not and also compare the current temperature with the ttemperature at top of the stack. If the current temperature is greater than we
                int temp = s.pop(); //pop the top of the stack
                result[temp] = i - temp;    //and go to the index in our resultant array for the same index where the temperature exists in temperatures array and store the difference between the days which is given by the difference in indexes at the top of the stack and current index
            }
            s.push(i);  //push the unresolved temperature on to the stack if the temperature is not higher than the previous index
        }
        return result;  //return result at the end
    }
}