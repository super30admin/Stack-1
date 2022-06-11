// Time Complexity: O(n) where n is the length of the array.
// Space Complexity: O(n) where n is the length of the array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 0 || temperatures == null) return new int[] {};
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> s = new Stack<>();   // For storing indices.
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int top = s.pop();
                answer[top] = i - top;
            }
            s.push(i);
        }
        return answer;
    }
}