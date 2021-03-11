//Time Complexity: o(n)
//Space Complexity: o(n)
//Expln: Iterate over the nums array twice by pushing elements into the stack only when the corresponding result is -1 else skip adding
// So if the incoming element is greater than st.peek() replace the element iterate while stack is not empty
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[len];
        Arrays.fill(result, -1);
        if(len ==0) return result;
        
        for(int i = 0; i < 2 * len; i++)
        {
            while(!st.isEmpty())
            {
                if(nums[i % len] > nums[st.peek()])
                {
                    result[st.pop()] = nums[i % len];
                }
                else
                    break;
            }
            if(result[i%len] == -1)
            {
                st.push(i%len);
            }
        }
        return result;
    }
}