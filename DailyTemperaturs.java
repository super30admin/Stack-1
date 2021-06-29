import java.util.*;

public class DailyTemperaturs {

    //O(N^2) - Iterating all the element with each item.
    //O(1) - Not using any extra spac
    public int[] dailyTemperaturesBF(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++) {
            int currentNumber = temperatures[i];
            for(int j=i+1;j<n;j++) {
                if(temperatures[j] > currentNumber) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    //O(N) - Iterating all the element only one time
    //O(N) - Using stack
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