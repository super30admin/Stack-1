//Time Complexity O(N)
//Space Complexity O(N)
//Leetcode tested

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperaturesNSquare(int[] temperatures) {
        for (int i = 0; i < temperatures.length-2; i++) {
            int index = i+1;
            int count=1;
            while (index<temperatures.length){
                if(temperatures[index] > temperatures[i]) break;
                count++;
                index++;
            }
            if(index == temperatures.length && i!= temperatures.length-2){
                temperatures[i] = 0;
            }else{
                temperatures[i] = count;
            }
        }
        int lastElement = temperatures.length-1;
        if(temperatures[lastElement] > temperatures[lastElement - 1]){
            System.out.print("here "+temperatures[lastElement]+" "+temperatures[lastElement - 1]);
            temperatures[lastElement - 1] = 1;
        }
        else temperatures[lastElement - 1] = 0;
        temperatures[temperatures.length-1] = 0;
        return temperatures;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] map = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                Integer top = stack.pop();
                int diff = i - top;
                map[top] = diff;
            }
            stack.push(i);
        }
        return map;
    }
}
