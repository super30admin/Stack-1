// Time Complexity: O(n)
// Space Complexity:O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
             Arrays.fill(res,-1); // n
        
        for(int i=0;i<nums.length;i++){ //n
            
                    while(!st.isEmpty() && nums[i] > nums[st.peek()]){ //n
                        int val = st.pop();
                    res[val] = nums[i];
                    }
                    st.push(i);
            
        }
        
        for(int i=0;i<nums.length;i++){ //n
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){ //n
                        int val = st.pop();
                    res[val] = nums[i];
                    }
            
        }
        return res;
    }
}
