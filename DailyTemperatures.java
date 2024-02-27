// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: Monotonic stack

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s= new Stack<>();
        int n=temperatures.length;
        int arr[]=new int[n];
        for(int i=0; i<n;i++){
            while(!s.isEmpty() && temperatures[s.peek()]<temperatures[i]){
                int popped=s.pop();
                arr[popped]=i-popped;
            }
            s.push(i);
        }
        return arr;
    }
}