// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Temperature {
    
    public int[] dailyTemperatures(int[] temperatures) {
        int[] warm = new int[temperatures.length];
        Stack<Integer> st = new Stack();
        for(int i=0;i<temperatures.length;i++){
           
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int popped = st.pop();
                warm[popped] = i-popped;
            }
            st.push(i);
        }return warm;
    }
}