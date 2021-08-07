package Stack1;

public class DailyTemperatures {
	//TC : o(2n) - o(n) to read each temperature and push to stack and o(n) to resolve each from stack. So o(2n)
	//SC : o(n) no. of elements in array
	//Approach : Brute force way is to nested iterations to check next largest element which o(n^2) time
	// Optimized : push each index to stack and check if arr[i] is greater than top of stack. If it is then calculate value at that index(i-index) 
	class Solution {
	    public int[] dailyTemperatures(int[] temperatures) {
	        //null case
	        int[] result = new int[temperatures.length];
	        if(temperatures == null || temperatures.length == 0) return result;
	        
	        Stack<Integer> st = new Stack<>();
	        
	        for(int i=0; i<temperatures.length; i++){
	            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
	                int index = st.pop();
	                result[index] = i - index;
	            }
	                st.push(i);
	        }
	        return result;
	    }
	}
}
