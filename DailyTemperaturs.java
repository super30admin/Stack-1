import java.util.*;

public class DailyTemperaturs {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperaturs dailyTemperaturs = new DailyTemperaturs();
        int[] result = dailyTemperaturs.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println("The result: "+result);
    }
}