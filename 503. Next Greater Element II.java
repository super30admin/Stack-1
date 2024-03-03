class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i<2*n; i++){
            while(!s.isEmpty() && nums[s.peek()] < nums[i%n]){
                int popped = s.pop();
                ans[popped] = nums[i%n];
            }
            if(i<n){
                s.push(i);
            }
        }
    return ans;
    }
}