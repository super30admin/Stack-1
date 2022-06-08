import java.util.Stack;

public class DailyTemperature {

    // TC : O(N)
    // SC : O(n) - worst case, we'll be putting all the elements into the stack
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return new int[]{};

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        // As long as we get a smaller element, put it in the stack
        for(int i=0; i< temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int position = stack.pop();
                result[position] = i - position;
            }
            stack.push(i);
        }
        return result;
    }
}
