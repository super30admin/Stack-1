// TC: O(n)
// SC: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0);
        int n = temperatures.length;
        Stack<Integer> indexStack = new Stack<>();
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            while(!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]){
                int idx = indexStack.pop();
                result[idx] = i - idx;
            }
            indexStack.push(i);
        }
        return result;
    }
}
