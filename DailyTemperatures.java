import java.util.Arrays;
import java.util.Stack;
/*
Time Complexity: O(N), N is the length of temperatures array
Space Complexity: O(N), I am using Stack
Run on Leetcode: yes
Any difficulties: No

Approach: **Well Commented Code**
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures){
        // edge condition
        if(temperatures == null || temperatures.length == 0){
            return null;
        }

        /*
        Using Stack to maintain the indices of temperature array in order to compare the value
        based on the comparison value will calculate the difference from the next higher temperature
        and assigning it to the result array
         */
        int[] result = new int[temperatures.length];
        Stack<Integer> tempIndex = new Stack<>();

        for(int i = 0; i<temperatures.length; i++){
            int currentTemp = temperatures[i];
            /*
            If tempIndex stack is not empty and next temperature is greater that the previous on
            then popping the index and updating result for the same index
             */
            while(!tempIndex.isEmpty() && temperatures[tempIndex.peek()]<currentTemp){
                int prevIndex = tempIndex.pop();
                result[prevIndex] = i-prevIndex;
            }
            tempIndex.push(i);
        }

        return result;
    }
    public static void main(String[] args){
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println("day to get a warmer temperature: "+ Arrays.toString(dailyTemperatures(temperatures)));
    }
}
