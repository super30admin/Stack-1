// Time Complexity : O(N) where N is the length of the array 
// Space Complexity : O(N) where N is the number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s1 = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        s1.add(0);
        for(int i = 1; i < n; i ++) {
            if(!s1.isEmpty() && temperatures[i] > temperatures[s1.peek()]) {
                while(!s1.isEmpty() && temperatures[i] > temperatures[s1.peek()]) {
                    int temp = s1.pop();
                    result[temp] = i - temp;
                }
                s1.add(i);
            }
            else
                s1.add(i);
        }
        return result;
    }
}
