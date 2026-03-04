//Use monotonic decreasing stack
//For every element, do stack.peek. If currele is greater than peeked element, update the value in result and put element in stack.
//After the first iteration, continue the process which helps to identify the bigger element from start once the array is ended.
//TC: O(3n)
//SC: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<2*n;i++){
            while(!(stack.isEmpty()) && nums[stack.peek()]<nums[i%n]){
                int popped=stack.pop();
                ans[popped]=nums[i%n];
            }

            if(i<n){
                stack.push(i);
            }
        }

        return ans;
        
    }
}
