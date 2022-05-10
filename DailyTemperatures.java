import java.util.Arrays;
import java.util.Stack;

//Time Complexity : O(n)
//Space Complexity : O(n)
public class DailyTemperatures {	
	/**Approach: Monotonic increasing Stack**/
	public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures==null || temperatures.length==0) return new int[0];
        
        int n= temperatures.length;
        Stack<Integer> st= new Stack<>();
        int[] res= new int[n];
        
        for(int i=0; i<n; i++){
        	//if next element is resolving top of the stack
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int popped = st.pop();
                res[popped]= i - popped;
            }
            st.push(i);
        }
        return res;
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		DailyTemperatures ob  = new DailyTemperatures();		
		int[] temperatures = {73,74,75,71,69,72,76,73};
		System.out.println("No. of days to wait next warmer temperature: "+Arrays.toString(ob.dailyTemperatures(temperatures))); // return False
	}
}
