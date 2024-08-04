// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s= new Stack<>();
        int n = temperatures.length;
        int [] arr = new int[n];

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int popped = s.pop();
                arr[popped] =  i - popped;
            }
            s.push(i);
        }
        return arr;
    }
}