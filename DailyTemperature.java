/*
Brute force linearly comparing every temperature with the enitre list time complexity : O(n^2)
Approach
Place the unresolved temperature's index into the stack and once it is resolved with the next higher temperature place the difference between these 2 indexes and place into the resultant array

Executed in leetcode

Time complexity : O(2n) worst case  because every element is added to stack 73 and then once resolved with higher temperature 74 removed 73 index from stack and placed difference of indexes into the resultant ie 1-0 = 1. Every temperature is visited twice once for addition and once for removing 
Space complexity : O(n) size of stack


*/
class Solution {
    public int[] dailyTemperatures(int[] T) {
      
       if(T== null || T.length == 0 ) return new int[0];
        
        int[] result = new int[T.length];
        Stack<Integer> st = new Stack<>();
        
        for(int idx = 0 ; idx < T.length ; idx++){
        //stack not empty and top of stack is able to be resolved with the temperature T
            while(!st.isEmpty() &&  T[idx] > T[st.peek()]){
                int tempResolvedIdx = st.pop();
                result[tempResolvedIdx] =  idx - tempResolvedIdx;//diff between them 
            }
            st.push(idx);
        }
        return result;
    }
}