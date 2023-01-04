// Time Complexity : O(n)
// Space Complexity :O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=-1;
        }
        
        for(int i=0;i<2*n;i++){
            while(!stack.isEmpty() && nums[i%n]>nums[stack.peek()]){
                  res[stack.pop()] = nums[i % n];  
            }
            
            if(i<n){
                stack.push(i);
            }
        }
        return res;
    }
}