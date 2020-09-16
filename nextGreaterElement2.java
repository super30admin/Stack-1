//time complexity: O(3n)
//space complexity: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        Arrays.fill(result,-1);
        for(int i=0;i<2*n;++i)  //2n
        {
            while(!stack.isEmpty() && nums[i%n]>nums[stack.peek()])
            {
                int index = stack.pop();
                result[index] = nums[i%n];  //n
            }
            if(i<n)
            {
                stack.push(i);
            }
        }
        return result;
    }
} 