// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Figuring out way of doing it by stack was difficult. I had to refre leetcode solution for this.


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<T.length;i++){
            while (!stack.isEmpty()&& T[stack.peek()]<T[i]){
               int popped = stack.pop();
                T[popped]= i -popped;
            }
            stack.push(i);
        }
        while(!stack.isEmpty())
        {
            int popped = stack.pop();
            T[popped] = 0;
        }
        return T;
    }
}