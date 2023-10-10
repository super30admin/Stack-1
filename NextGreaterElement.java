// TC : O(n)
// SC : O(n)


// Using Stack
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();

        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        //if(nums == null || nums.length == 0) return new int[-1];

        for(int i = 0; i < nums.length*2 ; i++){
            if(i>nums.length ){
                if (st.peek() == i%nums.length) {
                    break;
                }
            }
            while(!st.isEmpty() && nums[st.peek()] < nums[i%nums.length]){
                int popped = st.pop();
                result[popped] = nums[i%nums.length];

            }
            if(i < nums.length ){
                st.push(i);
            }
        }
    return result;

    }
}