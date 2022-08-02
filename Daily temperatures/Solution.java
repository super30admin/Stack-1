// Time Complexity:O(2n)
// Space Complexity: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>  st = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            result[i]=0;
        }
        for(int i=0;i<temperatures.length;i++){
          if(st.isEmpty()) st.push(i);
            else{
                int val=st.peek();
                if(temperatures[val]>temperatures[i]){
                    st.push(i);
                } else{
                    while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                        int x = st.pop();
                    result[x]=i-x;
                    }
                    
                    st.push(i);
                }
            }
        }
        return result;
    }
}
