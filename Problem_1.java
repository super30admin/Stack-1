// Time Complexity :O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result=new int[T.length];
        for(int i=0;i<T.length;i++){
            for(int j=i+1;j<T.length;j++){
                if(T[j]>T[i]){
                    result[i]=j-i;
                    break;
                }
            }
        }
        
        return result;
    }
}

//more efficine tolution
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result=new int[T.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<T.length;i++){
           while(!st.isEmpty() && T[i]>T[st.peek()]){
               int index=st.pop();
               result[index]=i-index;
           }
            st.push(i);
        }
        
        return result;
    }
}

