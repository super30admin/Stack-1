package Stack1;

import java.util.Stack;

public class DailyTemperature {
    /* Created by palak on 8/2/2021 */

    /*
        Time Complexity: O(2n)
        Space Complexity: O(n)
    */
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        if(T == null)   return result;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int top = stack.pop(); //resolve
                result[top] = i - top;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
