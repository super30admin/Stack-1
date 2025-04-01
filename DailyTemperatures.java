import java.util.Stack;

//TC-O(n) SC-O(n)
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk=new Stack<>();
        int[] result=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int currentTemp = temperatures[i];
            while(!stk.isEmpty() && temperatures[stk.peek()]<currentTemp){
                int prevDay = stk.pop();
                result[prevDay]=i-prevDay;
            }
            stk.push(i);
        }
        return result;
    }
}
