import java.util.Stack;

public class DailyTemperatures {
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public int[] dailyTemperatures(int[] temperatures) {
        //at each day find the next bigger element
        int[] temp = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = temperatures.length - 1; i >= 0; i--){
            int countDays = 1;
            while(!stack.isEmpty()){
                if(temperatures[i] < stack.peek()){
                    temp[i] = countDays;
                    break;
                }
                else{
                    stack.pop();
                    countDays+= temp[i+countDays];
                }
            }
            if(stack.isEmpty()){
                temp[i] = 0;
            }
            stack.push(temperatures[i]);
        }

        return temp;
    }
}
