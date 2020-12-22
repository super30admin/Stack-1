package codes;

public class DailyTemperatures_solution {

	  public int[] dailyTemperatures(int[] T) {
		     // o(n^2) tc
		        // o(1) spc
		        int result [] = new int [T.length];
		        for(int i=0;i<T.length;i++){
		            
		            int day=0;
		            
		            int j=i;
		            while(j<T.length){
		                if(T[j]>T[i]) break;
		                j++;
		                day++;
		            }
		            
		            //overflow
		            
		            if(j==T.length) day=0;
		            
		            
		            result[i]=day;
		            

		        }
		        
		        
		        return result;
		    }
	  
	  
	  
	  
	  // approach 2
//	  O(n) tc and spc
	  
	  public int[] dailyTemperatures2(int[] T) {
	        int[] result = new int[T.length];
	Stack<Integer> stack = new Stack<>(); // Make it a stack of indices.
	for (int i = 0; i < T.length; i++) {
	    while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
	        int index = stack.pop();
	        result[index] = i - index;
	    }
	    stack.push(i);
	}
	return result;
	    }
}
