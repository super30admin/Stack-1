//Time Complexity: O(n).
//Space Compexity: O(n).

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0 || nums == null) return new int[]{};
        
        if(nums.length == 1) return new int[]{-1};
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        
        int n = nums.length;
        Stack<Integer> s = new Stack();
        
        for(int i = 0; i < 2*n; i++){
            
            while(!s.isEmpty() && nums[i%n] > nums[s.peek()]){
                int idx = s.pop();
                result[idx] = nums[i%n];
            }
            if( i < n)
                s.push(i);
        }
    return result;
    }
}