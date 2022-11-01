// Time Complexity : O(N)
// Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Use the concept of monotonic stacks
*/
public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0) return new int[]{};

        int[] result= new int[nums.length];
        Stack<Integer> stack= new Stack<>();

        for(int i=0;i<nums.length;i++) result[i]=-1;

        for(int i=0;i<2*nums.length;i++){
            while(!stack.isEmpty() && nums[i%nums.length]>nums[stack.peek()]){
                int idx=stack.pop();
                result[idx]= nums[i%nums.length];
            }
            if(result[i%nums.length]==-1)
                stack.push(i%nums.length);
        }

        return result;
    }
}
