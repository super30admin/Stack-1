import java.util.Arrays;
import java.util.Stack;

//Time Complexity - O(n)
//Space Complexity- O(n)
//Sucessfully ran on leetcode

class Solution {
 public int[] nextGreaterElements(int[] nums) {
     if(nums == null || nums.length == 0) return new int[]{};
     
     if(nums.length ==1) return new int[] {-1};
     
     int n= nums.length;
     Stack<Integer> s = new Stack<>();
     int[] result = new int[n];
     Arrays.fill(result, -1);
     
     for(int i=0; i< n*2; i++){
         
         while(!s.isEmpty() && nums[i%n]> nums[s.peek()]){
             int idx = s.pop();
             result[idx]= nums[i%n];
         }
         if(i<n){
             s.push(i);
             }
     }
     return result;
 }
}