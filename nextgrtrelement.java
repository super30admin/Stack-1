// tc: O(n)
// sc: O(n)


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        Stack<Integer> s= new Stack<>();
        Arrays.fill(ans,-1);
        for(int i=0;i<2*n;i++){
           
            while(!s.isEmpty() && nums[i%n]>nums[s.peek()]){
                int idx=s.pop();
                ans[idx]=nums[i%n];
                
            }
            if(i<n){
                s.push(i);
            }
             if(i>n && i%n>s.peek()){
                break;
            }
        }
        return ans;
    }
}
