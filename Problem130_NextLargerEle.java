//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        //base ase
        if(nums == null || n == 0)
            return result;
        //initially fill the array with -1
        Arrays.fill(result, -1);
        //initialize stack
        Stack<Integer> st = new Stack();
        //looping over the array twice since we can search circularly
        //over the array
        for(int i = 0; i < n*2; i++){
            //check for edge case and if incoming element is greater than top of stack
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                //remove the stack element
                //and set the value as the popped element in the array
                result[st.pop()] = nums[i%n];
            }
            //if incoming element is less than n -> push
            if(i<n)
                st.push(i);
        }
        return result;
    }
}