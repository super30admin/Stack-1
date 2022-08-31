//Time Complexity: O(n); where n is the length of nums array.
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem2 {

    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        Stack<Integer> s = new Stack<>();
        
        for(int i =0; i < 2*n; i++)
        {
            
            while(!s.isEmpty() && nums[i%n] > nums[s.peek()])
            {
                int idx = s.pop();
                result[idx] = nums[i%n];
            }
            
            if(i < n)
                s.push(i);
        }
        
        return result;
    }
}
