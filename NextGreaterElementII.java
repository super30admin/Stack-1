// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: Monotonic stack
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        Stack<Integer>s= new Stack<>();
        int arr[]= new int[n];
        Arrays.fill(arr,-1);
        for(int i=0; i<2*n;i++){
            while(!s.isEmpty() && nums[s.peek()]<nums[i%n]){
                int popped=s.pop();
                arr[popped]=nums[i%n];
            }
            if(i<n){
                s.push(i);
            }
        }
        return arr;
    }
}