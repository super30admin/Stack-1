// Time Complexity : O(N)
// Space Complexity : O(N)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null ||   temperatures.length == 0){
            return new  int[]{};
        }
        int length = temperatures.length;
        Stack<Integer> s = new Stack();
        int[] result = new int[length];
        for(int i = 0; i < length; i++){
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int popped = s.pop();
                result[popped] = i-popped;
            }
            s.push(i);
        }
        return result;
    }
}