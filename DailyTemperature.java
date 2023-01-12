// Time Complexity : O(n)
// Space Complexity : O(n) // stack memory 
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N

// Your code here along with comments explaining your approach
//USed to stack to store all the elements untill i reach a next greater element for the values present in the stack
//and all the left over indices in the stack doesnt have any future warmer temp, so 0 for them

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        // base case
        if (temp.length < 2)
            return new int[] { 0 };
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < temp.length; i++) {
            while (!st.isEmpty() && temp[i] > temp[st.peek()]) {
                int ind = st.pop();
                temp[ind] = i - ind;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            temp[st.pop()] = 0;
        }
        return temp;
    }
}