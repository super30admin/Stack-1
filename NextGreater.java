//Time -O(n)
//Space - O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length==0) return new int[0];
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int n = nums.length;
        for(int i=0; i< 2*nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int curr = st.pop();
                result[curr] = nums[i%n];
            }
            if(i<n) st.push(i);
            if(i >=n && st.peek() == i%n) break;
        }
        return result;

    }
}