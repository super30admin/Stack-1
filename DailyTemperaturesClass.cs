// TC => O(n)
// SC => O(n)

public class Solution {
    public int[] DailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.Length == 0){
            return null;
        }
        int[] result = new int[temperatures.Length];
        Stack<int> stack = new Stack<int>();
        stack.Push(0);
        for(int i = 1; i < temperatures.Length; i++){
            while(stack.Count > 0 && temperatures[stack.Peek()] < temperatures[i]){
                var index = stack.Pop();
                result[index] = i - index ;
            }
            stack.Push(i);
        }
        return result;
    }
}