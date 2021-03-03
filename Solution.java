//Time Complexity: O(n^2)
//Space Complexity: O(1)
//Brute Force
class Solution {
    public int[] dailyTemperatures(int[] T) {
         int [] res = new int[T.length];
        if(T.length == 0 || T == null)return res;
        for(int i = 0; i<T.length;i++){
            for(int j=i+1;j<T.length;j++){
                if(T[j]>T[i]){
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }
}

//Optimised using Stack
//Time Complexity: O(N)
//Space Complexity: O(N)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        if(T.length == 0 || T == null)return result;
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<T.length;i++){
            while(!st.isEmpty()  && T[i] >T[st.peek()]){
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        return result;
    }
}