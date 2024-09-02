// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[temperatures.length];
        int n=temperatures.length;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int poped=stack.pop();
                res[poped] = i - poped;
            }
            stack.push(i);
        }
        return res;
    }
}


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack= new Stack<>();
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++)
            res[i]=-1;
        for(int i=0;i<2*n;i++)
        {
            int index=i%n;
            while(!stack.isEmpty() && nums[index]>nums[stack.peek()]){
                int poped=stack.pop();
                res[poped]=nums[index];
            }
            if(i<n)
                stack.push(index);
        }
        return res;
    }
}