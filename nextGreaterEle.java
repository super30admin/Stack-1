//time complexity O(3n) since we are iterating over an array of length 2n and n is the size of the stack in worst case
//space complexity O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        int i = 0;
        for(i = 0; i < 2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int idx = st.pop();
                result[idx] = nums[i%n];
            }
            if(i < n) st.push(i);
        }
        return result;
    }
}
