//Time Complexity: O(n); where n is the length of temperatures array.
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem1 {

    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> s = new Stack<>();
        
        int n = temperatures.length;
        int[] result = new int[n];
        
        for(int i =0; i <n; i++)
        {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()])
            {
                int idx = s.pop();
                result[idx] = i - idx;
            }
            
            s.push(i);
        }
        
        return result;
    }
}
