import java.util.Arrays;
import java.util.Stack;

//Time Complexity : O(n)
//Space Complexity : O(n)
public class NextGreaterElement_II {	
	/**Approach: Monotonic increasing Stack**/
	public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0) return new int[0];
        int n= nums.length;        
        Stack<Integer> st= new Stack<>();
        int[] res= new int[n];
        Arrays.fill(res, -1);
        boolean flag= false;//optimization
        
        for(int i=0; i<2*n; i++){
        	if(flag) break;//optimization
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                res[st.pop()] = nums[i%n];
                if(i>n-1 && i%n == st.peek()) flag= true; //optimization
            }
            if(i < n) st.push(i);
        }
        return res;
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		NextGreaterElement_II ob  = new NextGreaterElement_II();		
		int[] nums = {1,2,1};
		System.out.println("Next greater elements in circular array are: "+Arrays.toString(ob.nextGreaterElements(nums))); // return False
	}
}
