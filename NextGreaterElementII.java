//T.C: O(N);
//S.C: O(1);
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<(2*n); i++)
        {
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                result[st.peek()] = nums[i%n];
                st.pop();
            }
            if(i<n)
                st.push(i);
        }
        return result;
    }
}