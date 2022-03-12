//Time Complexity: O(n)
//Space Complexity:O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        if(nums==null || nums.length==0)
            return res;
        Arrays.fill(res,-1);
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!stack.isEmpty() && nums[i%n]>nums[stack.peek()]){
                int popped=stack.pop();
                res[popped]=nums[i%n];
            }
            if(i<n){
                stack.push(i);
            }
        }
        return res;
    }
}
