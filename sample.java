

//problem-1 Temperature
// Time Complexity :O(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Tried with brute force referred class for the stack approach
// Your code here along with comments explaining your approach: Here we will maintain the stack. We will fill
// the stack with indices. Before entering an elemet into the stack we check if the incoming index is greater than
// the peek element referring in array. If it is greater than we put the difference of the incoming index and peek of the stack
// in the result, else we push element into the stack.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int [] result= new int[temperatures.length];
        Stack<Integer> stk= new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && temperatures[i]>temperatures[stk.peek()]){
                int temp=stk.pop();
                result[temp]=i-temp;
            }
            stk.push(i);
        }
        return result;
    }
}
//problem-2 Next Greater element
// Time Complexity :O(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Tried with brute force referred class for the stack approach
// Your code here along with comments explaining your approach: Here intially we will fill all the indices of the
//result array with -1. We follow the similar approach of the above problem but here we will iterate twice the length
// because it is given as circular array.So for finding the the next greater element we traverse twice.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int [] result=new int [nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> stk= new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!stk.isEmpty()&& nums[stk.peek()] < nums[i%n]){
                int temp=stk.pop();
                result[temp]=nums[i%n];
            }
            stk.push(i%n);
        }

        return result;
    }
}