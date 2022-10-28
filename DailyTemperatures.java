// Time Complexity : O(2n)
// Space Complexity : O(n)
//  n is the number of elements in given temp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        //null check
        if(temp == null || temp.length == 0)
            return new int[]{};
        int n = temp.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n ; i++){
            while(!st.isEmpty() && temp[i] > temp[st.peek()]){
                int  popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }
}