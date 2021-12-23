package sol;
import java.util.Stack;

public class NextGreater {

	
	//time : O(n)
	//Space: O(n)
	
	 public int[] nextGreaterElements(int[] nums) {
		    Stack<Integer> s= new Stack<>();
		        int []nums1= new int[nums.length];
		        for( int i=0;i<2*nums.length;i++){
		           // System.out.println(s);
		            int index=i%nums.length;
		            
		            if(i>nums.length){
		                
		                 while(!s.isEmpty()&&nums[index]>nums[s.peek()]){
		                
		                nums1[s.pop()]=nums[index];
		                
		            }
		            }else{
		            while(!s.isEmpty()&&nums[index]>nums[s.peek()]){
		                
		                nums1[s.pop()]=nums[index];
		                
		            }
		            s.push(index);
		            }
		        }
		        
		        while(!s.isEmpty()){
		            
		            nums1[s.pop()]=-1;
		        }
		        
		       return nums1; 
		    }
		    
		    
	
	
}

