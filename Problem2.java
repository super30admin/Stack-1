// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Same algorithm as increasing temperatures. except here we have to do one more
//pass to find greater element from the beginning.

class Problem2 {
    public int[] nextGreaterElements(int[] nums) {

        int[] result = new int[nums.length];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0; i<nums.length; i++){

            while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                int x = st.pop();
                result[x] = nums[i];

            }
            st.add(i);
        }

        for(int i=0; i<nums.length; i++){

            while(!st.isEmpty() && nums[i] > nums[st.peek()]){

                int x = st.pop();
                result[x] = nums[i];

            }
        }
        while(!st.isEmpty()){
            int x = st.pop();
            result[x] = -1;
        }
        return result;
    }
}