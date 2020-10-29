// Time Complexity : O(n)
// Space Complexity : O(n) for additional stack space 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//to traverse the given array in circular manner, we consider the index upper bound as twice the length of input
//we fill the arry with -1 as we have to return 1 when there are no greater elements
//take the modulo of the i to get the index of the input array
//if stack is not empty and the stack's top is less than curr ele, then make the top element as the current element
//if not, just push the element's index to stack (to ensure re processing of elements, we only push elements whose value is -1 in the output)
//return the array

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null||nums.length==0){
            return new int[0];
        }
        int[] output=new int[nums.length];
        Stack<Integer> res=new Stack<>();
        Arrays.fill(output,-1);
        int len=nums.length, index=0;
        for(int i=0;i<2*len;i++){
            index=i%len;
            
            while(!res.isEmpty() && nums[index]>nums[res.peek()]){
                int top=res.pop();
                output[top]=nums[index];
            }
            if(output[index]==-1){
            res.push(index);
            }
        }
        return output;
    }
}