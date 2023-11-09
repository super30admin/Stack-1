// Time Complexity : O(n) where n is the size of temperatures array
// Space Complexity : O(n) in worst case all elements in temperatures will go in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0){
            return temperatures;
        }

        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int index = s.pop();
                result[index] = i - index;
            }
            s.push(i);
        }
        return result;
    }
}
