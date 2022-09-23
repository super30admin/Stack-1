//TC - O(n);
//SC - O(n);
//LC - 739
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int len = temperatures.length;
        
        int [] res = new int[len];
        
        for(int i=0;i<len;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int curr = st.pop();
                res[curr] = i-curr;
            }
            st.push(i);
        }
        
        return res;
    }
}