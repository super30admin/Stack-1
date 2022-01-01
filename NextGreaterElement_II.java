// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.HashSet;
import java.util.Stack;

public class NextGreaterElement_II {
	public int[] nextGreaterElements(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int[] result=new int[nums.length];
        Stack<Integer> stack=new Stack<>();
        int i=0;
        int count=0;
        while(count!=2){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                if(!set.contains(stack.peek())){
                    result[stack.peek()]=nums[i];
                    set.add(stack.peek());
                }
                stack.pop();
            }
            
            stack.push(i);
            i++;
            if(i==nums.length){
                i=0;
                count++;
            }
        }
        
        while(!stack.isEmpty()){
            int index=stack.pop();
            if(!set.contains(index)){
                result[index]=-1; 
            }
       
        }
        return result;
    }
}
