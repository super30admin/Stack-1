//Time Complexity: O(n)
//Sapce Complexity: O(n)

// maintaining monotonic decreasing stack

class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0) return new int[0];
        int n=nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        st.push(0);

        //we're given circular integer array
        //so we're finding next greater element by going over the nums array again.
        for(int i=0; i<2*n-1; i++){
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()]){
                result[st.pop()] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return result;
    }
}