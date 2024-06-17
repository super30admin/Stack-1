package Stack-1;
// TC: O(2*n)
// SC: O(n)
public class Problem2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n=nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                int poppedIdx = st.pop();
                result[poppedIdx]=nums[i%n];
            }
            if(i<n) st.push(i%n);
            else if(i%n==st.peek()) break;
        }
        return result;
    }
}
