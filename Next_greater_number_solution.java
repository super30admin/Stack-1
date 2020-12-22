package codes;

public class Next_greater_number_solution {
	  public int[] nextGreaterElements(int[] nums) {
		     // o(n^2) tc
	        // o(1) spc
          int result [] = new int [nums.length];
		        for(int i=0;i<nums.length;i++){
		            
		            int val=-1;
		            
		            int j=i+1;
		            while(j<nums.length){
		                if(nums[j]>nums[i]) {
                           val=nums[j];
                           break;
                       }
		                j++;
		                // day++;
		            }
		            
		            //overflow
		            
		            if(j==nums.length) {
                        j=0;
                       
                       while (j<i){
                           if(nums[j]>nums[i]){
                             val=nums[j];
                               break;
                           } 
		                
                           
                           j++;
                       }
                   }
		            

		            
		            result[i]=val;
		            

		        }
       
       
       return result;
   }
	  
	  
	  
	  
	  
	  
	  
	  // approach 2 
//	  o(n) tc and spc
	  
	  
	  
	   public int[] nextGreaterElements(int[] nums) {
	        int n=nums.length;
	        int []   output_arr= new int [n];
	        Arrays.fill(output_arr,-1);
	        
	        Stack<Integer> stack= new Stack<>();
	        
	        for(int i=0;i<n*2;i++){
	            while(!stack.isEmpty()&& nums[stack.peek()]<nums[i%n]){
	                output_arr[stack.pop()]=nums[i%n];
	            }
	            
	            if(i<n) stack.push(i);
	        }
	        
	        return output_arr;
	    }
	  
	  
}
