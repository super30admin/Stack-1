import java.util.Stack;

/**
 * Time Complexity : O(2n) where n is the number of temperatures in the array
 * Space Complexity : O(n)
 */
public class DailyTemperature{
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        if(T.length == 0 || T == null){return new int[0];}                                              
        Stack<Integer> stk = new Stack<>();
        for(int i  =0; i < T.length; i++){
            while(!stk.isEmpty() && T[i] > T[stk.peek()]){                                              
                int index = stk.pop();                                                                  
                result[index] =  i - index;                                                             
            }
            stk.push(i);                                                                            
        }
        return result;
    }
}