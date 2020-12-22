// Time Complexity : o(2n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 
// Leetcode : 739
//Approach: Stack

class Solution {
    public int[] dailyTemperatures(int[] T) {
       if(T == null || T.length == 0 ) return new int[0] ;
        
        //Stack
        Stack<Integer> st = new Stack<>();
        //Result array
        int [] res = new int[T.length];

        //Add elements till the current is greater than the previous element
        //Then once we get the next greater element, add the difference of st.pop and ith indexes value
        for(int i = 0 ; i < T.length; i++){
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int index = st.pop();
                res[index] = i - index;
            }
            st.push(i);      
        }
        return res;
     }
}