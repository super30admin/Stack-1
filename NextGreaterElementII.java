// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        Arrays.fill(res,-1);
        for(int i = 0; i < 2*n; i++){
            while(!s.isEmpty() && nums[i%n] > nums[s.peek()]){
                int top = s.pop();
                res[top] = nums[i%n];
            }
            if(i < n) s.push(i);
        }
        return res;
    }
}
