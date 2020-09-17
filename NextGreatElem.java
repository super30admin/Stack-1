/*
  Time:O(n)
  Space: O(n)
  Run on LeetCode: yes
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int ret[] = new int[nums.length];

        for(int i = 0 ; i < nums.length; i++){
            while(!stk.isEmpty() && nums[i] > nums[stk.peek()]){
                int indx = stk.pop();
                ret[indx] = nums[i];
            }
            stk.push(i);
        }

        if(!stk.isEmpty()){
            for(int i = 0 ; i < nums.length; i++){
                while(!stk.isEmpty() && nums[i] > nums[stk.peek()]){
                    int indx = stk.pop();
                    ret[indx] = nums[i];
                }
            }
        }
        while(!stk.isEmpty()){
            ret[stk.pop()] = -1;
        }
        return ret;
    }
}
