// Time Complexity : O(n)
// Space Complexity : O(n)

/*
 * we traverse though the array and until we find an element greater than
 * the one we have it in stack we add the elements and move to next until we 
 * reach the element again in the array. Once we find it we append the 
 * number to the result.
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for(int i = 0; i < 2*n; i++){
            int idx = i%n;
            while(!st.isEmpty() && nums[idx] > nums[st.peek()]){
                result[st.pop()] = nums[idx];
            }
            if(i < n){
                st.push(idx);
            }
        }
        return result;
    }
}