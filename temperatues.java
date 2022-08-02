class Solution {
  //TC: O(2n) SC:O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int [] result=new int[n];
        if(n==1)return result;
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int indx=st.pop();
                result[indx]=i-indx;
                
            }
            st.push(i);
            
            
        }
        return result;
    }
}
