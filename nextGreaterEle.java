/*
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //base
        if(nums.length == 0) {
            return new int[] {};
        }
        
        //variables
        int n = nums.length;

        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> s = new Stack<>();

        //logic
        for(int i=0; i < 2*n; i++){
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]){
                int popVal = s.pop();
                result[popVal] = nums[i % n];
            }
            if(i < n) {
                s.push(i);
            }
        }
        return result;
    }
}