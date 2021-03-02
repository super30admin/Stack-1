import java.util.*;

public class DailyTemprature {
	
	 //TC - o(n)
    //Sc - o(n)
    public int[] dailyTemperatures(int[] T) {
        
        if(T== null || T.length == 0)
            return T;
        
        int n = T.length;
        int [] result = new int [n];
        //next elements can affect visited nums 
        Stack<Integer> st = new Stack<>();
        
        for(int i =0;i<n;i++){
            //if stack is not empty compare curr temp is grater thn peek ele or not
            while(!st.isEmpty() && T[i] > T[st.peek()]) {
                int idx = st.pop();
                //if grater pop the ele and store into result idx
                result[idx] = i - idx;
            }
            //push the elements
            st.push(i);
        }
        return result;
    }

}
