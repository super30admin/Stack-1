import java.util.Stack;

/*
Time Complexity : O(2N)
Space Complexity : O(N) in stack
Approach :
To find the next warmer temperature, lets keep the current temperature in the stack. As soon as you get a larger value,
pop this temperature and resolve it, by storing the index of the larger temperature in the result.
So, keeping adding to stack till you find a larger value.
Keep popping from the stack till a larger value is present in the stack
*/
public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i< size; i++){
            if(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i] ){
                    int popped = stack.pop();
                    result[popped] = i - popped;
                }
            }
            stack.push(i);
        }

        return result;
    }
}
