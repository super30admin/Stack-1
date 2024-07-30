
/*
 * TIme complexity - O(n)
 * Space complexity - O(n) - constant
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        Stack<Integer> s= new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for(int i = 0; i < 2*n; i++){
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]){
                int popValue = s.pop();
                result[popValue] = nums[i % n];
            }
            if( i < n ){
                s.push(i);
            }
        }
        return result;
    }
}