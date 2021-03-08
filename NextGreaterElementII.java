//Problem 131:  Next Greater Element II
//TC:O(3N), forr filling -1 and for iterating over array twice because array is circular=>O(N)
//SC:O(N)

/*Steps
Bruteforce: TC:O(n^2) || SC:O(1): Check for each element from the next index to the current index-1, in a circular way, whenever next greater element is found just break from the loop.

Optimized: Using Stack, Try to resove the peak element, i.e if incoming element is greater that the peak element then just pop the peek element and map current element value to the popped index.
*/

import java.util.*;
class Solution131 {
    public int[] nextGreaterElements(int[] nums) {
     
        if(nums==null || nums.length==0) return new int[0];
        
        //TC:O(3N)=>O(N) || SC:O(N)
        int res[] = new int[nums.length];
        
        Arrays.fill(res,-1);
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<2*n;i++){//O(2N)
            
             while(!stack.isEmpty() && nums[i%n]>nums[stack.peek()]){//is current element can resolve the peek element 
                 int idx = stack.pop();//resolve the stack peek element
                 res[idx] = nums[i%n];
             }
            if(i<n) stack.push(i);//because once all elements are traversed no need to push them again during the second traversal
        }
        
        //TC:O(n^2) || SC:O(1)
        /*for(int i=0;i<nums.length;i++){
            
            int max = -1;
            int start = (i+1)%nums.length;
            
            while(i!=start){
              if(nums[start]>nums[i]) {
                  max = nums[start];
                  break;
              } 
              start = (start+1)%nums.length; 
            }
            res[i] = max;
        }*/
        
        return res;
    }
}


