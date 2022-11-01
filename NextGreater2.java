/*
Time Complexity: O(n)
Space Complexity: O(n)
*/
import java.util.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> a=new Stack<Integer>();
        // a.push(0);
        int[] ans=new int[nums.length];
        //O(n)
         Arrays.fill(ans,-1);
        //O(2n) 2passes and O(2n) for the stack
        for(int i=0;i<nums.length*2;i++){
            while(!a.isEmpty()&&nums[i%nums.length]>nums[a.peek()]){
                ans[a.pop()]=nums[i%nums.length];
            }
            a.push(i%nums.length);
        }
        return ans;
    }
}