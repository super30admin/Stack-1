/*Running Time Complexity: O(2n)
Space Complexity: Omega(n)
Successfully Run and Compiled on leetcode.
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length]; 
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        Arrays.fill(res,-1);
        for(int slow=0;slow<2*nums.length;slow++){
            while(!st.empty() && nums[slow%n]>nums[st.peek()]){
                int temp = st.pop();
                res[temp] = nums[slow%n];
            }
            if(slow<n) st.push(slow);
            // System.out.print(st); System.out.println(slow);
        }
     return res;   
    }
}