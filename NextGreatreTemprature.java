import java.util.Stack;

// Time O(2N) -> O(N)
// Space O(N)

public class NextGreatreTemprature {
	 public int[] dailyTemperatures(int[] temperatures) {
	        
	        Stack<Integer> stack = new Stack<>();
	        int len = temperatures.length;
	        int[] res = new int[len];
	        
	        for(int i=0;i<len;i++){
	            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
	                int popIndex = stack.pop();
	                res[popIndex] = i - popIndex;
	            }
	            
	            stack.push(i);
	        } 

	        return res;
	    }
}
