// Time Complexity: O(2n) -> O(n)
// Space Complexity: O(n)
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[]{};
        int n = nums.length;
        Stack<Integer> st = new Stack<>(); // will store the number
        // since we need to compare the element on left also as its is circular
        int result[] = new int[n];
        Arrays.fill(result, -1);
        for(int i = 0; i < 2 *n ; i++)
        {
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n])
            {
                int idx = st.pop();
                result[idx] = nums[i%n]; 
            
            }
            // do not push in second pass
            if(i < n)
                st.push(i); // since we are going 2 times
        }
        
        return result;
    }
}
