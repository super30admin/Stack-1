//Brute:nested loop
//Time = O(n^2)
//Space = O(1)

//monotonic stack
//time = O(3n) = O(2n) for 2 times traversal + (n) for stack
//space = O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result,-1);
        for(int i = 0; i < 2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int poppedIdx = st.pop();
                result[poppedIdx] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return result;
    }
}