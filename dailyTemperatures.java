// Time Complexity = O(n)
// Space Complexity = O(n)

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    if(temperatures == null || temperatures.length == 0) return new int[]{};

    int n = temperatures.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i<n; i++) {
      while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int current = stack.pop();
        result[current] = i-current;
      }
      stack.push(i);
    }
    return result;
  }
}