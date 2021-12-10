//Timecomplexity:- O(2N).
//Space complexity:-O(n).
//Your code with approach:- here for circular traversal, we can iterate for 2*times of normal length and idx be i%length. only this change to monotonic stack used in previous case.


class Solution {
    public int[] nextGreaterElements(int[] nums) {
      Stack<Integer> cache=new Stack<>();
        int[] output=new int[nums.length];
        Arrays.fill(output,-1);
        for(int i=0;i<2*nums.length;i++){
            int idx=i%nums.length;
            while(!cache.isEmpty()&&nums[cache.peek()]<nums[idx]){
                output[cache.pop()]=nums[idx];
            }
            cache.push(idx);
            }
        return output;
    }
}