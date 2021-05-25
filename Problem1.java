// Daily Temperature
// Time Complexity :O(n)
// Space Complexity :O(n) - stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//using stack, we add each index and count the number of previous days, 
import java.util.*;
public class Problem1 {
    public static void main(String[] args){
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        Problem1 p = new Problem1();
        int[] res = p.dailyTemperatures(t);
        for(int i : res){
            System.out.print(i+" ");
        }

    }
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        if(T == null || T.length ==0)
            return T;
        Stack<Integer> st = new Stack<>();
        
        // st.push(0);
        for(int i = 0; i< T.length; i++){
            // if(i==0){
            //     st.push(i);
            // }
            while(!st.isEmpty() && T[st.peek()] < T[i]){
                int pos = st.pop();
                res[pos]= i - pos;
            }
            st.push(i);

        }
        return res;

        
    }
    
}
