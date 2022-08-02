// Time Comp: O(n)
// Space Comp: O(n)
public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<2*n; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int idx = st.pop();
                result[idx] = nums[i%n];
            }
            if(i < n){
                st.push(i);
            }
        }
        return result;
    }
}
