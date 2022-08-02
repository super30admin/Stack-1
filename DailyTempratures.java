import java.util.Arrays;
import java.util.Stack;


//Time Complexity=O(n)
//Space Complexity=O(n)
public class DailyTempratures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;

        int[] result=new int[n];
        Arrays.fill(result,0);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int temp=st.pop();
                result[temp]=i-temp;

            }
            st.push(i);
        }
        return result;
    }
}
