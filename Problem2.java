class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length==0){
            return new int[]{};
        }

        int n = nums.length;
        Stack<Integer>s = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for(int i = 0 ; i < 2* n ; i++)
        {
            while(!s.isEmpty() &&  nums[i%n]>nums[s.peek()]){
                int popped = s.pop();
                result[popped] = nums[i%n];
            }
            if(i<n){
                s.push(i);
            }
        }
        return result;
    }
}
