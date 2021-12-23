package sol;
import java.util.Stack;

public class Temprature {
	
	//time : O(n)
	//Space: O(n)
	public int[] dailyTemperatures(int[] temperatures) {
	     
        Stack<Integer> s= new Stack<>();
        
        for( int i=0;i<temperatures.length;i++){
            
            while(!s.isEmpty()&&temperatures[s.peek()]<temperatures[i]){
             
                temperatures[s.peek()]=i-s.peek();
                s.pop();
            }
            
            s.push(i);
            
        }
        
        while(!s.isEmpty()){
            
            temperatures[s.pop()]=0;
        }
        return temperatures;
    }
}
