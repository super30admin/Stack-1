class Solution {
    // Time Complexity:O(n)
    //Space Complexity:O(n)
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[] {};
        }
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        Arrays.fill(result, -1);
        for(int i=0; i< 2*n ; i++){ 
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]){
                int index = s.pop();
                result[index] = nums[i%n];
            }
            if(i < n){
                s.push(i);
            }
        }
        return result;
        
    }
}
