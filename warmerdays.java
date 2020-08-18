
//Time complexity:O(n)
//Space complexity:O(n)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T==null || T.length==0){
            return new int[] {};
        }
        Stack<Integer> st=new Stack();
        for(int i=0;i<T.length;i++){
            while(!st.isEmpty() && T[i]>T[st.peek()]){
                int temp=st.pop();
                T[temp]=i-temp;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            T[st.pop()]=0;
        }
        return T;
    }
}