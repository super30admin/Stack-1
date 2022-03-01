//Time complexity : O(n)
//Space Complexity :   O(1)
//Did it run on leetcode : yes

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return new int[0];

        int[] result = new int[temperatures.length];

        Stack<Integer> st = new Stack<>();
        // st.push(0);

        for(int i =0; i< temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }

        return result;
    }

}
