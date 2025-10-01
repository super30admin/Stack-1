
//time complexity O(n)
//space complexity O(n)

//We use a stack to keep track of the indices of the elements for which we haven't found the next greater element yet.
//We iterate through the array twice (to simulate the circular nature) and for each element, 
//we check if it is greater than the element at the index stored at the top of the stack.
//If it is, we pop the index from the stack and update the result array with the current element's value.


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!stk.isEmpty() &&nums[i%n]>nums[stk.peek()]){
                ans[stk.pop()]=nums[i%n];
            }
            stk.push(i%n);
        }
        return ans;
    }
}