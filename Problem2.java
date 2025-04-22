// TC: O(2 * n)
// SC: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && nums[i] > nums[s.peek()]){
                int idx = s.pop();
                result[idx] = nums[i];
            }
            s.push(i);
        }
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && nums[i] > nums[s.peek()]){
                int idx = s.pop();
                result[idx] = nums[i];
            }
        }
        return result;
    }
}
