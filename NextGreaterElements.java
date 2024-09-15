// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : The space complexity is O(n) where n is the length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        if(nums == null || nums.length == 0){
            return new int[0];
        }

        int n = nums.length;
        int[] output = new int[n];
        Stack<Integer> s = new Stack<>();
        Arrays.fill(output,-1);

        // 1st pass
        for(int i=0;i<n;i++){

            int val = nums[i];

            // replace with the first next greatest element
            while(!s.isEmpty()){
                if(nums[s.peek()] < val){
                    output[s.pop()] = val;
                }
                else{
                    break;
                }
            }

            s.push(i);
        }

        int i = 0;

        //2nd pass to check in circle
        while(!s.isEmpty() && i!=s.peek()){
            if(nums[s.peek()] < nums[i]){
                output[s.pop()] = nums[i];
            }
            else{
                i++;
            }
        }

        return output;

    }
}