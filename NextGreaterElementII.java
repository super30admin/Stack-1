
/*
 *  Time Complexity: O(N) Where N is the number of elements in the array
 *  Space Complexity: O(N) Used by the Stack space. N is the number of elements in the array
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  We first create a stack and a result array of length N. Also, fill the res array with all -1. In the stack we only store the index of the element since we can always get the value by accessing the input array. Now, we iterate over the input array for twice the length of the array and we compute the index with mod value. For each element we check if its greater than peek index element of the stack, if yes we pop the index in the stack and then update the result array with the value at the current loop index (res[idx] = nums[i%n];). In every iteration we push the current index to the stack only if its the first iteration. In the last we return the result array.
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0) return new int[]{};
        int n=nums.length;
        int res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> s = new Stack<>();
        for(int i=0;i< 2*nums.length;i++){
            int index=i%n;
            while(!s.isEmpty() && nums[index]>nums[s.peek()]){
                int idx = s.pop();
                res[idx] = nums[i%n];
            }    
            if(i<n){
                s.push(index);
            }
        }
        return res;
    }
}
